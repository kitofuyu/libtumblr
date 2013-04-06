package com.kitofuyu.libtumblr.util;
import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

import org.apache.http.HttpResponse;

public class util {

    public static void checkHttpResponseCode(HttpResponse response) throws OAuthNotAuthorizedException, OAuthCommunicationException, IOException {
        int responseCode = response.getStatusLine().getStatusCode();
        if (responseCode < 300 ) return;
        
        String responseBody = convertToString(response.getEntity().getContent());
        String responsePhrase = response.getStatusLine().getReasonPhrase();

        switch (responseCode) {
        case 401:
            throw new OAuthNotAuthorizedException(responseBody);
        default:
            throw new OAuthCommunicationException("Service provider responded in error: "
                    + responseCode + " (" + responsePhrase + ")", responseBody);
         }
    }
    
    public static String convertToString(InputStream instream) throws IOException {
        InputStreamReader  reader = new InputStreamReader(instream);
        StringBuilder builder = new StringBuilder();
        char[] buf = new char[1024];
         int numRead;
         while (0 <= (numRead = reader.read(buf))) {
             builder.append(buf, 0, numRead);
          }
          return builder.toString();
        }
}
