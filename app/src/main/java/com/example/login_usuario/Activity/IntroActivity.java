package com.example.login_usuario.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;


import com.example.login_usuario.R;

public class IntroActivity extends AppCompatActivity {
    private static final int Tiempo_SPLASH = 600000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        final ProgressBar progressBar = findViewById(R.id.loadingProgressBar);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setDuration(1000);


        progressBar.startAnimation(fadeOut);


        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                progressBar.setVisibility(View.GONE);


                Intent intent = new Intent(IntroActivity.this, Intro_btnActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, Tiempo_SPLASH);

    }
}