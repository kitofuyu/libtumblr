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
import com.google.gson.JsonParser;
import com.kitofuyu.libtumblr.responses.Response;

public class AnswerTest {

    private Response response;

    @Before
    public void setup() throws IOException {
        File jsonFile = new File("json/answerpost.json");
        FileReader fr;
        fr = new FileReader(jsonFile);
        BufferedReader br = new BufferedReader(fr);
        JsonParser parser = new JsonParser();
        JsonElement jelement = parser.parse(br);
        response =  new Response(jelement);
        br.close();
        fr.close();
        
    }

    @Test
    public void test() {
        List<Post> postList = response.getPosts();
        Answer answer =(Answer) postList.get(0);
        
        assertEquals("theoceancompelled", answer.getAskingName());
        assertEquals("http://theoceancompelled.tumblr.com/",
                        answer.getAskingUrl());
        assertEquals("I thought Tumblr started in 2007, yet you have posts from 2006?",
                        answer.getQuestion());
        assertEquals("<p>Good catch! Tumblr <strong>launched</strong> in February 2007. We were testing it for a few months before then.</p>\n<p><strong>Tumblr Trivia:</strong> Before Tumblr, my blog (davidslog.com) was a manually edited, single page, HTML tumblelog.</p>", 
                            answer.getAnswer());
        
    }

}
