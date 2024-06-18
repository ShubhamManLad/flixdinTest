package com.example.flixdintest.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flixdintest.Model.Flix;
import com.example.flixdintest.R;

import java.util.List;

public class FlixAdapter extends RecyclerView.Adapter<FlixAdapter.FlixViewHolder>{

    List<Flix> flix;

    private Context context;

    private ExoPlayer player;
    private MediaItem mediaItem;

    public FlixAdapter(List<Flix> flix, Context context) {
        this.flix = flix;
        this.context = context;
        player = new ExoPlayer.Builder(this.context).build();
    }



//    @Override
//    public void onViewDetachedFromWindow(@NonNull FlixViewHolder holder) {
//        super.onViewDetachedFromWindow(holder);
//        Log.i("Adapter Postion", holder.getBindingAdapterPosition()+"");
//        player.stop();
//        player.release();
////        player.clearMediaItems();
//    }
//
//    @Override
//    public void onViewAttachedToWindow(@NonNull FlixViewHolder holder) {
//        super.onViewAttachedToWindow(holder);
//
//        Log.i("Adapter Postion", holder.getBindingAdapterPosition()+"");
//
//        player.prepare();
//        player.play();
//    }

    @NonNull
    @Override
    public FlixViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flix_item, parent, false);
        return new FlixViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull FlixViewHolder holder, int position) {

        if(flix.get(position).getVideo()!=null){
            Uri uri = Uri.parse(flix.get(position).getVideo());
            holder.flixVideo.setPlayer(player);
            mediaItem = MediaItem.fromUri(uri);
            player.setMediaItem(mediaItem);

            if(holder.getBindingAdapterPosition()==position){
//                player.setMediaItem(mediaItem);
                player.prepare();
                player.play();
            }
            else{
                player.stop();
                player.seekTo(0);
                player.release();
            }

        }
    }

    @Override
    public int getItemCount() {
        return flix.size();
    }

    public class FlixViewHolder extends RecyclerView.ViewHolder{

        public PlayerView flixVideo;

        public FlixViewHolder(@NonNull View itemView) {
            super(itemView);
            flixVideo = itemView.findViewById(R.id.flixVideoView);

        }
    }
}
