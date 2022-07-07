package com.example.stop_watch;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.stop_watch.databinding.ActivityStopwatchBinding;

public class stopwatch extends AppCompatActivity {
    ActivityStopwatchBinding binding2;
    Animation anim3;
    private boolean aBoolean;
    private long off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding2=ActivityStopwatchBinding.inflate(getLayoutInflater());
        setContentView(binding2.getRoot());

        binding2.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load animation
                anim3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim3);
                //set animation
                binding2.lineImage.startAnimation(anim3);
                binding2.startButton.setText("resume");
                if(!aBoolean){
                    binding2.textTime.setBase(SystemClock.elapsedRealtime()-off);
                    binding2.textTime.start();
                    aBoolean=true;
                }

            }
        });
        binding2.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //anim3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim4);
               // //set animation
                //binding2.lineImage.startAnimation(anim3);
                binding2.lineImage.clearAnimation();
                if(aBoolean){
                    binding2.textTime.stop();
                    off=SystemClock.elapsedRealtime()- binding2.textTime.getBase();
                    aBoolean=false;
                }

            }
        });

        binding2.restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  anim3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim4);
                //set animation
               // binding2.lineImage.startAnimation(anim3);
                binding2.lineImage.clearAnimation();
                binding2.startButton.setText("start");
                binding2.textTime.stop();
                aBoolean=false;
                binding2.textTime.setBase(SystemClock.elapsedRealtime());
                off=0;
            }
        });
    }
}