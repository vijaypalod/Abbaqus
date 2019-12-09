package com.abbaqus.redditfeed.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.abbaqus.redditfeed.model.Reddit;

/**
 * Abbaqus
 * Created by Administrator on 21-07-2018.
 */

@Dao
public interface RedditDao {

    @Update
    public void updateReddit(Reddit.Data... reddits);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertReddit(Reddit.Data... reddits);


    @Query("SELECT * FROM REDDIT_FEED Where subreddit like :subReddit ")
    public Reddit.Data getReddit(String subReddit);


    @Query("DELETE FROM REDDIT_FEED")
    public void clearTable();

}
