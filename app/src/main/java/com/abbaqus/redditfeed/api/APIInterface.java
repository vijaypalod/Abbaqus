package com.abbaqus.redditfeed.api;

import com.abbaqus.redditfeed.model.Reddit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("/r/{subreddit}.json")
    Call<Reddit> getRedditFeed(@Path("subreddit") String subreddit);

}