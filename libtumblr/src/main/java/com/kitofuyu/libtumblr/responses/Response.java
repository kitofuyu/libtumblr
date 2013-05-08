package com.kitofuyu.libtumblr.responses;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.kitofuyu.libtumblr.resources.Blog;
import com.kitofuyu.libtumblr.resources.Meta;
import com.kitofuyu.libtumblr.resources.Post;
import com.kitofuyu.libtumblr.resources.User;

/**
 * Matches API-specific results.
 * @author kitofuyu
 */
public class Response {
    private JsonElement response;
    private JsonElement metaField;
    private JsonElement responseField;
    
    public Response(JsonElement jelement) {
        response = jelement;
    }
    public Meta getMeta() {
        parseMetaField();
        return get(response, "meta", Meta.class);
    }
    public Blog getBlog() {
        parseResponseField();
        return get(responseField, "blog", Blog.class);
    }
    
    public Post getPost() {
        parseResponseField();
        return get(responseField, "post", Post.class);
    }
    
    public User getUser() {
        parseResponseField();
        return get(responseField, "user", User.class);
    }
    
    public List<Blog> getBlogs() {
        parseResponseField();
        return get(responseField, "blogs", new TypeToken<List<Blog>>(){}.getType());
    }
    
    public List<Post> getPosts() {
        parseResponseField();
        return get(responseField, "posts", new TypeToken<List<Post>>(){}.getType());
    }
    
    public List<User> getUsers() {
        parseResponseField();
        return get(responseField, "users", new TypeToken<List<User>>(){}.getType());
    }
    
    public List<Post> getLikedPosts() {
        parseResponseField();
        return get(responseField, "liked_posts", new TypeToken<List<Post>>(){}.getType());
    }
    private void parseResponseField() {
        JsonObject jobject = response.getAsJsonObject();
        responseField = jobject.get("response");
    }
    
    private void parseMetaField() {
        JsonObject jobject = response.getAsJsonObject();
        metaField = jobject.get("meta");
    }
    
    private <Res extends Object> Res get(JsonElement jelement, String field, Type type) {
        Gson gson = gsonParser();
        JsonObject jobject = jelement.getAsJsonObject();
         Res r = gson.fromJson(jobject.get(field), type);
         return r;
    }
    
    private Gson gsonParser() {
        return new GsonBuilder().registerTypeAdapter(Post.class, new PostDeserializer()).create();        
    }
    
}
