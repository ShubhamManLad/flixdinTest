package com.example.flixdintest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.flixdintest.Adapters.FlixAdapter;
import com.example.flixdintest.Model.Flix;
import com.example.flixdintest.Model.RequestFlix;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        PlayerView flixVideo = new PlayerView(getApplicationContext());

        ArrayList<Flix> flixs = new ArrayList<>();
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.flixdin.com/").addConverterFactory(GsonConverterFactory.create(gson)).build();

        apiService apiService = retrofit.create(com.example.flixdintest.apiService.class);

        Call<List<Flix>> request = apiService.getAllFlixs(new RequestFlix());
        request.enqueue(new Callback<List<Flix>>() {
            @Override
            public void onResponse(Call<List<Flix>> call, Response<List<Flix>> response) {

                for (Flix flix : response.body()) {
                    if(!flix.getVideo().equals("")) {
                        flixs.add(flix);
                        Log.i("onResponse getFlixs", flix.getVideo() + ":" + flix.getOwnerid());
                    }
                }


                RecyclerView recyclerView = findViewById(R.id.flixRecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                recyclerView.setAdapter(new FlixAdapter(flixs,getApplicationContext()));
                SnapHelper snapHelper = new PagerSnapHelper();
                snapHelper.attachToRecyclerView(recyclerView);
            }

            @Override
            public void onFailure(Call<List<Flix>> call, Throwable t) {

                Log.i("onFailure getFlixs",t.getMessage());
            }
        });



    }
}