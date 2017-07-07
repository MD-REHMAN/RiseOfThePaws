package com.afreen.wasim.rotp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.imagine.hp.rotpaws.MyView;

public class MainActivity extends Activity {
    Intent i;
    Button ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* MyView mv = new MyView(this);
        setContentView(mv);*/
        ib=(Button)findViewById(R.id.button5);
        ib.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent i1=new Intent(MainActivity.this,secondPage.class);
                startActivity(i1);
                return false;
            }
        });

        i=new Intent(this,MusicService.class);
        startService(i);




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(i);
    }
}
