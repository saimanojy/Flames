package com.example.saimanoj.flames;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by saimanoj on 25-02-2018.
 */

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    String extStorageDirectory;
    protected static final int PLAY = 0x101;
    protected static final int STOP = 0x102;
    protected static final int PAUSE = 0x103;
    int State;
    private String current;

    private String path ;
    private VideoView mVideoView;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        path="android.resource://com.example.saimanoj.flames/"+R.raw.videomain;
        mVideoView = (VideoView) findViewById(R.id.video);
        if (path == null || path.length() == 0) {
            Toast.makeText(MainActivity.this, "File URL/path is empty",
                    Toast.LENGTH_LONG).show();

        } else {
            // If the path has not changed, just start the media player
            if (path.equals(current) && mVideoView != null) {
                mVideoView.start();
                mVideoView.requestFocus();
                return;
            }
            current = path;
            mVideoView.setVideoPath(path);
            mVideoView.start();
            mVideoView.requestFocus();
        }
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                Intent in =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(in);
                finish();
            }
        });
    }
}
