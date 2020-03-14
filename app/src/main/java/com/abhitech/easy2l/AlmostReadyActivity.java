package com.abhitech.easy2l;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlmostReadyActivity extends AppCompatActivity {

    Button button;
    public TextView myclass,myboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almost_ready);




        myclass=(TextView)findViewById(R.id.classmain);
        myboard=(TextView)findViewById(R.id.boardmain);

        final Intent intent = getIntent();


        String boardname = intent.getStringExtra("board");
        final  int sclass = getIntent().getIntExtra("class", 0);

        myclass.setText("Class: "+sclass);
        myboard.setText("Class: "+boardname);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(AlmostReadyActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
