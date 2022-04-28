package com.myproject.booksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_Activity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Animation up,down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView = findViewById(R.id.appsplash);
        up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        imageView.setAnimation(up);




        TextView textView = findViewById(R.id.appname);
        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        textView.setAnimation(down);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(getApplicationContext(),Signin_Activity.class));
                finish();
            }
        },3500);

    }

}