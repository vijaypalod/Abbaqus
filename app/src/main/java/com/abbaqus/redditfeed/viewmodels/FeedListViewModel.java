package com.abbaqus.redditfeed.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.abbaqus.redditfeed.api.APIClient;
import com.abbaqus.redditfeed.api.APIInterface;
import com.abbaqus.redditfeed.db.RedditDao;
import com.abbaqus.redditfeed.model.Reddit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Abbaqus
 * Created by Administrator on 22-07-2018.
 */
public class FeedListViewModel extends ViewModel {

    public MutableLiveData<Reddit.Data> feedLiveData;
    private APIInterface apiInterface;
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public RedditDao dao;

    public LiveData<Reddit.Data> getFeedLiveData(String subreddit) {
        if (feedLiveData == null) {
            feedLiveData = new MutableLiveData<>();
        }
        getFeed(subreddit);
        return feedLiveData;
    }


    public LiveData<Reddit.Data> getFeedLiveData() {
        if (feedLiveData == null) {
            feedLiveData = new MutableLiveData<>();
        }
        return feedLiveData;
    }

    public LiveData<Reddit.Data> getFeedFromDb(RedditDao dao,String subreddit) {
        isLoading.setValue(true);
        if (feedLiveData == null) {
            feedLiveData = new MutableLiveData<>();
        }
        feedLiveData.setValue(dao.getReddit(subreddit));
        isLoading.setValue(false);
        return feedLiveData;
    }

    /**
     * GET List Resources
     **/
    private void getFeed(String subreddit) {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        isLoading.setValue(true);
        Call<Reddit> call = apiInterface.getRedditFeed(subreddit);
        call.enqueue(new Callback<Reddit>() {
            @Override
            public void onResponse(Call<Reddit> call, Response<Reddit> response) {
                Log.d("TAG", response.code() + "");
                isLoading.setValue(false);
                if (response.body() != null) {
                    feedLiveData.setValue(response.body().data);
                }
            }

            @Override
            public void onFailure(Call<Reddit> call, Throwable t) {
                t.printStackTrace();
                isLoading.setValue(false);
                call.cancel();
            }
        });
    }

}
