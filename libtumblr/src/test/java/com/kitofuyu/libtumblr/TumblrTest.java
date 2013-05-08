package com.kitofuyu.libtumblr;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.kitofuyu.libtumblr.Tumblr;
import com.kitofuyu.libtumblr.resources.Post;

import org.junit.Before;
import org.junit.Test;

public class TumblrTest {
    private String consumerKey;
    private String consumerSecret;
    private String userName;
    private String passWord;
    private String reblogTo;
    
    @Before
    public void setUp() throws IOException{
        InputStream in = new FileInputStream(new File("test_properties/test.properties"));
        Properties prop = new Properties();
        prop.load(in);
        consumerKey = prop.getProperty("consumerKey");
        consumerSecret = prop.getProperty("consumerSecret");
        userName = prop.getProperty("userName");
        passWord = prop.getProperty("passWord");
        reblogTo = prop.getProperty("reblogTo");
    }
    
    @Test
    public void reblogFromDashBoard() {
        Tumblr tumblr = new Tumblr(consumerKey, consumerSecret);
        
        // authorize
        tumblr.authorize(userName, passWord);
         
        // retrive dashboard
        List<Post> postList = tumblr.retrieveDashboard(10,0,true);
        Post reblog = postList.get(0);
        
        // reblog
        tumblr.reblog(reblogTo, reblog);
       
    }
    
    @Test
    public void like() {
        Tumblr tumblr = new Tumblr(consumerKey, consumerSecret);
        
        // authorize
        tumblr.authorize(userName, passWord);
         
        // retrive dashboard
        List<Post> postList = tumblr.retrieveDashboard(10,0,true);
        Post likePost = postList.get(0);
        
        // like
        tumblr.like(likePost);
        
        // retrieve likes
        List<Post> likeList = tumblr.retrieveLikes();
        Post likedPost = likeList.get(0);
        
         // check 
        assertEquals(likePost.getId(), likedPost.getId());
    }
}
