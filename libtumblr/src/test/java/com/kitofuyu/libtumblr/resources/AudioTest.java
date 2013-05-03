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

public class AudioTest {

    private Response response;

    @Before
    public void setup() throws IOException {
        File jsonFile = new File("json/audiopost.json");
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
        Audio audio = (Audio)postList.get(0);
        
        assertEquals("<p>Otis Redding never fails me. </p>",
                        audio.getCaption());
        assertEquals("<iframe src=\"https://w.soundcloud.com/player/?url=http%3A%2F%2Fapi.soundcloud.com%2Ftracks%2F899921&amp;liking=false&amp;sharing=false&origin=tumblr\" frameborder=\"0\" allowtransparency=\"true\" class=\"soundcloud_audio_player\" width=\"500\" height=\"116\"></iframe>",
                            audio.getPlayer());
        assertEquals("Otis Redding - Cigarettes And Coffee",
                                audio.getTrackName());
        
        
    }

}
