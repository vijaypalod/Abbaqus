package com.abbaqus.redditfeed;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.abbaqus.redditfeed.adapters.FeedListAdapter;
import com.abbaqus.redditfeed.databinding.ActivityRedditFeedListBinding;
import com.abbaqus.redditfeed.db.AppDatabase;
import com.abbaqus.redditfeed.model.Reddit;
import com.abbaqus.redditfeed.viewmodels.FeedListViewModel;

public class RedditFeedListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Reddit.Data feedList;
    public ActivityRedditFeedListBinding binding;
    private FeedListViewModel feedViewModel;
    private FeedListAdapter adapter;
    private String selectedSubreddit = "popular";
    private Observer<Reddit.Data> feedObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        feedObserver = new Observer<Reddit.Data>() {
            @Override
            public void onChanged(@Nullable Reddit.Data data) {
                feedList = data;
                updateUi();
                persistData();
            }
        };
        initComponents();

    }

    private void initComponents() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reddit_feed_list);
        setSupportActionBar(binding.appBar.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.appBar.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        binding.navView.setNavigationItemSelectedListener(this);
        binding.appBar.contentView.srlFeed.setColorSchemeColors(getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorAccent));
        binding.appBar.contentView.srlFeed.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateFeed();
            }
        });
        feedViewModel = ViewModelProviders.of(this).get(FeedListViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        feedViewModel.isLoading.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                binding.appBar.contentView.srlFeed.setRefreshing(aBoolean);
            }
        });
        updateFeed();
    }

    private void updateFeed() {
        if (Utility.isNetworkConnected(this)) {
            feedViewModel.getFeedLiveData(selectedSubreddit).observe(this, feedObserver);
        } else {
            feedList = feedViewModel.getFeedFromDb(AppDatabase.getAppDatabase(this).getRedditDao(), selectedSubreddit).getValue();
            if (feedList != null && feedList.children.size() > 0) {
                updateUi();
            } else {
                Toast.makeText(this, "Please check network and try again", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm != null && cm.getActiveNetworkInfo() != null;
    }

    private void persistData() {
//        AppDatabase.getAppDatabase(this).getRedditDao().clearTable();
        feedList.subreddit = selectedSubreddit;
        AppDatabase.getAppDatabase(this).getRedditDao().insertReddit(feedList);
    }

    private void updateUi() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        binding.appBar.contentView.rvFeed.setLayoutManager(manager);
        adapter = new FeedListAdapter(this, feedList.children);
        adapter.setListener(new RecyclerViewClickListener() {
            @Override
            public void onClick(int position, View view) {
                ImageDialogFragment.newInstance(feedList.children.get(position).data.preview.images.get(0).resolutions.get(feedList.children.get(position).data.preview.images.get(0).resolutions.size() - 1).url).show(getSupportFragmentManager(), "ImageDialogFragment");
            }

            @Override
            public void onShareClick(int position, View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Share");
                i.putExtra(Intent.EXTRA_TEXT, "http://redd.it/" + feedList.children.get(position).data.id);
                startActivity(i);
            }
        });
        binding.appBar.contentView.rvFeed.setAdapter(adapter);
    }


    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        selectedSubreddit = item.getTitle().toString().substring(1);
        updateFeed();
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
