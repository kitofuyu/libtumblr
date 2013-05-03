package com.kitofuyu.libtumblr.resources;

import static org.junit.Assert.*;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kitofuyu.libtumblr.responses.Response;

public class QuoteTest {

    private Response response;
    
    @Before
    public void setUp() throws Exception {
        File jsonFile = new File("json/quotepost.json");
        FileReader fr;
        fr = new FileReader(jsonFile);
        BufferedReader br = new BufferedReader(fr);
        JsonParser parser = new JsonParser();
        JsonElement jelement = parser.parse(br);
        JsonObject jobject = jelement.getAsJsonObject();
        jelement = jobject.get("response");
        response =  new Response(jelement);
        br.close();
        fr.close();
    }

    @Test
    public void test() {
        List<Post> postList = response.getPosts();
        Quote quote = (Quote)postList.get(2);
        assertEquals(Long.parseLong("32865551932"),
                    quote.getId());
        assertEquals("10% of all photos ever taken<br/>\nwere shot in 2011.",
                        quote.getText());
        assertEquals("Fortune magazine, September 24, 2012, page 166 (via <a class=\"tumblr_blog\" href=\"http://randallphenning.tumblr.com/\" target=\"_blank\">randallphenning</a>)<br/>This is insane, such a staggering statistic. (via <a class=\"tumblr_blog\" href=\"http://tommybruce.tumblr.com/\" target=\"_blank\">tommybruce</a>)",
                        quote.getSource());
        
        
        
    }

}
