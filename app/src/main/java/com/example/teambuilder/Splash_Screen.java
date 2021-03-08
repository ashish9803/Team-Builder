package com.example.teambuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;

    Animation top, middle, bottom;
    ImageView l1,l2,l3,l4,l5,l6;
    TextView app_name,slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash__screen);

        top = AnimationUtils.loadAnimation(this,R.anim.top);
        middle = AnimationUtils.loadAnimation(this,R.anim.middle);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom);

        l1=findViewById(R.id.imageView);
        l2=findViewById(R.id.imageView2);
        l3=findViewById(R.id.imageView3);
        l4=findViewById(R.id.imageView4);
        l5=findViewById(R.id.imageView5);
        l6=findViewById(R.id.imageView6);

        app_name=findViewById(R.id.app_name);
        slogan=findViewById(R.id.slogan);

        l1.setAnimation(top);
        l2.setAnimation(top);
        l3.setAnimation(top);
        l4.setAnimation(top);
        l5.setAnimation(top);
        l6.setAnimation(top);

        app_name.setAnimation(middle);
        slogan.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_Screen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}