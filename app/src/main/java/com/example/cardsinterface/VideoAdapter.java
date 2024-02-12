package com.example.cardsinterface;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VVH> {
    private List<VideoItem>  items;

    public VideoAdapter(List<VideoItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public VVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VVH(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.vid_item,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VVH holder, int position) {
            holder.setVideoData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class VVH extends RecyclerView.ViewHolder {
    VideoView videoView;
    TextView title,desc;
    ProgressBar bar;
        public VVH(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            title = itemView.findViewById(R.id.title);
            bar = itemView.findViewById(R.id.progressBar);
            desc = itemView.findViewById(R.id.desc);
        }

        public void setVideoData(VideoItem videoItem)
        {
            title.setText(videoItem.videoTitle);
            desc.setText(videoItem.desc);
            videoView.setVideoPath(videoItem.videoUrl);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    bar.setVisibility(View.GONE);
                    mp.start();
                    float videoRatio = mp.getVideoWidth()/(float)mp.getVideoHeight();
                    float screenRatio = videoView.getWidth()/(float)videoView.getHeight();
                    float scale = videoRatio/screenRatio;
                    if (scale >= 1f)
                    {
                        videoView.setScaleX(scale);
                    }
                    else
                        videoView.setScaleY(1f/scale);
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }
}
