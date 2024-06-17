package com.example.flixdintest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flixdintest.Adapters.PostAdapter;
import com.example.flixdintest.Model.ApplicantCall;
import com.example.flixdintest.Model.ConnectionCall;
import com.example.flixdintest.Model.Post;
import com.example.flixdintest.Model.RequestCall;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.flixdin.com/").
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();


        apiService apiService = retrofit.create(com.example.flixdintest.apiService.class);

//        List<ConnectionCall> connectionCallList = new ArrayList<>();
//        recyclerView = findViewById(R.id.connectionCallRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
        getAllData(apiService);

        //getConnectionCall(apiService);


    }

    public void createConnectionCall(apiService apiService){
        ConnectionCall call = new ConnectionCall("123","shubham","tech","test",new ArrayList<>(),"mumbai",new ArrayList<>(),"null",new ArrayList<>(),"2023-12-31");

        Call<ConnectionCall> request = apiService.createConnectionCall(call);

        request.enqueue(new Callback<ConnectionCall>() {
            @Override
            public void onResponse(Call<ConnectionCall> call, Response<ConnectionCall> response) {
                Log.i("Respose", String.valueOf(response.code()));
                Log.i("Connection Call", response.body().getCallid());

            }

            @Override
            public void onFailure(Call<ConnectionCall> call, Throwable t) {
                Log.i("error",t.getMessage());
            }
        });
    }

    public void getConnectionCall(apiService apiService){
        RequestCall requestCall = new RequestCall();
        requestCall.setCallid("testingid4");

        Call<List<Post>> request = apiService.getConnectionCall(requestCall);
        request.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.i("Response", String.valueOf(response.code()));
                List<Post> list = response.body();

//                adapter = new ConnectionCallAdapter(getApplicationContext(),list,apiService);
//                recyclerView.setAdapter(adapter);

                for (Post connectionCall : list) {
                    Log.i("ConnectionCall ID",connectionCall.getPostid());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.i("error",t.getMessage());
            }
        });
    }

    public void addApplicant(apiService apiService){
        ApplicantCall applicantCall = new ApplicantCall();
        applicantCall.setApplicant("123");
        applicantCall.setCallid("testingid4");

        Call<ConnectionCall> request3 = apiService.addApplicantConnectionCall(applicantCall);

        request3.enqueue(new Callback<ConnectionCall>() {
            @Override
            public void onResponse(Call<ConnectionCall> call, Response<ConnectionCall> response) {
                Log.i("Respose", String.valueOf(response.code()));
                Log.i("Connection Call", response.body().getCallid());
            }

            @Override
            public void onFailure(Call<ConnectionCall> call, Throwable t) {
                Log.i("Error", t.getMessage());
            }
        });
    }
//
//    public void getConnectionCalls(apiService apiService){
//        RequestCall requestCall = new RequestCall();
//        requestCall.setCallid("testingid4");
//
//        Call<List<Post>> request = apiService.getConnectionCalls(requestCall);
//        request.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                Log.i("Response", String.valueOf(response.code()));
//                List<Post> list = response.body();
//
////                adapter = new ConnectionCallAdapter(getApplicationContext(),list,apiService);
////                recyclerView.setAdapter(adapter);
//
//                for (Post connectionCall : list) {
//                    Log.i("ConnectionCall ID",connectionCall.getPostid());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                Log.i("error",t.getMessage());
//            }
//        });
//    }

    public void getAllData(apiService apiService){
        RequestCall requestCall = new RequestCall();
        requestCall.setCallid("testingid4");

        Call<List<Post>> request = apiService.getConnectionCalls(requestCall);
        request.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.i("Response", String.valueOf(response.code()));
                List<Post> list = response.body();

//                adapter = new PostAdapter(getApplicationContext(),list,apiService);
//                recyclerView.setAdapter(adapter);

                for (Post connectionCall : list) {
                    Log.i("ConnectionCall ID",connectionCall.getPostid()+ ":" +connectionCall.getImage());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.i("error",t.getMessage());
            }
        });
    }

}