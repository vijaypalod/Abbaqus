package com.abbaqus.redditfeed.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.abbaqus.redditfeed.db.ChildTypeConverter;

import java.util.List;


public class Reddit {

    @SerializedName("kind")
    @Expose
    public String kind;

    @SerializedName("data")
    @Expose
    public Data data;


    @Entity(tableName = "reddit_feed")
    public static class Data {


        @PrimaryKey
        @NonNull
        public String subreddit;

        @SerializedName("modhash")
        @Expose
        public String modhash;
        @SerializedName("dist")
        @Expose
        public int dist;
        @TypeConverters(ChildTypeConverter.class)
        @SerializedName("children")
        @Expose
        public List<Child> children = null;

        @SerializedName("after")
        @Expose
        public String after;

        @Ignore
        @SerializedName("before")
        @Expose
        public Object before;
    }
}