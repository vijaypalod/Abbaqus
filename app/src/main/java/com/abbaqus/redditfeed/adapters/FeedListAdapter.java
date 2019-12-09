package com.abbaqus.redditfeed.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.abbaqus.redditfeed.R;
import com.abbaqus.redditfeed.RecyclerViewClickListener;
import com.abbaqus.redditfeed.databinding.ItemFeedBinding;
import com.abbaqus.redditfeed.model.Child;

import java.util.List;

/**
 * Abbaqus
 * Created by Administrator on 21-07-2018.
 */
public class FeedListAdapter extends RecyclerView.Adapter<FeedListAdapter.FeedHolder> {

    private List<Child> feedList;
    private final Context context;
    private RecyclerViewClickListener listener;

    public FeedListAdapter(Context context, List<Child> feedList) {
        this.context = context;
        this.feedList = feedList;
    }

    public void setListener(RecyclerViewClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFeedBinding binding = ItemFeedBinding.inflate(LayoutInflater.from(context));
        return new FeedHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final FeedHolder holder, int position) {
        holder.binding.txtFeedTitle.setText(feedList.get(position).data.title);
        holder.binding.txtSubReddit.setText(String.format("%s , %s", feedList.get(position).data.author, feedList.get(position).data.subreddit));

        String imageUrl;
        //Get The image with medium resolution
/*
        if (Utility.isWifiNetwork(context)) {
            if (feedList.get(position).data.preview.images.get(0).resolutions.size() > 2)
                imageUrl = feedList.get(position).data.preview.images.get(0).resolutions.get(2).url;
            else {
                imageUrl=feedList.get(position).data.preview.images.get(0).resolutions.get(1).url;
            }
        } else {
            imageUrl=feedList.get(position).data.preview.images.get(0).source.url;
        }
*/
        if (feedList.get(position).data.thumbnail != null) {
            imageUrl = feedList.get(position).data.thumbnail;
            Glide.with(context).load(imageUrl).into(holder.binding.imgFeed)
                    .onLoadFailed(context.getResources().getDrawable(R.drawable.img_placeholder));

        }

    }

    @Override
    public int getItemCount() {
        return feedList != null ? feedList.size() : 0;
    }

    class FeedHolder extends RecyclerView.ViewHolder {

        private final ItemFeedBinding binding;
        private final TextView tvShare;

        FeedHolder(final ItemFeedBinding binding) {
            super(binding.getRoot());
            this.tvShare = binding.getRoot().findViewById(R.id.tvShare);
            this.binding = binding;
            binding.imgFeed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(getAdapterPosition(), binding.imgFeed);
                }
            });
            this.tvShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onShareClick(getAdapterPosition(), v);
                }
            });
        }
    }
}
