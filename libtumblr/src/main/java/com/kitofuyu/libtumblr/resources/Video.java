package com.kitofuyu.libtumblr.resources;

import java.util.List;

public class Video extends Post{
    private String caption;
    private List<Embed> player;
    
    /**
     * get the user-supplied caption
     * @return
     */
    public String getCaption() {
        return caption;
    }
    
    /**
     * set user's caption
     * @param caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    /**
     * get list of video players
     * @return
     */
    public List<Embed> getPlayer() {
        return player;
    }
    
    /**
     * set list of video players
     * @param player
     */
    public void setPlayer(List<Embed> player) {
        this.player = player;
    }
}
