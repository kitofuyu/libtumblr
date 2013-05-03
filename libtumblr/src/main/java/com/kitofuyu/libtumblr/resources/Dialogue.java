package com.kitofuyu.libtumblr.resources;

/**
 * Chat dialogue
 * @author kitofuyu
 *
 */
public class Dialogue {
    private String name;
    private String label;
    private String phrase;
    
    /**
     * get the name of the speaker
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     * set the name of the speaker
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * get the label of the speaker
     * @return
     */
    public String getLabel() {
        return label;
    }
    
    /**
     * set the label of the speaker
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }
    
    /**
     * get the text
     * @return
     */
    public String getPhrase() {
        return phrase;
    }
    
    /**
     * set the text
     * @param phrase
     */
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }
}
