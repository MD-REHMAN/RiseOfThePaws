package com.afreen.wasim.rotp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MyView extends View {

    Bitmap forestBack,runningCat1;
    int screenController=-1;
    int devHeight, devWidth;
    int speed, Score, Time;
    int forestBack_x=0, forestBack_y=0;
    int Speed=2, forestBackIniPos, forestBack1, forestBack2;

    Paint paint;

    public MyView(Context context) {
        super(context);
        forestBack = BitmapFactory.decodeResource(getResources(), R.drawable.forestback);
        runningCat1 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat1);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        rect.set(0, 0, canvas.getWidth(), canvas.getHeight());
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.CYAN);
        canvas.drawRect(rect, paint);

        switch(screenController)
        {
            case -1:
                devWidth = canvas.getWidth();
                devHeight = canvas.getHeight();
                forestBackIniPos = devWidth -(2*forestBack.getWidth());


                screenController = 1;

                break;


            case 0:
            runningCat1 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat1);


                break;


        case 1:
            drawForestBack(forestBack1, forestBack_y, canvas);
            drawForestBack(forestBack2, forestBack_y, canvas);

            drawRunningCat1(200, 200, canvas);

           // Toast.makeText(getContext(),devWidth+", "+devHeight,Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(),runningCat1.getWidth()+", "+runningCat1.getHeight(),Toast.LENGTH_SHORT).show();

            //Speed
            int devUnitHeight = devHeight/100;

            if (speed<devUnitHeight*0.3f) {
                speed = speed + (devUnitHeight/200);
                Score=Score+1;
                Time++;
            }
            else if (speed<devUnitHeight*0.6f) {
                speed = speed + (devUnitHeight/300);
                Time++;
                Score=Score+2;
            }
            else if (speed<devUnitHeight*0.9f) {
                speed = speed + (devUnitHeight/500);
                Time++;
                Score=Score+4;
            }
            else if (speed<devUnitHeight*1.2f) {
                speed = speed + (devUnitHeight/700);
                Time++;
                Score=Score+5;
            }
            else if (speed<devUnitHeight*1.5f) {
                speed = speed + (devUnitHeight/900);
                Time++;
                Score=Score+7;
            }
            else if (speed<devUnitHeight*1.8f) {
                speed = speed + (devUnitHeight/1000);
                Time++;
                Score=Score+10;
            }
            else if (speed<devUnitHeight*2.1f) {
                speed = speed + (devUnitHeight/1000);
                Time++;
                Score=Score+13;
            }
            else if (speed<devUnitHeight*2.4f) {
                speed = speed + (devUnitHeight/1100);
                Time++;
                Score=Score+17;
            }
            else if (speed<devUnitHeight*2.7f) {
                speed = speed + (devUnitHeight/1200);
                Time++;
                Score=Score+20;
            }
            else if (speed<devUnitHeight*3.0f) {
                speed = speed + (devUnitHeight/1300);
                Time++;
                Score=Score+25;
            }
            else {
                speed = speed + (devUnitHeight/2000);
                Time++;
                Score=Score+50;
            }

            if(forestBack1 <= devWidth) {
                forestBack1 = forestBack1 - Speed;
            } else {
                forestBack1 = forestBackIniPos;
            }
            if(forestBack2 <= devWidth) {
                forestBack2 = forestBack2 - Speed;
            } else {
                forestBack2 = forestBackIniPos;
            }


            if (forestBack_x < canvas.getWidth()) {
                forestBack_x = forestBack_x - 2;
            } else {
                forestBack_x = 0;
            }

            break;

            default:
                break;

        }
        invalidate();

    }

    private void drawForestBack(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(forestBack, i, i1, paint);
    }

    private void drawRunningCat1(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(runningCat1, i, i1, paint);
    }







}