package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Animate the logo with a pop-in effect
        ImageView logo = findViewById(R.id.splash_logo);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.logo_pop);
        logo.startAnimation(anim);

        // Wait 2 seconds then go to the list screen
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {}
            startActivity(new Intent(SplashActivity.this, ListPizzaActivity.class));
            finish();
        }).start();
    }
}
