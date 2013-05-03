package com.kitofuyu.libtumblr.resources;
/**
 * Text type of the post
 * @author kitofuyu
 *
 */
public class Text extends Post {
    private String title;
    private String body;
    
    /**
     * get the optional title of the post
     * @return
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * set the optional title of the post
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * get the full post body
     * @return
     */
    public String getBody() {
        return body;
    }
    
    /**
     * set the full post body
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }
    
}
