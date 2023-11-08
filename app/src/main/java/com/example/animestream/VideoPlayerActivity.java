package com.example.animestream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.collect.ImmutableList;

public class VideoPlayerActivity extends AppCompatActivity {
    private SimpleExoPlayer player;
    private PlayerView playerView;
    private boolean isFullScreen = false;
    private String videoUrl;
    Button fullScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        // Retrieve the video URL from the intent
        videoUrl = getIntent().getStringExtra("videoUrl");

        playerView = findViewById(R.id.playerView1);



        // Create a new ExoPlayer instance
        player = new SimpleExoPlayer.Builder(this).build();
        playerView.setPlayer(player);



        // Create a MediaSource using the video URL
        MediaSource mediaSource = buildMediaSource(Uri.parse(videoUrl));

        // Prepare the player with the MediaSource
        player.prepare(mediaSource);




        // Inside your activity's onCreate method or where you set up ExoPlayer:
        fullScreenButton = findViewById(R.id.fullscreen_button);
        fullScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleFullScreen();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        player.setPlayWhenReady(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.setPlayWhenReady(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
    private void toggleFullScreen() {
        if (isFullScreen) {
            // Exit full-screen mode
            // Update the button icon and perform necessary layout adjustments
            fullScreenButton.setBackgroundResource(R.drawable.baseline_fullscreen_24); // Set the enter full-screen icon
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Portrait mode
            isFullScreen = false;
        } else {
            // Enter full-screen mode
            // Update the button icon and perform necessary layout adjustments
            fullScreenButton.setBackgroundResource(R.drawable.baseline_fullscreen_exit_24); // Set the exit full-screen icon
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // Landscape mode
            isFullScreen = true;
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checking the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Set PlayerView params for fullscreen mode
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
            params.width = params.MATCH_PARENT;
            params.height = params.MATCH_PARENT;
            playerView.setLayoutParams(params);

            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LOW_PROFILE
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            // Set PlayerView params for normal mode
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
            params.width = params.MATCH_PARENT;
            params.height = 600; // You can replace 600 with any specific value
            playerView.setLayoutParams(params);

            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }
    }
    private void hideSystemUI() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    private void showSystemUI() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }

    private MediaSource buildMediaSource(Uri uri) {
        return new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(this, "your_user_agent"))
                .createMediaSource(MediaItem.fromUri(uri));
    }

}
