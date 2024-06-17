package com.example.flixdintest;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        VideoView videoView = findViewById(R.id.video_view);

        Uri uri = Uri.parse("https://minio.flixdin.com/test/yala.webm/playlist.m3u8");
        videoView.setVideoURI(uri);
        videoView.start();



    }
}