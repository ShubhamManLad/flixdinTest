package com.example.flixdintest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response_Model {

    @SerializedName("data")
    @Expose
    private List<String> data;

}
