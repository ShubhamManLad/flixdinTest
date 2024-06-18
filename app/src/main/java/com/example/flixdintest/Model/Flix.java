package com.example.flixdintest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Flix {

    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("profilepic")
    @Expose
    private String profilepic;
    @SerializedName("flixid")
    @Expose
    private String flixid;
    @SerializedName("ownerid")
    @Expose
    private String ownerid;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("likes")
    @Expose
    private List<String> likes;
    @SerializedName("flixurl")
    @Expose
    private String video;
    @SerializedName("time_of_post")
    @Expose
    private String timeOfPost;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getFlixid() {
        return flixid;
    }

    public void setFlixid(String flixid) {
        this.flixid = flixid;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTimeOfPost() {
        return timeOfPost;
    }

    public void setTimeOfPost(String timeOfPost) {
        this.timeOfPost = timeOfPost;
    }
}
