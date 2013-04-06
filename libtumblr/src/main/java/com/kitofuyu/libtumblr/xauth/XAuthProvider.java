package com.kitofuyu.libtumblr.xauth;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

import com.kitofuyu.libtumblr.util.util;

public class XAuthProvider {

    String requestTokenEndpointUrl;
    String accessTokenEndpointUrl;
    String authorizationWebsiteUrl;
    
    public XAuthProvider(String requestTokenEndpointUrl,
                  String accessTokenEndpointUrl,
                  String authorizationWebsiteUrl) {
        this.requestTokenEndpointUrl = requestTokenEndpointUrl;
        this.accessTokenEndpointUrl = accessTokenEndpointUrl;
        this.authorizationWebsiteUrl = authorizationWebsiteUrl;
    }
    
    
    public synchronized void retrieveAccessToken(OAuthConsumer consumer,
                                                String username,
                                                String password) 
                                                        throws OAuthMessageSignerException, 
                                                        OAuthExpectationFailedException, 
                                                        OAuthCommunicationException, 
                                                        ClientProtocolException,
                                                        IOException, OAuthNotAuthorizedException  {
        
        ArrayList<BasicNameValuePair> xauth_params = new ArrayList<BasicNameValuePair>();
        xauth_params.add(new BasicNameValuePair(XAuth.XAUTH_MODE, XAuth.CLIENT_AUTH));
        xauth_params.add(new BasicNameValuePair(XAuth.XAUTH_USERNAME, username));
        xauth_params.add(new BasicNameValuePair(XAuth.XAUTH_PASSWORD, password));
        HttpPost post = new HttpPost(this.accessTokenEndpointUrl);
         
         try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(xauth_params);
            post.setEntity(entity);
            consumer.sign(post);
            HttpClient client = new DefaultHttpClient();
            HttpResponse response = client.execute(post);
              
            util.checkHttpResponseCode(response);
            
            String responseContent = util.convertToString(response.getEntity().getContent());
              
            String[] pair = responseContent.split("&");
            String[] tokens = new String[2];
            tokens[0] = pair[0].split("=")[1];
            tokens[1] = pair[1].split("=")[1];
              
            consumer.setTokenWithSecret(tokens[0], tokens[1]);
         } catch (UnsupportedEncodingException e) {
             throw new OAuthNotAuthorizedException("URL encode failed.");
          }
    }
}
