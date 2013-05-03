package com.kitofuyu.libtumblr.resources;

/**
 * Quote type of the post
 * @author kitofuyu
 *
 */
public class Quote extends Post {
    private String text;
    private String source;
    
    /**
     * get the text of the quote
     * @return
     */
    public String getText() {
        return text;
    }
    
    /**
     * set the text of the quote
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }
    
    /**
     * get the source of the quote
     * @return FULL HTML for the source
     */
    public String getSource() {
        return source;
    }
    
    /**
     * set the source of the quote
     * @param sourceFULL HTML for the source of the quote
     */
    public void setSource(String source) {
        this.source = source;
    }
   
}
