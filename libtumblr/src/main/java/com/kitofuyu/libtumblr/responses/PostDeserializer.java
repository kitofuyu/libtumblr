package com.kitofuyu.libtumblr.responses;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.kitofuyu.libtumblr.resources.Post;

public class PostDeserializer implements JsonDeserializer<Object> {

    public Object deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        String packageName = "com.kitofuyu.libtumblr.resources.";
        JsonObject jobject = json.getAsJsonObject();
        String typeName = jobject.get("type").getAsString();
        String className = typeName.substring(0, 1).toUpperCase() + typeName.substring(1);
        try {
            Class<?> claz = Class.forName(packageName + className);
            return context.deserialize(json, claz);
        } catch (ClassNotFoundException e) {
            System.out.println("deserialized post for unknown type: " + typeName);
            return context.deserialize(json, Post.class);
        }
    }
}
