package com.kitofuyu.libtumblr.resources;

import java.util.List;

/**
 * The user's account information class
 * @author kitofuyu
 *
 */
public class User extends Default {
    private long following;
    private String default_post_format;
    private String name;
    private long likes;
    private List<Blog> blogs;
    
    /**
     * get the number of blog the user is following
     * @return
     */
    public long getFollowing() {
        return following;
    }
    
    /**
     * set the number of blog the user is following.
     * @param following
     */
    public void setFollowing(long following) {
        this.following = following;
    }
    
    /**
     * get the default posting format - html, markdown or raw
     * @return
     */
    public String getDefaultPostFormat() {
        return default_post_format;
    }
    
    /**
     * set the default posting format - html, markdown or raw
     * @param defaultPostFormat
     */
    public void setDefaultPostFormat(String defaultPostFormat) {
        this.default_post_format = defaultPostFormat;
    }
    
    /**
     * get the users's tumblr short name
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     * set the users's tumblr short name
     * @return
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * get the total count of users's likes
     * @return
     */
    public long getLikes() {
        return likes;
    }
    
    /**
     * set the total count of user's likes
     * @param likes
     */
    public void setLikes(long likes) {
        this.likes = likes;
    }
    
    /**
     * get the list of the blogs the user can post to
     *  each Blog object has these field
     *  @see Blog
     *  - name
     *  - url
     *  - title
     *  - primary
     *  - followers
     *  - tweet
     *  - facebook
     *  - type
     * @return
     */
    public List<Blog> getBlogs() {
        return blogs;
    }
    
    /**
     * set the list of the blogs the user can post to
     * @param blogs
     */
    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    } 

}
