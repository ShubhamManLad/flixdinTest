package com.example.flixdintest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostLikeCall {

    @SerializedName("postid")
    @Expose
    private String postID;

    @SerializedName("userid")
    @Expose
    private String userID;

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
