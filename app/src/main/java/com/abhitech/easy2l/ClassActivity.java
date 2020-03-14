package com.abhitech.easy2l;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ClassActivity extends AppCompatActivity {

    public Button btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btngo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        btn5=(Button)findViewById(R.id.num5);
        btn6=(Button)findViewById(R.id.num6);
        btn7=(Button)findViewById(R.id.num7);
        btn8=(Button)findViewById(R.id.num8);
        btn9=(Button)findViewById(R.id.num9);
        btn10=(Button)findViewById(R.id.num10);
        btn11=(Button)findViewById(R.id.num11);
        btn12=(Button)findViewById(R.id.num12);




    }


    public void changecolor(View view) {




        switch (view.getId()) {

            case R.id.num5:

            case R.id.num6:

            case R.id.num7:


            case R.id.num8:


            case R.id.num9:


            case R.id.num10:

            case R.id.num11:


            case R.id.num12:

                int value5 = Integer.parseInt(((Button)view).getText().toString());
                Intent intent=new Intent(this,BoardActivity.class);
                intent.putExtra("class", value5);
                startActivity(intent);
                break;

            default:
                break;
        }
    }


}
