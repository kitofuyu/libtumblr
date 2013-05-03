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

public class VideoTest {

    private Response response;

    @Before
    public void setup() throws IOException {
        File jsonFile = new File("json/videopost.json");
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
        Video video = (Video)postList.get(3);
        Embed embed = video.getPlayer().get(1);
        
        assertEquals("<p>(via <a href=\"http://www.exquisiteforest.com/\" target=\"_blank\">This Exquisite Forest</a>)</p>",
                        video.getCaption());
        assertEquals(400, embed.getWidth());
        assertEquals("<iframe width=\"400\" height=\"225\" src=\"http://www.youtube.com/embed/nnhJ1841K-8?wmode=transparent&autohide=1&egm=0&hd=1&iv_load_policy=3&modestbranding=1&rel=0&showinfo=0&showsearch=0\" frameborder=\"0\" allowfullscreen></iframe>",
                        embed.getEmbedCode());
        
    }

}
