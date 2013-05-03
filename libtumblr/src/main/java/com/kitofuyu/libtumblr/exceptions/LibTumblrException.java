package com.kitofuyu.libtumblr.exceptions;
/**
 * Default libtumblr exception.
 * Represents a problem in the using this Library.
 * @author kitofuyu
 */
public class LibTumblrException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public LibTumblrException(String message) {
        super(message);
    }
    
    public LibTumblrException(String message, Exception e) {
        super(message, e);
    }
    
}
