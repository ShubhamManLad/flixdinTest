package com.example.flixdintest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Post {

    @SerializedName("postid")
    @Expose
    private String postid;
    @SerializedName("ownerid")
    @Expose
    private String ownerid;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("applicants")
    @Expose
    private List<String> applicants;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("likes")
    @Expose
    private List<String> likes;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("time_of_post")
    @Expose
    private String timeOfPost;
    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<String> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<String> applicants) {
        this.applicants = applicants;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimeOfPost() {
        return timeOfPost;
    }

    public void setTimeOfPost(String timeOfPost) {
        this.timeOfPost = timeOfPost;
    }


}