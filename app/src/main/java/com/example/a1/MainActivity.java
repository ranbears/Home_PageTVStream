package com.example.a1;

import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private VideoView videoBackground;
    private int currentVideoPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoBackground = findViewById(R.id.video_background);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ombak);
        videoBackground.setVideoURI(videoUri);

        videoBackground.setOnPreparedListener(mediaPlayer -> {
            videoBackground.start();
            Log.d("VideoState", "Video started.");
        });

        if (savedInstanceState != null) {
            currentVideoPosition = savedInstanceState.getInt("videoPosition");
            videoBackground.seekTo(currentVideoPosition);
        }

        videoBackground.setOnClickListener(view -> {
            Log.d("VideoState", "Video clicked, moving to new page.");
            moveToGuestPage();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        currentVideoPosition = videoBackground.getCurrentPosition();
        videoBackground.pause();
        Log.d("VideoState", "Video paused at position: " + currentVideoPosition);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("videoPosition", videoBackground.getCurrentPosition());
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER ||
                keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER ||
                keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
            videoBackground.stopPlayback();
            Log.d("VideoState", "Enter key pressed, moving to new page.");
            moveToGuestPage();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    private void moveToGuestPage() {
        Intent intent = new Intent(MainActivity.this, guest.class);
        startActivity(intent);
    }
}
