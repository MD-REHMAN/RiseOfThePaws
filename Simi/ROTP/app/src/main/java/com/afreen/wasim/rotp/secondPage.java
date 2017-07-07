package com.afreen.wasim.rotp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class secondPage extends Activity {
    Button ob1,ob2,ob3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        ob1=(Button)findViewById(R.id.button2);
        ob2=(Button)findViewById(R.id.button3);
        ob3=(Button)findViewById(R.id.button4);
        ob1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent i=new Intent(secondPage.this,login.class);
                startActivity(i);
                return false;
            }
        });
        ob2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               Intent i1=new Intent(secondPage.this,aboutUs.class);
                startActivity(i1);
                return false;

            }
        });
        ob3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               Intent i2=new Intent(secondPage.this,howTo.class);
                startActivity(i2);
                return false;
            }
        });
    }
}
