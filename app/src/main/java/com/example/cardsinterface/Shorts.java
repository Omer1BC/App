package com.example.cardsinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Shorts extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shorts);
        ViewPager2 pager = findViewById(R.id.videoViewPager);

        List<VideoItem> items = new ArrayList<>();

        VideoItem celeb = new VideoItem();
        celeb.videoUrl = "android.resource://" +getPackageName() + "/" + R.raw.sample;
        celeb.videoTitle = "Short1";
        celeb.desc = "Let's all celebrate and have a good time, celebration!";
        items.add(celeb);

        VideoItem celeb2 = new VideoItem();
        celeb2.videoUrl = "android.resource://" +getPackageName() + "/" + R.raw.sample;
        celeb2.videoTitle = "Short2";
        celeb2.desc = "Let's all celebrate and have a good time, celebration!";
        items.add(celeb2);

        pager.setAdapter(new VideoAdapter(items));






    }
}