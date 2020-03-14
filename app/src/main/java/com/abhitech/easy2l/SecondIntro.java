package com.abhitech.easy2l;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class SecondIntro extends AppCompatActivity {
    Button getStarted;
    ViewPager mviewpager;
    Slider2Adapter slider2Adapter;
    WormDotsIndicator wormDotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_intro);
        mviewpager = findViewById(R.id.viewpager2);
        getStarted = findViewById(R.id.getstart);
        wormDotsIndicator=findViewById(R.id.worm_dots_indicator);

        slider2Adapter=new Slider2Adapter(this);
        mviewpager.setAdapter(slider2Adapter);
        wormDotsIndicator.setViewPager(mviewpager);

        //    GetStarted Intent
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondIntro.this,ClassActivity.class);
                startActivity(intent);
            }
        });

    }

}
