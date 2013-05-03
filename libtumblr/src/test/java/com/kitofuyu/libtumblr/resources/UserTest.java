package com.kitofuyu.libtumblr.resources;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kitofuyu.libtumblr.responses.Response;

public class UserTest {

    private Response response;

    @Before
    public void setup() throws IOException {
        File jsonFile = new File("json/userinfo.json");
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
    public void user() {
        User user = response.getUser();
        assertEquals(606, user.getLikes());
        assertEquals("derekg", user.getName());
        
        // blogs
        assertEquals("derekg", user.getBlogs().get(0).getName());
        assertEquals(true, user.getBlogs().get(0).isPrimary());
        assertNull(user.getBlogs().get(0).getBase_hostname());
        
        assertEquals("sample", user.getBlogs().get(1).getName());
        assertEquals(false, user.getBlogs().get(1).isPrimary());
        assertNull(user.getBlogs().get(1).getBase_hostname());
    }

}
