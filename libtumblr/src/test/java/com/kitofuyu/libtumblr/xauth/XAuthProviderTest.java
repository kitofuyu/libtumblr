package com.kitofuyu.libtumblr.xauth;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import com.kitofuyu.libtumblr.xauth.XAuthProvider;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

public class XAuthProviderTest{
    
    private String consumerKey;
    private String consumerSecret;
    private String userName;
    private String passWord;
    
    @Before
    public void setUp() throws IOException{
        InputStream in = new FileInputStream(new File("test_properties/test.properties"));
        Properties prop = new Properties();
        prop.load(in);
        consumerKey = prop.getProperty("consumerKey");
        consumerSecret = prop.getProperty("consumerSecret");
        userName = prop.getProperty("userName");
        passWord = prop.getProperty("passWord");
    }
    
    @Test
    public void testRetrieveAccessToken() {
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(consumerKey,consumerSecret);
        XAuthProvider provider = new XAuthProvider(
                "http://www.tumblr.com/oauth/request_token",
                "https://www.tumblr.com/oauth/access_token",
                "http://www.tumblr.com/oauth/authorize");
        try {
            provider.retrieveAccessToken(consumer, userName, passWord);
        } catch ( Exception e) {
              e.getStackTrace();
              fail("exception is throwed");
        }
        
        assertNotNull("token is : " + consumer.getToken() , consumer.getToken());
        assertNotNull("token secret is : " + consumer.getTokenSecret(), consumer.getToken());
    }
}
