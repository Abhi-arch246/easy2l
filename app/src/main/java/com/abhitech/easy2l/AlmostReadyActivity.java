package com.abhitech.easy2l;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlmostReadyActivity extends AppCompatActivity {

    public TextView myclass,myboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almost_ready);




        myclass=(TextView)findViewById(R.id.classmain);
        myboard=(TextView)findViewById(R.id.boardmain);

        Intent intent = getIntent();


        String boardname = intent.getStringExtra(Intent.EXTRA_TEXT);
        final  int sclass = getIntent().getIntExtra("class", 0);

        myclass.setText("Class: "+sclass);
        myboard.setText("Class: "+boardname);
    }
}
