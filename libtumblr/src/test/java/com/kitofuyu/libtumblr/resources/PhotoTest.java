package com.kitofuyu.libtumblr.resources;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kitofuyu.libtumblr.responses.Response;

public class PhotoTest {

    private Response response;

    @Before
    public void setup() throws IOException {
        File jsonFile = new File("json/photopost.json");
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
        
        Photo photo = (Photo)postList.get(0);
        PhotosElement photoElement = photo.getPhotos().get(0);
        AltPhotoSize altSize = photoElement.getAltSize().get(0);
        
        assertEquals("derekg", photo.getBlogName());
        assertEquals("<p>my arm is getting tired.</p>", photo.getCaption());
        assertEquals("", photoElement.getCaption());
        assertEquals(1280, altSize.getWidth());
        assertEquals("http://25.media.tumblr.com/tumblr_lo36wbWqqq1qanqwwo1_1280.jpg",
                    altSize.getUrl());
        
        altSize = photoElement.getAltSize().get(1);
        assertEquals(282, altSize.getHeight());
        assertEquals("http://24.media.tumblr.com/tumblr_lo36wbWqqq1qanqwwo1_500.jpg",
                    altSize.getUrl());
        
    }
}
