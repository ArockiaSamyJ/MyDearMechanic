package com.mydearmechanic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class LogandRegisterPage extends AppCompatActivity {
TextView login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logand_register_page);
        login=findViewById(R.id.login);
        register=findViewById(R.id.Register);

        Animation anim = new AlphaAnimation(0.0f, 10.0f);//0.0 means Black and 1.0 full opacity
        anim.setDuration(500);
        anim.setStartOffset(200);
        anim.setRepeatCount(Animation.INFINITE);
        anim.setRepeatMode(Animation.INFINITE);
        login.startAnimation(anim);
        register.startAnimation(anim);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogandRegisterPage.this,CustomerLogin.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogandRegisterPage.this,CustomerRegistratioon.class);
                startActivity(intent);
            }
        });
    }
}