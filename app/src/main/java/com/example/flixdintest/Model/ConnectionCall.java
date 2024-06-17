package com.example.flixdintest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConnectionCall {

    @SerializedName("callid")
    @Expose
    private String callid;
    @SerializedName("ownerid")
    @Expose
    private String ownerid;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("description")
    @Expose
    private String description;
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
    @SerializedName("comments")
    @Expose
    private List<String> comments;
    @SerializedName("date")
    @Expose
    private String date;

    public ConnectionCall(String callid, String ownerid, String domain, String description, List<String> applicants, String location, List<String> likes, String image, List<String> comments, String date) {
        this.callid = callid;
        this.ownerid = ownerid;
        this.domain = domain;
        this.description = description;
        this.applicants = applicants;
        this.location = location;
        this.likes = likes;
        this.image = image;
        this.comments = comments;
        this.date = date;
    }

    public String getCallid() {
        return callid;
    }

    public void setCallid(String callid) {
        this.callid = callid;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}