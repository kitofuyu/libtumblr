package com.kitofuyu.libtumblr.resources;

/**
 * General blog's Information
 * @author kitofuyu
 *
 */
public class Blog extends Default {
    private String base_hostname;
    private String title;
    private int posts;
    private String name;
    private long updated;
    private String descriotion;
    private boolean ask;
    private boolean ask_anon;
    private int likes;
    
    /* Blog info API does not return these fields.
      * User info API returns these blog's information.
     */ 
    private String url;
    private boolean primary;
    private long followers;
    private String tweet;
    private String facebook;
    private String type;
    
    public String getBase_hostname() {
        return base_hostname;
    }
    public void setBase_hostname(String base_hostname) {
        this.base_hostname = base_hostname;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPosts() {
        return posts;
    }
    public void setPosts(int posts) {
        this.posts = posts;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getUpdated() {
        return updated;
    }
    public void setUpdated(long updated) {
        this.updated = updated;
    }
    public String getDescriotion() {
        return descriotion;
    }
    public void setDescriotion(String descriotion) {
        this.descriotion = descriotion;
    }
    public boolean isAsk() {
        return ask;
    }
    public void setAsk(boolean ask) {
        this.ask = ask;
    }

    public boolean isAsk_anon() {
        return ask_anon;
    }

    public void setAsk_anon(boolean ask_anon) {
        this.ask_anon = ask_anon;
    }
    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public boolean isPrimary() {
        return primary;
    }
    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
    public long getFollowers() {
        return followers;
    }
    public void setFollowers(long followers) {
        this.followers = followers;
    }
    public String getTweet() {
        return tweet;
    }
    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
    public String getFacebook() {
        return facebook;
    }
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    

}
