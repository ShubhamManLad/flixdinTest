package com.example.flixdintest;

import com.example.flixdintest.Model.ApplicantCall;
import com.example.flixdintest.Model.ConnectionCall;
import com.example.flixdintest.Model.Post;
import com.example.flixdintest.Model.PostLikeCall;
import com.example.flixdintest.Model.RequestCall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface apiService {


    @POST("new-connectionCall")
    Call<ConnectionCall> createConnectionCall(@Body ConnectionCall call);

    @POST("get-connectionCall")
    Call<List<Post>> getConnectionCall(@Body RequestCall requestCall);

    @PUT("addapplicant-connectionCall")
    Call<ConnectionCall> addApplicantConnectionCall(@Body ApplicantCall applicantCall);


    @POST("get-connectionCalls")
    Call<List<Post>> getConnectionCalls(@Body RequestCall requestCall);

    @POST("getdata")
    Call<List<Post>> getAllData(@Body RequestCall requestCall);

    @PUT("like-post")
    Call<List<String>> likePost(@Body PostLikeCall postLikeCall);

    @PUT("dislike-post")
    Call<List<String>> dislikePost(@Body PostLikeCall postLikeCall);


    // Version 2 routes
//    @PUT("v2/new-connectionCall")
//    Call<>


}
