package com.example.flixdintest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request_Model {

    @SerializedName("postid")
    @Expose
    private String postid;
    @SerializedName("userid")
    @Expose
    private String userid;

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}

