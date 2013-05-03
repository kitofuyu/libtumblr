package com.kitofuyu.libtumblr.resources;

import java.util.List;

/**
 * Photo type or PhotoSets type of the post
 * @author kitofuyu
 *
 */
public class Photo extends Post {
    private List<PhotosElement> photos;
    private String caption;
    private long width;
    private long height;
    
    /**
     * get photo element objects
     * @see PhotosElement
     * @return
     */
    public List<PhotosElement> getPhotos() {
        return photos;
    }
    
    /**
     * set photo element objects
     * @param photos
     */
    public void setPhotos(List<PhotosElement> photos) {
        this.photos = photos;
    }
    
    /**
     * get the user-supplied caption
     * @return
     */
    public String getCaption() {
        return caption;
    }
    
    /**
     * set the user-supplied caption
     * @param caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    /**
     * get the width of the photo or photosets
     * @return
     */
    public long getWidth() {
        return width;
    }
    
    /**
     * set the width of the photo or photosets
     * @param width
     */
    public void setWidth(long width) {
        this.width = width;
    }
    
    /**
     * get the height of the photo or photosets
     * @return
     */
    public long getHeight() {
        return height;
    }
    
    /**
     * set the height of the photo or photoset
     * @param height
     */
    public void setHeight(long height) {
        this.height = height;
    }
}
