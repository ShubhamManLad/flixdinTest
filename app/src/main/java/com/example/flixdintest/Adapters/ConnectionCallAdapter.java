package com.example.flixdintest.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flixdintest.Model.ApplicantCall;
import com.example.flixdintest.Model.ConnectionCall;
import com.example.flixdintest.Model.Post;
import com.example.flixdintest.R;
import com.example.flixdintest.apiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectionCallAdapter extends RecyclerView.Adapter<ConnectionCallAdapter.MyViewHolder> {

    private Context context;
    private List<Post> list;

    private apiService apiService;

    public ConnectionCallAdapter(Context context, List<Post> list, apiService apiService) {
        this.context = context;
        this.list = list;
        this.apiService = apiService;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.connectioncall_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Post connectionCall = list.get(position);
        holder.ownerTextView.setText(connectionCall.getOwnerid());
        holder.domainTextView.setText(connectionCall.getDomain());
        holder.locationTextView.setText(connectionCall.getLocation());
//        holder.descriptionTextView.setText(connectionCall.getDescription());
        holder.applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addApplicant(apiService, connectionCall.getPostid());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView ownerTextView,professionTextview,domainTextView,locationTextView,descriptionTextView;
        private Button applyButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ownerTextView = itemView.findViewById(R.id.cc_Username);
            domainTextView = itemView.findViewById(R.id.cc_domain);
            professionTextview = itemView.findViewById(R.id.cc_Profession);
            locationTextView = itemView.findViewById(R.id.cc_Location);
            descriptionTextView = itemView.findViewById(R.id.cc_Description);
            applyButton = itemView.findViewById(R.id.cc_Apply);

        }
    }

    public void addApplicant(apiService apiService, String callID){
        ApplicantCall applicantCall = new ApplicantCall();
        applicantCall.setApplicant("123");
        applicantCall.setCallid(callID);

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
}
