package com.kitofuyu.libtumblr.resources;
/**
 * alternate photo size and location of  the photo file
 * @author kitofuyu
 *
 */
public class AltPhotoSize {
    private long width;
    private long height;
    private String url;
    
    /**
     * get width of the photo, in pixels
     * @return
     */
    public long getWidth() {
        return width;
    }
    
    /**
     * set width of the photo, in pixels
     * @param width
     */
    public void setWidth(long width) {
        this.width = width;
    }
    
    /**
     * get height of the photo, in pixels
     * @return
     */
    public long getHeight() {
        return height;
    }
    
    /**
     * set height of the photo, in pixels
     * @param height
     */
    public void setHeight(long height) {
        this.height = height;
    }
    
    /**
     * get the location of the photo file
     * @return
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * set the location of the photo file
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
}
