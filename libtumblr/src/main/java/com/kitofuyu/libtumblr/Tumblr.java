package com.kitofuyu.libtumblr;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import com.kitofuyu.libtumblr.util.util;
import com.kitofuyu.libtumblr.xauth.XAuthProvider;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import oauth.signpost.http.HttpParameters;

public class Tumblr {

    private final String API_URI = "http://api.tumblr.com/v2";
        private OAuthConsumer consumer;
        private XAuthProvider provider = new XAuthProvider(
                    "http://www.tumblr.com/oauth/request_token",
                    "https://www.tumblr.com/oauth/access_token",
                    "http://www.tumblr.com/oauth/authorize");
        
        private String consumerKey;
        private String consumerSecret;
        private String apiKey;
        private boolean authorized;
        HttpClient client;
         
         /**
         * create instance of Tumblr client ( not authorized) 
         * @param consumerKey 
         * @param consumerSecret client application's consumer secret key
          */
        public Tumblr(String consumerKey, String consumerSecret) {
            this.consumerKey = consumerKey;
            this.consumerSecret = consumerSecret;
            this.apiKey = consumerKey;
            this.authorized = false;
            this.consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
            this.client = new DefaultHttpClient();
         }
        /**
         * create instance of authorized Tumblr client 
        * @param consumerKey client application's consumer key
        * @param consumerSecret client application's consumer secret key
        * @param oauthToken authorized OAuth token
        * @param tokenSecret authorized OAuth secret token
         */
        public Tumblr(String consumerKey, String consumerSecret, String oauthToken, String tokenSecret) {
            this.consumerKey = consumerKey;
            this.consumerSecret = consumerSecret;
            this.apiKey = consumerKey;
            this.consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
            this.apiKey = consumerKey;
            this.authorized = true;
            consumer.setTokenWithSecret(oauthToken, tokenSecret);
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
         * @throws IOException 
         * @throws OAuthNotAuthorizedException 
         * @throws ClientProtocolException 
         * @throws OAuthCommunicationException 
         * @throws OAuthExpectationFailedException 
         * @throws OAuthMessageSignerException 
         */
        public void authorize(String username, String password) throws OAuthMessageSignerException, OAuthExpectationFailedException, 
                                                                       OAuthCommunicationException, ClientProtocolException,
                                                                       OAuthNotAuthorizedException, IOException {
            this.provider.retrieveAccessToken(consumer, username, password);
            this.authorized = true;
        }
        
        /**
         * call GET API (OAuth)
         * @param uri API uri (includes any options)
         * @return 
         * @throws OAuthMessageSignerException
         * @throws OAuthExpectationFailedException
         * @throws OAuthCommunicationException
         * @throws ClientProtocolException
         * @throws IOException
         * @throws OAuthNotAuthorizedException
         */
        private String OAuthGet(String uri) throws OAuthMessageSignerException, OAuthExpectationFailedException,
                                                   OAuthCommunicationException, ClientProtocolException,
                                                   IOException, OAuthNotAuthorizedException {
            HttpGet request = new HttpGet(uri);
            consumer.sign(request);
            HttpResponse response = client.execute(request);
            util.checkHttpResponseCode(response);
            return util.convertToString(response.getEntity().getContent());
        }
        
        /**
         * call GET API (API key)
         * @param uri (includes any options)
         * @return
         * @throws ClientProtocolException
         * @throws IOException
         * @throws OAuthNotAuthorizedException
         * @throws OAuthCommunicationException
         */
        private String APIkeyGet(String uri) throws ClientProtocolException, IOException, 
                                                    OAuthNotAuthorizedException, OAuthCommunicationException {
            HttpGet request = new HttpGet(uri);
            HttpResponse response = client.execute(request);
            util.checkHttpResponseCode(response);
            return util.convertToString(response.getEntity().getContent());
            
        }
        
        /**
         * call GET API (Anybody can query the method)
         * @param uri (includes any options)
         * @return
         * @throws ClientProtocolException
         * @throws IOException
         */
        private String Get(String uri) throws ClientProtocolException, IOException {
            HttpGet request = new HttpGet(uri);
            HttpParams params = new BasicHttpParams();
            params.setParameter("http.protocol.handle-redirects", false);
            request.setParams(params);
            HttpResponse response = client.execute(request);
            return util.convertToString(response.getEntity().getContent());
        }
        /**
         * call POST API (OAuth)
         * @param uri (includes any options)
         * @param params request parameters
         * @return
         * @throws OAuthMessageSignerException
         * @throws OAuthExpectationFailedException
         * @throws OAuthCommunicationException
         * @throws IllegalStateException
         * @throws IOException
         */
        private String OAuthPost(String uri, List<? extends NameValuePair> params) throws OAuthMessageSignerException, OAuthExpectationFailedException,
                                                                                           OAuthCommunicationException, IllegalStateException, 
                                                                                           IOException {
            HttpPost request = new HttpPost(uri);
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
            request.setEntity(entity);
            consumer.sign(request);
            HttpResponse response = client.execute(request);
            return util.convertToString(response.getEntity().getContent());
            }
        
        /**
         * retrieve a Blog Information
         * @param blogHostname
         * @return
         * @throws OAuthMessageSignerException
         * @throws OAuthExpectationFailedException
         * @throws OAuthCommunicationException
         * @throws ClientProtocolException
         * @throws OAuthNotAuthorizedException
         * @throws IOException
         */
        public String retrieveBlogInfo(String blogHostname) throws OAuthMessageSignerException, OAuthExpectationFailedException, 
                                                                   OAuthCommunicationException, ClientProtocolException,
                                                                   OAuthNotAuthorizedException, IOException {
            String uri = this.API_URI + "/blog/" + blogHostname + "/info" + "?api_key=" + apiKey;
            return this.APIkeyGet(uri);
        }
        /**
         * retrieve a Blog Avatar
         * @param blogHostname
         * @param size The size of the avatar. Must be one of the values : 0,16, 24, 30, 40, 48, 64, 96, 128, 512
         *             (0 means default size : 64)
         * @return
         * @throws OAuthMessageSignerException
         * @throws OAuthExpectationFailedException
         * @throws OAuthCommunicationException
         * @throws ClientProtocolException
         * @throws OAuthNotAuthorizedException
         * @throws IOException
         */
        public String retriveBlogAvatar(String blogHostname, int size) throws ClientProtocolException, IOException {
            String uri = this.API_URI + "/blog/" + blogHostname + "/avater";
            if (size != 0) {
                uri = uri + "/size/" + size;
              }
            return this.Get(uri);
         }
        
        /**
         *  retrieve a Blog Avatar (default size)
         * @param blogHostname
         * @return
         * @throws ClientProtocolException
         * @throws IOException
         */
        public String retriveBlogAvatar(String blogHostname) throws  ClientProtocolException, IOException {
            return this.retriveBlogAvatar(blogHostname, 0);
        }
        
        /**
         * retrieve blog's followers
         * @param blogName
         * @return
         * @throws OAuthMessageSignerException
         * @throws OAuthExpectationFailedException
         * @throws OAuthCommunicationException
         * @throws ClientProtocolException
         * @throws IOException
         * @throws OAuthNotAuthorizedException
         */
        public String retrieveFollowers(String blogName) throws OAuthMessageSignerException, OAuthExpectationFailedException,
                                                           OAuthCommunicationException, ClientProtocolException,
                                                           IOException, OAuthNotAuthorizedException {
            String uri = this.API_URI + "/blog/" + blogName + "/followers";
            System.out.println(uri);
            return this.OAuthGet(uri);
        }
        
        
        public String retrieveDashboard(Map<String, String> params) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, OAuthNotAuthorizedException, IOException {
            String uri = this.API_URI + "/user/dashboard";
            uri = constructQueryURI(uri, params);
            return OAuthGet(uri);
        }
        public String retrieveDashboard() throws OAuthMessageSignerException, OAuthExpectationFailedException,
                                                 OAuthCommunicationException, ClientProtocolException,
                                                 OAuthNotAuthorizedException, IOException {
            return retrieveDashboard(null);
        }
        
        public String retrieveDashboard(int limit, int offset, boolean notes_info )
                throws OAuthMessageSignerException, OAuthExpectationFailedException,
                       OAuthCommunicationException, ClientProtocolException,
                       OAuthNotAuthorizedException, IOException {
           Map<String, String> params = new HashMap<String, String>();
           params.put("limit", String.valueOf(limit));
           params.put("offset", String.valueOf(offset));
           if (notes_info) {
               params.put("notes_info", String.valueOf(notes_info));
             }
           
           return retrieveDashboard(params);
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
