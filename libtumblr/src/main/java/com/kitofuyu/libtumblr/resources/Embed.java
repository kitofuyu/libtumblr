package com.kitofuyu.libtumblr.resources;
/**
 * embedding the video player
 * @author kitofuyu
 *
 */
public class Embed {
    private long width;
    private String embed_code;
    
    /**
     * get width of the video
     * @return
     */
    public long getWidth() {
        return width;
    }
    
    /**
     * set width of the video
     * @param width
     */
    public void setWidth(long width) {
        this.width = width;
    }
    
    /**
     * get HTML for embedding the video player
     * @return
     */
    public String getEmbedCode() {
        return embed_code;
    }
    
    /**
     * set HTML for embedding the video player
     * @param embedCode
     */
    public void setEmbedCode(String embedCode) {
        this.embed_code = embedCode;
    }
}
