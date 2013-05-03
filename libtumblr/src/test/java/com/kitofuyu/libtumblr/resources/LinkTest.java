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

public class LinkTest {

    private Response response;

    @Before
    public void setup() throws IOException {
        File jsonFile = new File("json/linkpost.json");
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
        Link link = (Link)postList.get(3);
        
        assertEquals("'Racism' of early colour photography explored in art exhibition",
                       link.getTitle());
        assertEquals("http://www.guardian.co.uk/artanddesign/2013/jan/25/racism-colour-photography-exhibition",
                        link.getUrl());
        assertEquals("<p>&#8220;Can the camera be racist? The question is explored in an exhibition that reflects on how <a href=\"http://www.guardian.co.uk/artanddesign/polaroid\" title=\"More from guardian.co.uk on Polaroid\" target=\"_blank\">Polaroid</a> built an efficient tool for South <a href=\"http://www.guardian.co.uk/world/africa\" title=\"More from guardian.co.uk on Africa\" target=\"_blank\">Africa</a>&#8217;s apartheid regime to photograph and police black people.</p>\n<p>&#8220;The London-based artists <a href=\"http://www.guardian.co.uk/artanddesign/2011/apr/19/broomberg-chanarin-photojournalism-war\" title=\"\" target=\"_blank\">Adam Broomberg and Oliver Chanarin</a> spent a month in <a href=\"http://www.guardian.co.uk/world/southafrica\" title=\"More from guardian.co.uk on South Africa\" target=\"_blank\">South Africa</a> taking pictures on decades-old film that had been engineered with only white faces in mind. They used Polaroid&#8217;s vintage ID-2 camera, which had a &#8220;boost&#8221; button to increase the flash – enabling it to be used to photograph black people for the notorious passbooks, or <a href=\"http://en.wikipedia.org/wiki/Pass_laws\" title=\"\" target=\"_blank\">&#8220;dompas&#8221;</a>, that allowed the state to control their movements.</p>\n<p>&#8220;The result was raw snaps of some of the country&#8217;s most beautiful flora and fauna from regions such as the Garden Route and the Karoo, an attempt by the artists to subvert what they say was the camera&#8217;s original, sinister intent.&#8221;</p>\n<p>Click the <a href=\"http://www.guardian.co.uk/artanddesign/2013/jan/25/racism-colour-photography-exhibition\" target=\"_blank\">link</a> for the full article.</p>",
                        link.getDescription());
        
    }

}
