package com.imagine.hp.beatit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyService extends Activity implements View.OnClickListener {
    Button ob1, ob2;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);
        ob1 = (Button) findViewById(R.id.button14);
        ob2 = (Button) findViewById(R.id.button15);
        ob1.setOnClickListener(this);
        ob2.setOnClickListener(this);
        i = new Intent(MyService.this, MusicService.class);


    }

    @Override
    public void onClick(View v) {
        if (v==ob1) {
           // Toast.makeText(getApplicationContext(), "Start music service", Toast.LENGTH_LONG).show();
            startService(i);
            finish();
        } else if (v==ob2) {
            //Toast.makeText(getApplicationContext(),"Stop music service",Toast.LENGTH_LONG).show();
            stopService(i);
            finish();
        }
    }

}


