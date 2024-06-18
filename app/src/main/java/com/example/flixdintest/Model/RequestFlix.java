package com.example.flixdintest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestFlix {

    @SerializedName("flixid")
    @Expose
    private String flixid;

    public RequestFlix() {
        this.flixid = "";
    }
}
