package com.example.cardsinterface;

public class VideoItem {
    public String videoUrl,videoTitle,desc;

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getDesc() {
        return desc;
    }

    public VideoItem() {

    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
