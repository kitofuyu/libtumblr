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

public class ChatTest {

    private Response response;

    @Before
    public void setup() throws IOException {
        File jsonFile = new File("json/chatpost.json");
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
        Chat chat = (Chat)postList.get(2);
        Dialogue dialogue = chat.getDialogue().get(1);
        
        assertEquals("I passed the test?", chat.getTitle());
        assertEquals("Check-in: Would you like to upgrade to an Executive Suite for an additional fifty dollars?\nDavid: No, thank you.\nCheck-in: Sir, I'm happy to inform you we have a complimentary upgrade to an Executive Suite.",
                        chat.getBody());
        
        assertEquals("David", dialogue.getName());
        assertEquals("David:", dialogue.getLabel());
        assertEquals("No, thank you.", dialogue.getPhrase());
        
    }

}
