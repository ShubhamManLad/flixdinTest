package com.example.flixdintest.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixdintest.Model.ApplicantCall;
import com.example.flixdintest.Model.ConnectionCall;
import com.example.flixdintest.Model.Post;
import com.example.flixdintest.Model.PostLikeCall;
import com.example.flixdintest.R;
import com.example.flixdintest.apiService;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int PostType = 1;
    private static int ConnectionCallType = 2;

    private static String user = "android-shubham";

    private Context context;
    private List<Post> list;
    private apiService apiService;

    public PostAdapter(Context context, List<Post> list, apiService apiService) {
        this.context = context;
        this.list = list;
        this.apiService = apiService;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getPostid().toLowerCase().contains("post")){
            return PostType;
        }
        else{
            return ConnectionCallType;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == PostType){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
            return new PostViewHolder(view);
        }
        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.connectioncall_item, parent, false);
            return new ConnectionCallViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == PostType){
            Post post = list.get(position);
            ((PostViewHolder)  holder).usernameTextView.setText(post.getOwnerid());
            ((PostViewHolder)  holder).domainTextview.setText(post.getDomain());
            ((PostViewHolder)  holder).locationTextview.setText(post.getLocation());
            ((PostViewHolder)  holder).captionTextView.setText(post.getCaption());
            ((PostViewHolder)  holder).likeCountTextview.setText(post.getLikes().size()+"");
            //Glide.with(context).load(post.getImage()).into(((PostViewHolder) holder).postPicImageview);
            Picasso.get().load(post.getImage()).resize(1000,500).into(((PostViewHolder) holder).postPicImageview);

            Glide.with(context).load("https://cdn.pixabay.com/photo/2016/08/12/14/25/abstract-1588720_1280.jpg").into(((PostViewHolder) holder).profilePicImageview);

            String likes = "";
            boolean isLiked = false;
            for (String liked : post.getLikes()){
                likes =likes + liked + " ";
            }
            Log.i("Liked By",likes);
            if (post.getLikes().contains(user)){
                ((PostViewHolder) holder).likeButton.setImageResource(R.drawable.like_red);
                isLiked = true;
            }

            boolean finalIsLiked = isLiked;
            ((PostViewHolder) holder).likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!finalIsLiked){
                        int noLikes = likePost(apiService, post.getPostid());
                        Log.i("Liked Post",post.getPostid());
                        ((PostViewHolder) holder).likeButton.setImageResource(R.drawable.like_red);
                        ((PostViewHolder)  holder).likeCountTextview.setText(noLikes+"");

                    }
                    else{
                        Log.i("Disliked Post",post.getPostid());
                        int likedBy =  dislikePost(apiService, post.getPostid());
                        ((PostViewHolder) holder).likeButton.setImageResource(R.drawable.like);
                        ((PostViewHolder)  holder).likeCountTextview.setText(likedBy+"");
                    }
                }
            });



        }
        else{
            Post connectionCall = list.get(position);
            ((ConnectionCallViewHolder) holder).ownerTextView.setText(connectionCall.getOwnerid());
            ((ConnectionCallViewHolder) holder).domainTextView.setText(connectionCall.getDomain());
            ((ConnectionCallViewHolder) holder).locationTextView.setText(connectionCall.getLocation());
            ((ConnectionCallViewHolder) holder).descriptionTextView.setText(connectionCall.getCaption());
            ((ConnectionCallViewHolder) holder).applyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addApplicant(apiService);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ConnectionCallViewHolder extends RecyclerView.ViewHolder{

        private TextView ownerTextView,professionTextview,domainTextView,locationTextView,descriptionTextView;
        private Button applyButton;

        public ConnectionCallViewHolder(@NonNull View itemView) {
            super(itemView);
            ownerTextView = itemView.findViewById(R.id.cc_Username);
            domainTextView = itemView.findViewById(R.id.cc_domain);
            professionTextview = itemView.findViewById(R.id.cc_Profession);
            locationTextView = itemView.findViewById(R.id.cc_Location);
            descriptionTextView = itemView.findViewById(R.id.cc_Description);
            applyButton = itemView.findViewById(R.id.cc_Apply);
        }
    }

    class PostViewHolder extends RecyclerView.ViewHolder{

        private TextView usernameTextView,domainTextview,locationTextview,captionTextView;
        private TextView likeCountTextview,commentCountTextview;
        private CircleImageView profilePicImageview;
        private ImageView postPicImageview;

        private ImageView likeButton;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.post_Username);
            domainTextview = itemView.findViewById(R.id.post_Profession);
            locationTextview = itemView.findViewById(R.id.post_Location);
            captionTextView = itemView.findViewById(R.id.post_Description);
            likeCountTextview = itemView.findViewById(R.id.post_Like_Count);
            commentCountTextview = itemView.findViewById(R.id.post_Comment_Count);

            profilePicImageview = itemView.findViewById(R.id.profilePic);
            postPicImageview = itemView.findViewById(R.id.postPic);

            likeButton = itemView.findViewById(R.id.post_Like);

        }
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

    public int likePost(apiService apiService, String postID){
        PostLikeCall postLikeCall = new PostLikeCall();
        postLikeCall.setUserID(user);
        postLikeCall.setPostID(postID);

        Call<List<String>> request3 = apiService.likePost(postLikeCall);

        final int[] likes = new int[1];
        request3.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Log.i("Response", String.valueOf(response.code()));
                likes[0] = response.body().size();
                Log.i("No. likes", String.valueOf(response.body().size()));
                for (String name :
                        response.body()) {
                    Log.i("Liked post:",postID + ":"+ name);
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.i("Error", t.getMessage());
            }
        });
        return likes[0];
    }

    public int dislikePost(apiService apiService, String postID){
        PostLikeCall postLikeCall = new PostLikeCall();
        postLikeCall.setUserID(user);
        postLikeCall.setPostID(postID);

        Call<List<String>> request3 = apiService.dislikePost(postLikeCall);
        final int[] likes = new int[1];
        request3.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Log.i("Response", String.valueOf(response.code()));
                likes[0] = response.body().size();
                Log.i("No. likes", String.valueOf(response.body().size()));
                for (String name :
                        response.body()) {
                    Log.i("Liked post:",postID + ":"+ name);
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.i("Error", t.getMessage());
            }
        });
        return likes[0];
    }

}
