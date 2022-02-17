package com.example.simplestopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //initalise values
    Button pause;
   // ImageView img;
    Animation anim;
    private Chronometer chronometer;
    private boolean running;
    private Long tstart ;
    private int pauseoffset ;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // img =findViewById(R.id.imageview);
        pause=findViewById(R.id.pause);
        anim= AnimationUtils.loadAnimation(this,R.anim.rotate);
        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("%s");

    }
    //start Button
    public void startchronometer (View v){

        if (!running) {

            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            running = true;
           //img.startAnimation(anim);
        }
    }
    //pause Button
    public void pauschronometer (View v){
        if (running) {

            tstart = SystemClock.elapsedRealtime();
            chronometer.stop();
            running = false;

        }
    }
    //reset Button
    public void resetchronometer (View v){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoffset = 0;
    }
}
