package com.abhitech.easy2l;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class BoardActivity extends AppCompatActivity {

    public CardView bcard1,bcard2,bcard3;

    public TextView txtclass,btitle1,btitle2,btitle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        setContentView(R.layout.activity_board);

        bcard1=(CardView)findViewById(R.id.boardcard1);

        bcard2=(CardView)findViewById(R.id.boardcard2);
        bcard3=(CardView)findViewById(R.id.boardcard3);
        btitle1=(TextView)findViewById(R.id.boardtitle1);

        btitle2=(TextView)findViewById(R.id.boardtitle2);
        btitle3=(TextView)findViewById(R.id.boardtitle3);


        txtclass=(TextView)findViewById(R.id.getclass);

        final int getclass = getIntent().getIntExtra("class", 0);
        txtclass.setText("CLASS :"+getclass);

        bcard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(BoardActivity.this,AlmostReadyActivity.class);
                intent.putExtra("class", getclass);
                intent.putExtra("board", String.valueOf(btitle1));
                startActivity(intent);
            }
        });


        bcard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(BoardActivity.this,AlmostReadyActivity.class);
                intent.putExtra("class", getclass);
                intent.putExtra("board", String.valueOf(btitle2));
                startActivity(intent);
            }
        });


        bcard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(BoardActivity.this,AlmostReadyActivity.class);
                intent.putExtra("class", getclass);
                intent.putExtra("board", String.valueOf(btitle3));
                startActivity(intent);
            }
        });






    }
}
