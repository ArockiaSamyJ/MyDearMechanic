package com.mydearmechanic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class CustomerRegistratioon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registratioon);
        TextView tv = (TextView) findViewById(R.id.textV);
        Animation anim = new AlphaAnimation(0.0f, 10.0f);//0.0 means Black and 1.0 full opacity
        anim.setDuration(500);
        anim.setStartOffset(200);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatMode(Animation.INFINITE);
        tv.startAnimation(anim);

    }
}