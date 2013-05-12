package com.kitofuyu.libtumblr.resources;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.kitofuyu.libtumblr.responses.Response;

public class TextTest {

    private Response response;
    
    @Before
    public void setUp() throws Exception {
        File jsonFile = new File("json/textpost.json");
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
        
        Text text = (Text)postList.get(0);
        
        assertEquals("citriccomics", text.getBlogName());
        assertEquals("milky rabbit blood?", text.getTitle());
        assertEquals("<p><a href=\"http://kiakakes.tumblr.com/post/7172992626\" class=\"tumblr_blog\" target=\"_blank\">kiakakes</a>:</p>\n\n<blockquote><p><img src=\"http://media.tumblr.com/tumblr_lnqdqtRwaq1qbbuwr.png\"/></p>\n<p>i couldn\u2019t think of something to draw for myself, so i decided to draw for someone else again. this is fan art for <a href=\"http://citriccomics.tumblr.com/\" target=\"_blank\">ian</a>. i love his comics and the way he draw mice.&#160;; u&#160;; um i tried to incorporate elements from his other comics but i failed. but i put in a part of a panel from milky dog in the box thing on the left. = u =</p></blockquote>\n\n\n!!!!!!!!! SO AWESOME!!!! SHEEEESH <a href=\"http://kiakakes.tumblr.com\" target=\"_blank\">Kiakakes</a> can make even the bloodiest skull adorable!!\nAHHHHH Thank you!!", 
                     text.getBody());
        
        text = (Text)postList.get(1);
        
        assertEquals("milky dog", text.getTags().get(1));
        assertEquals("Milky Dog", text.getTitle());
        assertEquals("<p><img src=\"http://media.tumblr.com/tumblr_lh6x8d7LBB1qa6gy3.jpg\"/><a href=\"http://citriccomics.com/blog/?p=487\" target=\"_blank\">TO READ THE REST CLICK HERE</a><br/>\n\nMilky Dog was inspired by something <a href=\"http://gunadie.com/naomi\" target=\"_blank\">Naomi Gee</a> wrote on twitter, I really liked the hash tag <a href=\"http://twitter.com/search?q=%23MILKYDOG\" target=\"_blank\">#milkydog</a> and quickly came up with a little comic about it. You can (and should) follow Naomi on twitter <a href=\"http://twitter.com/ngun\" target=\"_blank\">@ngun</a> I&#8217;m on twitter as well <a href=\"http://twitter.com/weflewairplanes\" target=\"_blank\">@weflewairplanes</a></p>\n\nAlso, if you&#8217;re a Reddit user (or even if you&#8217;re not) I submitted this there, if you could up vote it I&#8217;d be super grateful just <a href=\"http://tinyurl.com/5wj3tqz\" target=\"_blank\">CLICK HERE</a>",
                     text.getBody());
        
        assertEquals(4, postList.size());

    }

}
