package com.kitofuyu.libtumblr.resources;

import java.util.List;

/**
 * a Photo in a Photo or a PhotoSets
 * @author kitofuyu
 *
 */
public class PhotosElement {
    
    private String caption;
    private List<AltPhotoSize> alt_sizes;
    
    /**
     * get user supplied caption for the individual photo (Photosets only)
     * @return
     */
    public String getCaption() {
        return caption;
    }
    
    /**
     * set user supplied caption for the individual photo (Photosets only)
     * @param caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    /**
     * get list of alternate photo sizes and photo url
     * @return
     */
    public List<AltPhotoSize> getAltSize() {
        return alt_sizes;
    }
    
    /**
     * set list of alternate photo sizes and photo url
     * @param altSize
     */
    public void setAlt_size(List<AltPhotoSize> altSizes) {
        this.alt_sizes = altSizes;
    }
}
