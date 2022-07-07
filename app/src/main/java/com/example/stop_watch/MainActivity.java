package com.example.stop_watch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stop_watch.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    Animation anim1,anim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //load animation
        anim1= AnimationUtils.loadAnimation(this,R.anim.anim1);
        anim2= AnimationUtils.loadAnimation(this,R.anim.anim2);
        //set animation
        binding.mainImage.startAnimation(anim1);
        binding.getButton.startAnimation(anim2);
        binding.textView.startAnimation(anim1);
        binding.getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),stopwatch.class);
                startActivity(in);
            }
        });


    }
}