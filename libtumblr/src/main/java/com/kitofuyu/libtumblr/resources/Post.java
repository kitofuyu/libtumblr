package com.kitofuyu.libtumblr.resources;

import java.util.List;

/**
 * Base type of all Post.
 * @author kitofuyu
 *
 */
public class Post extends Default {
    private String blog_name;
    private long id;
    private String post_url;
    private String type;
    private long timestamp;
    private String date;
    private String format;
    private String reblog_key;
    private List<String> tags;
    private boolean bookmarklet;
    private boolean mobile;
    private String source_url;
    private String source_title;
    private boolean liked;
    private String state;
    private long total_posts;
    
    /**
     * get the blog name
     * @return the blog name for the post
     */
    public String getBlogName() {
        return blog_name;
    }
    /**
     * set the blog name for the post
     * @param blogName
     */
    public void setBlogName(String blogName) {
        this.blog_name = blogName;
    }
    
    /**
     * get the id for the post
     * @return id
     */
    public long getId() {
        return id;
    }
    
    /**
     * set the id for the post
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * get the location(URL) of the post
     * @return the URL of the post
     */
    public String getPostUrl() {
        return post_url;
    }
    
    /**
     * set the location(URL) of the post
     * @param postUrl
     */
    public void setPost_url(String postUrl) {
        this.post_url = postUrl;
    }
    
    /**
     * get the type of the post
     * @return type of the post, following:  text, quote, link, answer, video, audio, photo, chat
     */
    public String getType() {
        return type;
    }
    
    /**
     * set the type of the post
     * @param type following:  text, quote, link, answer, video, audio, photo, chat
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * get the time of the post, in seconds since the epoch
     * @return 
     */
    public long getTimestamp() {
        return timestamp;
    }
    
    /**
     * set the time of the post, in seconds since the epoch
     * @param timestamp  
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
     * get the GMT date and time of the post, as a string
     * @return
     */
    public String getDate() {
        return date;
    }
    
    /**
     * set the GMT date and time of the post, as a string
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * get the post format: html or markdown
     * @return
     */
    public String getFormat() {
        return format;
    }
    
    /**
     * set the post format: html or markdown
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }
    
    /**
     * get the key used to reblog this post
     * @return
     */
    public String getReblog_key() {
        return reblog_key;
    }
    
    /**
     * set the key used to reblog this post
     * @param reblog_key
     */
    public void setReblog_key(String reblog_key) {
        this.reblog_key = reblog_key;
    }
    
    /**
     * get tags applied to the post
     * @return
     */
    public List<String> getTags() {
        return tags;
    }
    
    /**
     * set tags applied to the post
     * @param tags
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
    /**
     * Indicates whether the post was created via the Tumblr bookmarklet
     * @return
     */
    public boolean isBookmarklet() {
        return bookmarklet;
    }
    
    /**
     * Indicates whether the post was created via mobile/email publishing
     * @return
     */
    public boolean isMobile() {
        return mobile;
    }
    
    /**
     * get the URL for the source of the content (for quotes, reblogs, etc.)
     * @return
     */
    public String getSourceUrl() {
        return source_url;
    }
    
    /**
     * set the URL for the source of the content (for quotes, reblogs, etc.)
     * @param sourceUrl
     */
    public void setSourceUrl(String sourceUrl) {
        this.source_url = sourceUrl;
    }
    
    /**
     * get the title of the source site
     * @return
     */
    public String getSourceTitle() {
        return source_title;
    }
    
    /**
     * set the title of the source site
     * @param sourceTitle
     */
    public void setSourceTitle(String sourceTitle) {
        this.source_title = sourceTitle;
    }
    
    /**
     * Indicates if a user has already liked a post or not
     * @return
     */
    public boolean isLiked() {
        return liked;
    }
    
    /**
     * Indicates the current state of the post
     * @return States are published, queued, draft and private
     */
    public String getState() {
        return state;
    }
    
    /**
     * set indication the current state of the post
     * @param state States are published, queued, draft and private
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * get the total number of post available for this request, useful for paginating through results
     * @return
     */
    public long getTotalPosts() {
        return total_posts;
    }
    
    /**
     * set he total number of post available for this request, useful for paginating through results
     * @param totalPosts
     */
    public void setTotalPosts(long totalPosts) {
        this.total_posts = totalPosts;
    }

}
