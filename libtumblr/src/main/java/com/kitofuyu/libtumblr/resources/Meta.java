package com.kitofuyu.libtumblr.resources;

/**
 * Matches Http status message.
 * @author kitofuyu
 */
public class Meta {
    /**
     * the Http status code
     */
    private int status;
    
    /**
     * the Http Reason Phrase
     */
    private String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
