package com.kitofuyu.libtumblr.resources;

import java.util.List;

/**
 * Chat type of the post
 * @author kitofuyu
 *
 */
public class  Chat extends Post {
    private String title;
    private String body;
    private List<Dialogue> dialogue;
    
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
     * get the full chat body
     * @return
     */
    public String getBody() {
        return body;
    }
    
    /**
     * set the full chat body
     * @param body
     */
    public void setBody(String body) {
        this.body = body;
    }
    
    /**
     * get list of the dialogues
     * @return
     */
    public List<Dialogue> getDialogue() {
        return dialogue;
    }
    
    /**
     * set list of the dialogues
     * @param dialogue
     */
    public void setDialogue(List<Dialogue> dialogue) {
        this.dialogue = dialogue;
    }
    
}
