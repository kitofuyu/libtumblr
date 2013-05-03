package com.kitofuyu.libtumblr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.kitofuyu.libtumblr.exceptions.LibTumblrException;
import com.kitofuyu.libtumblr.request.RequestBuilder;
import com.kitofuyu.libtumblr.resources.Blog;
import com.kitofuyu.libtumblr.resources.Meta;
import com.kitofuyu.libtumblr.resources.Post;
import com.kitofuyu.libtumblr.resources.User;
import com.kitofuyu.libtumblr.xauth.XAuthProvider;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

public class Tumblr {

    private final String API_URI = "http://api.tumblr.com/v2";
        private OAuthConsumer consumer;
        private RequestBuilder requestBuilder;
        private XAuthProvider provider = new XAuthProvider(
                    "http://www.tumblr.com/oauth/request_token",
                    "https://www.tumblr.com/oauth/access_token",
                    "http://www.tumblr.com/oauth/authorize");
        
        private String consumerKey;
        private String consumerSecret;
        private String apiKey;
        private boolean authorized;

         
         /**
         * create instance of Tumblr client (not authorized) 
         * @param consumerKey 
         * @param consumerSecret client application's consumer secret key
          */
        public Tumblr(String consumerKey, String consumerSecret) {
            this.consumerKey = consumerKey;
            this.consumerSecret = consumerSecret;
            this.apiKey = consumerKey;
            this.authorized = false;
            this.consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
            requestBuilder = new RequestBuilder();
         }
        /**
         * create instance of authorized Tumblr client 
        * @param consumerKey client application's consumer key
        * @param consumerSecret client application's consumer secret key
        * @param oauthToken authorized OAuth token
        * @param tokenSecret authorized OAuth      secret token
         */
        public Tumblr(String consumerKey, String consumerSecret, String oauthToken, String tokenSecret) {
            this.consumerKey = consumerKey;
            this.consumerSecret = consumerSecret;
            this.apiKey = consumerKey;
            this.consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
            this.apiKey = consumerKey;
            this.authorized = true;
            consumer.setTokenWithSecret(oauthToken, tokenSecret);
            requestBuilder = new RequestBuilder();
            requestBuilder.setConsumer(consumer);
        }
        
        /**
         * @return the consumerKey
         */
        public String getConsumerKey() {
            return consumerKey;
        }
        /**
         * @return the consumerSecret
         */
        public String getConsumerSecret() {
            return consumerSecret;
        }
        
        /**
         * @return if client is authorized , return true
         */
        public boolean isAuthorized() {
            return this.authorized;
        }
        
        /**
         * @return the OAuth token
         * @throws OAuthNotAuthorizedException 
         */
        String getOAuthToken() throws OAuthNotAuthorizedException {
          if (this.authorized) {
              throw new OAuthNotAuthorizedException();
            }
            return consumer.getToken();
         }
        
        /**
         * @return the OAuth token secret
         * @throws OAuthNotAuthorizedException 
         */
        String getOAuthTokenSecret() throws OAuthNotAuthorizedException {
            if (this.authorized) {
                throw new OAuthNotAuthorizedException();
              }
            return consumer.getTokenSecret();
        }
        
        /**
         * send user name and password to retrieve access token
         * @param username name of account on Tumblr ( this is should be user's mail address )
         * @param password password
         */
        public void authorize(String username, String password) {
            
            try {
                this.provider.retrieveAccessToken(consumer, username, password);
            } catch (OAuthExpectationFailedException e) {
                throw new LibTumblrException(e.getMessage(), e);
            } catch (OAuthNotAuthorizedException e) {
                throw new LibTumblrException(e.getMessage(), e);
            } catch (OAuthCommunicationException e) {
                throw new LibTumblrException(e.getMessage(), e);
            } catch (OAuthMessageSignerException e) {
                throw new LibTumblrException(e.getMessage(), e);
            } catch (IOException e) {
                throw new LibTumblrException(e.getMessage(), e);
             }
            this.authorized = true;
            requestBuilder.setConsumer(consumer);
        }
        
        

        
        /**
         * retrieve a Blog Information
         * @param blogHostname                    
         * @return
         */
        public Blog retrieveBlogInfo(String blogHostname) {
            String uri = this.API_URI + "/blog/" + blogHostname + "/info" + "?api_key=" + apiKey;
            return requestBuilder.APIkeyGet(uri).getBlog();
        }
        /**
         * retrieve a Blog Avatar
         * @param blogHostname
         * @param size The size of the avatar. Must be one of the values : 0,16, 24, 30, 40, 48, 64, 96, 128, 512
         *             (0 means default size : 64)
         */
        public String retriveBlogAvatar(String blogHostname, int size) {
            String uri = this.API_URI + "/blog/" + blogHostname + "/avater";
            if (size != 0) {
                uri = uri + "/size/" + size;
              }
            return requestBuilder.Get(uri);
         }
        
        /**
         *  retrieve a Blog Avatar (default size)
         * @param blogHostname
         * @return

         */
        public String retriveBlogAvatar(String blogHostname) {
            return this.retriveBlogAvatar(blogHostname, 0);
         }
        
        /**
         * retrieve blog's followers
         * @param blogName
         * @return
         */
        public List<User> retrieveFollowers(String blogName) {
            String uri = this.API_URI + "/blog/" + blogName + "/followers";
            System.out.println(uri);
            return requestBuilder.OAuthGet(uri).getUsers();
        }
        
        /**
         * retrieve Dashboard
         * @param params API parameters Map 
         * @return
         */
        public List<Post> retrieveDashboard(Map<String, String> params) {
            String uri = this.API_URI + "/user/dashboard";
            uri = constructQueryURI(uri, params);
            return requestBuilder.OAuthGet(uri).getPosts();
        }
        public List<Post> retrieveDashboard() {
            return retrieveDashboard(null);
        }
        
        /**
         * retrieve Dashboard
         * @param limit the number of results : 1 ... 20
         * @param offset post number to start at
         * @param notes_info Indicates whether to return notes information (specify true or false). Returns note count and note metadata. 
         * @return
         */
        public List<Post> retrieveDashboard(int limit, int offset, boolean notes_info ) {
           Map<String, String> params = new HashMap<String, String>();
           params.put("limit", String.valueOf(limit));
           params.put("offset", String.valueOf(offset));
           if (notes_info) {
               params.put("notes_info", String.valueOf(notes_info));
             }
           
           return retrieveDashboard(params);
        }
        
        /**
         * reblg the post
         * @param blogName blog hostname the post is in
         * @param id the id of the post
         * @param reblogKey the reblog key of the post
         * @param options additional options
         * @return
         */
        public Meta reblog(String blogName, Long id, String reblogKey, Map<String, String> options) {
            String uri = this.API_URI + "/blog/" + blogName + "/post/reblog";
            
            List<NameValuePair> params = new ArrayList<NameValuePair>(); 
            if (options != null) {
                for (String key : options.keySet()) {
                    params.add(new BasicNameValuePair(key, options.get(key)));
                  }
                }
            
            params.add(new BasicNameValuePair("id", String.valueOf(id)));
            params.add(new BasicNameValuePair("reblog_key", reblogKey));
            
           return requestBuilder.OAuthPost(uri, params).getMeta();
        }
        
        /**
         * reblog the post
         * @param blogName blogName blog hostname the post is in
         * @param post reblogged 
         * @return
         */
        public Meta reblog(String blogName, Post post) {
            return reblog(blogName, post.getId(), post.getReblog_key(), null);
        }
        
        private String constructQueryURI(String baseURI, Map<String,?> params) {
            StringBuilder builder = new StringBuilder(baseURI);
            if (params != null) {
                builder.append('?').append(constructQueryParameter(params));
              }
            return builder.toString();
        }
        private String constructQueryParameter(Map<String, ?> params) {
            StringBuilder builder = new StringBuilder();
            for (String key : params.keySet()) {
                builder.append('&').append(key).append('=').append(params.get(key));
              }
            return builder.substring(1);
        }
        

    
}
