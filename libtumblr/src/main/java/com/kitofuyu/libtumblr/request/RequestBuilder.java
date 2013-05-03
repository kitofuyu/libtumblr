package com.kitofuyu.libtumblr.request;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

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

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kitofuyu.libtumblr.exceptions.LibTumblrException;
import com.kitofuyu.libtumblr.responses.Response;
import com.kitofuyu.libtumblr.util.util;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

public class RequestBuilder {
    private OAuthConsumer consumer;
    private HttpClient client;
    
    public RequestBuilder () {
        client = new DefaultHttpClient();
    }
    
    public void setConsumer(OAuthConsumer consumer) {
        this.consumer = consumer;
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
    public Response OAuthGet(String uri) {
        HttpGet request = new HttpGet(uri);
        HttpResponse response;
        try {
            consumer.sign(request);
            response = client.execute(request);
        } catch (OAuthException e) {
               throw new LibTumblrException(e.getMessage(), e);
        } catch (ClientProtocolException e) {
            throw new LibTumblrException(e.getMessage(), e);
        } catch (IOException e) {
            throw new LibTumblrException(e.getMessage(), e);
         }
        return parseHttpResponse(response);
    }
    
    /**
     * call GET API (API key)
     * @param uri (includes any options also API key)
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws OAuthNotAuthorizedException
     * @throws OAuthCommunicationException
     */
    public Response APIkeyGet(String uri)  {
        HttpGet request = new HttpGet(uri);
        HttpResponse response;
        try {
            response = client.execute(request);
        } catch (ClientProtocolException e) {
            throw new LibTumblrException(e.getMessage(), e);
        } catch (IOException e) {
            throw new LibTumblrException(e.getMessage(), e);
         }
        //util.checkHttpResponseCode(response);
        return parseHttpResponse(response);
        
    }
    
    /**
     * call GET API (Anybody can query the method)
     * @param uri (includes any options)
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public String Get(String uri) {
        HttpGet request = new HttpGet(uri);
        HttpParams params = new BasicHttpParams();
        params.setParameter("http.protocol.handle-redirects", false);
        request.setParams(params);
        try {
            HttpResponse response = client.execute(request);
            return util.convertToString(response.getEntity().getContent());
        } catch (IllegalStateException e) {
            throw new LibTumblrException(e.getMessage(), e);
        } catch (IOException e) {
            throw new LibTumblrException(e.getMessage(), e);
        }
    }
    /**
     * call POST API (OAuth)
     * @param uri (includes any options)
     * @param params request parameters
     * @return
     * @throws LibTumblrException
     */
    public Response OAuthPost(String uri, List<NameValuePair> params) {
        HttpPost request = new HttpPost(uri);
        UrlEncodedFormEntity entity;
        try {
            entity = new UrlEncodedFormEntity(params, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
         }
        request.setEntity(entity);
        HttpResponse response;
        try {
            consumer.sign(request);
            response = client.execute(request);
        } catch (OAuthException e) {
               throw new LibTumblrException(e.getMessage(), e);
        } catch (ClientProtocolException e) {
            throw new LibTumblrException(e.getMessage(), e);
        } catch (IOException e) {
            throw new LibTumblrException(e.getMessage(), e);
         }
         
        return parseHttpResponse(response);
        
        }
    
    private Response parseHttpResponse (HttpResponse httpResponse) {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(httpResponse.getEntity().getContent());
        } catch (IllegalStateException e) {
            throw new LibTumblrException(e.getMessage(), e);
        } catch (IOException e) {
            throw new LibTumblrException(e.getMessage(), e);
        }
        
        JsonParser parser = new JsonParser();
        JsonElement jelement = parser.parse(reader);
        return new Response(jelement);
       
    }
}
