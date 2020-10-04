package com.abhitech.easy2l;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class FirstIntro extends AppCompatActivity {
    Button signup, login;
    ViewPager mviewpager;
    SliderAdapter sliderAdapter;
    WormDotsIndicator wormDotsIndicator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_intro);
        mviewpager = findViewById(R.id.viewpager1);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        wormDotsIndicator=findViewById(R.id.worm_dots_indicator);

        signup.setEnabled(false);
        sliderAdapter=new SliderAdapter(this);
        mviewpager.setAdapter(sliderAdapter);
        wormDotsIndicator.setViewPager(mviewpager);




//      SignUp button click
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstIntro.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        //      Login button click
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(FirstIntro.this, LoginActivity.class);
                startActivity(intent2);
            }
        });
    }



}
