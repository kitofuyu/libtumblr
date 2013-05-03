package com.kitofuyu.libtumblr.resources;

/**
 * Lint type of the post
 * @author kitofuyu
 *
 */
public class Link extends Post{
    private String title;
    private String url;
    private String description;
    
    /**
     * get the title of the page of the link points to
     * @return
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * set the title of the page of the link points to
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * get the link
     * @return
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * set the link
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * get a user-supplied description
     * @return
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * set a description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
