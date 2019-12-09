package com.abbaqus.redditfeed.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Ignore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Child {

    @SerializedName("kind")
    @Expose
    public String kind;

    @Embedded
    @SerializedName("data")
    @Expose
    public Data_ data;

    public class Data_ {

        @Ignore
        @SerializedName("approved_at_utc")
        @Expose
        public Object approvedAtUtc;

        @SerializedName("subreddit")
        @Expose
        public String subreddit;

        @SerializedName("selftext")
        @Expose
        public String selftext;

        @Ignore
        @SerializedName("user_reports")
        @Expose
        public List<Object> userReports = null;

        @SerializedName("saved")
        @Expose
        public boolean saved;

        @Ignore
        @SerializedName("mod_reason_title")
        @Expose
        public Object modReasonTitle;

        @SerializedName("gilded")
        @Expose
        public int gilded;

        @SerializedName("clicked")
        @Expose
        public boolean clicked;

        @SerializedName("title")
        @Expose
        public String title;

        @Ignore
        @SerializedName("link_flair_richtext")
        @Expose
        public List<Object> linkFlairRichtext = null;

        @SerializedName("subreddit_name_prefixed")
        @Expose
        public String subredditNamePrefixed;

        @SerializedName("hidden")
        @Expose
        public boolean hidden;

        @SerializedName("pwls")
        @Expose
        public int pwls;

        @Ignore
        @SerializedName("link_flair_css_class")
        @Expose
        public Object linkFlairCssClass;

        @SerializedName("downs")
        @Expose
        public int downs;

        @SerializedName("thumbnail_height")
        @Expose
        public int thumbnailHeight;

        @SerializedName("parent_whitelist_status")
        @Expose
        public String parentWhitelistStatus;

        @SerializedName("hide_score")
        @Expose
        public boolean hideScore;

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("quarantine")
        @Expose
        public boolean quarantine;

        @SerializedName("link_flair_text_color")
        @Expose
        public String linkFlairTextColor;

        @Ignore
        @SerializedName("author_flair_background_color")
        @Expose
        public Object authorFlairBackgroundColor;

        @SerializedName("subreddit_type")
        @Expose
        public String subredditType;

        @SerializedName("ups")
        @Expose
        public int ups;

        @SerializedName("domain")
        @Expose
        public String domain;

        @Embedded
        @SerializedName("media_embed")
        @Expose
        public MediaEmbed mediaEmbed;

        @SerializedName("thumbnail_width")
        @Expose
        public int thumbnailWidth;

        @Ignore
        @SerializedName("author_flair_template_id")
        @Expose
        public Object authorFlairTemplateId;

        @SerializedName("is_original_content")
        @Expose
        public boolean isOriginalContent;

        @Ignore
        @SerializedName("secure_media")
        @Expose
        public Object secureMedia;

        @SerializedName("is_reddit_media_domain")
        @Expose
        public boolean isRedditMediaDomain;

        @Ignore
        @SerializedName("category")
        @Expose
        public Object category;

        @Embedded
        @SerializedName("secure_media_embed")
        @Expose
        public SecureMediaEmbed secureMediaEmbed;

        @Ignore
        @SerializedName("link_flair_text")
        @Expose
        public Object linkFlairText;

        @SerializedName("can_mod_post")
        @Expose
        public boolean canModPost;

        @SerializedName("score")
        @Expose
        public int score;

        @Ignore
        @SerializedName("approved_by")
        @Expose
        public Object approvedBy;

        @SerializedName("thumbnail")
        @Expose
        public String thumbnail;

        @SerializedName("post_hint")
        @Expose
        public String postHint;


        @SerializedName("is_self")
        @Expose
        public boolean isSelf;


        @SerializedName("created")
        @Expose
        public double created;

        @SerializedName("link_flair_type")
        @Expose
        public String linkFlairType;

        @SerializedName("wls")
        @Expose
        public int wls;

        @Ignore
        @SerializedName("post_categories")
        @Expose
        public Object postCategories;

        @Ignore
        @SerializedName("banned_by")
        @Expose
        public Object bannedBy;

        @SerializedName("author_flair_type")
        @Expose
        public String authorFlairType;

        @SerializedName("contest_mode")
        @Expose
        public boolean contestMode;

        @Ignore
        @SerializedName("selftext_html")
        @Expose
        public Object selftextHtml;

        @Ignore
        @SerializedName("likes")
        @Expose
        public Object likes;

        @Ignore
        @SerializedName("suggested_sort")
        @Expose
        public Object suggestedSort;

        @Ignore
        @SerializedName("banned_at_utc")
        @Expose
        public Object bannedAtUtc;

        @Ignore
        @SerializedName("view_count")
        @Expose
        public Object viewCount;

        @SerializedName("archived")
        @Expose
        public boolean archived;

        @SerializedName("no_follow")
        @Expose
        public boolean noFollow;

        @SerializedName("is_crosspostable")
        @Expose
        public boolean isCrosspostable;

        @SerializedName("pinned")
        @Expose
        public boolean pinned;

        @SerializedName("over_18")
        @Expose
        public boolean over18;

        @Embedded
        @SerializedName("preview")
        @Expose
        public Preview preview;

        @SerializedName("media_only")
        @Expose
        public boolean mediaOnly;

        @SerializedName("can_gild")
        @Expose
        public boolean canGild;

        @SerializedName("spoiler")
        @Expose
        public boolean spoiler;

        @SerializedName("locked")
        @Expose
        public boolean locked;

        @Ignore
        @SerializedName("author_flair_text")
        @Expose
        public Object authorFlairText;

        @SerializedName("rte_mode")
        @Expose
        public String rteMode;

        @SerializedName("visited")
        @Expose
        public boolean visited;

        @SerializedName("subreddit_id")
        @Expose
        public String subredditId;

        @SerializedName("id")
        @Expose
        public String id;


        @SerializedName("author")
        @Expose
        public String author;

        @SerializedName("num_crossposts")
        @Expose
        public int numCrossposts;

        @SerializedName("num_comments")
        @Expose
        public int numComments;

        @SerializedName("send_replies")
        @Expose
        public boolean sendReplies;

        @SerializedName("permalink")
        @Expose
        public String permalink;

        @SerializedName("whitelist_status")
        @Expose
        public String whitelistStatus;

        @SerializedName("stickied")
        @Expose
        public boolean stickied;

        @SerializedName("url")
        @Expose
        public String url;

        @SerializedName("subreddit_subscribers")
        @Expose
        public int subredditSubscribers;

        @SerializedName("created_utc")
        @Expose
        public double createdUtc;

        @SerializedName("is_video")
        @Expose
        public boolean isVideo;

        @SerializedName("author_cakeday")
        @Expose
        public boolean authorCakeday;

    }

    public class Image {

        @SerializedName("source")
        @Expose
        public Source source;
        @SerializedName("resolutions")
        @Expose
        public List<Resolution> resolutions = null;
        @SerializedName("variants")
        @Expose
        public Variants variants;
        @SerializedName("id")
        @Expose
        public String id;

    }

    public class Preview {

        @SerializedName("images")
        @Expose
        public List<Image> images = null;
        @SerializedName("enabled")
        @Expose
        public boolean enabled;
        @SerializedName("reddit_video_preview")
        @Expose
        public RedditVideoPreview redditVideoPreview;

    }

    public class RedditVideoPreview {

        @SerializedName("fallback_url")
        @Expose
        public String fallbackUrl;
        @SerializedName("height")
        @Expose
        public int height;
        @SerializedName("width")
        @Expose
        public int width;
        @SerializedName("scrubber_media_url")
        @Expose
        public String scrubberMediaUrl;
        @SerializedName("dash_url")
        @Expose
        public String dashUrl;
        @SerializedName("duration")
        @Expose
        public int duration;
        @SerializedName("hls_url")
        @Expose
        public String hlsUrl;
        @SerializedName("is_gif")
        @Expose
        public boolean isGif;
        @SerializedName("transcoding_status")
        @Expose
        public String transcodingStatus;

    }

    public class MediaEmbed {


    }

    public class Resolution {

        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("width")
        @Expose
        public int width;
        @SerializedName("height")
        @Expose
        public int height;

    }

    public class SecureMediaEmbed {


    }

    public class Source {

        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("width")
        @Expose
        public int width;
        @SerializedName("height")
        @Expose
        public int height;

    }

    public class Variants {

    }
}