package com.imagine.hp.rotpaws;


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

import com.afreen.wasim.rotp.R;

public class MyView extends View {

    Bitmap forestBack;
    Bitmap runningCat1,runningCat2,runningCat3,runningCat4,runningCat5,runningCat6,runningCat7,runningCat8,runningCat9,runningCat10;
    Bitmap jumpingCat2,jumpingCat3,jumpingCat4,jumpingCat5,jumpingCat6,jumpingCat7,jumpingCat8,jumpingCat9,jumpingCat10,jumpingCat11,jumpingCat12,jumpingCat13;

    int screenController=-1;
    int devHeight, devWidth;
    int speed, Score, Time;
    int forestBack_x=0, forestBack_y=0;
    int Speed=2, forestBackIniPos, forestBack1, forestBack2;
    int baseTime=0, realTime=0;
    int runningCat[] = new int [10];

    Paint paint;

    public MyView(Context context) {
        super(context);
        forestBack = BitmapFactory.decodeResource(getResources(), R.drawable.forestback);
        runningCat1 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat1);
        runningCat2 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat2);
        runningCat3 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat3);
        runningCat4 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat4);
        runningCat5 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat5);
        runningCat6 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat6);
        runningCat7 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat7);
        runningCat8 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat8);
        runningCat9 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat9);
        runningCat10 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat10);
        jumpingCat2 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat2);
        jumpingCat3 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat3);
        jumpingCat4 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat4);
        jumpingCat5 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat5);
        jumpingCat6 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat6);
        jumpingCat7 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat7);
        jumpingCat8 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat8);
        jumpingCat9 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat9);
        jumpingCat10 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat10);
        jumpingCat11 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat11);
        jumpingCat12 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat12);
        jumpingCat13 = BitmapFactory.decodeResource(getResources(),R.drawable.jumpingcat13);



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

        baseTime++;
        if (baseTime%50==0){
            realTime++;

        }

        switch(screenController)
        {
            case -1:
                devWidth = canvas.getWidth();
                devHeight = canvas.getHeight();
                forestBackIniPos = devWidth -(2*forestBack.getWidth());


                screenController = 1;

                break;


            case 0:


                break;


            case 1:
                drawForestBack(forestBack1, forestBack_y, canvas);
                drawForestBack(forestBack2, forestBack_y, canvas);

                // Toast.makeText(getContext(),devWidth+", "+devHeight,Toast.LENGTH_SHORT).show();
                //Toast.makeText(getContext(),runningCat1.getWidth()+", "+runningCat1.getHeight(),Toast.LENGTH_SHORT).show();

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

                //Cat Annimation
                if(realTime%10==0) {
                    drawRunningCat1(0, devHeight-runningCat1.getHeight(), canvas);
                }
                if(realTime%10==1) {
                    drawRunningCat2(0, devHeight - runningCat2.getHeight(), canvas);
                }
                if(realTime%10==2) {
                    drawRunningCat3(0, devHeight-runningCat3.getHeight(), canvas);
                }
                if(realTime%10==3) {
                    drawRunningCat4(0, devHeight-runningCat4.getHeight(), canvas);
                }
                if(realTime%10==4) {
                    drawRunningCat5(0, devHeight-runningCat5.getHeight(), canvas);
                }
                if(realTime%10==5) {
                    drawRunningCat6(0, devHeight-runningCat6.getHeight(), canvas);
                }
                if(realTime%10==6) {
                    drawRunningCat7(0, devHeight-runningCat7.getHeight(), canvas);
                }
                if(realTime%10==7) {
                    drawRunningCat8(0, devHeight-runningCat8.getHeight(), canvas);
                }
                if(realTime%10==8) {
                    drawRunningCat9(0, devHeight-runningCat9.getHeight(), canvas);
                }
                if(realTime%10==9) {
                    drawRunningCat10(0, devHeight-runningCat10.getHeight(), canvas);
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

    private void drawRunningCat2(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(runningCat2, i, i1, paint);
    }
    private void drawRunningCat3(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(runningCat3, i, i1, paint);
    }
    private void drawRunningCat4(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(runningCat4, i, i1, paint);
    }
    private void drawRunningCat5(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(runningCat5, i, i1, paint);
    }
    private void drawRunningCat6(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(runningCat6, i, i1, paint);
    }
    private void drawRunningCat7(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(runningCat7, i, i1, paint);
    }
    private void drawRunningCat8(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(runningCat8, i, i1, paint);
    }
    private void drawRunningCat9(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(runningCat9, i, i1, paint);
    }
    private void drawRunningCat10(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(runningCat10, i, i1, paint);
    }
    private void drawJumpingCat2(int i,int i1,Canvas canvas) {
        canvas.drawBitmap(jumpingCat2, i, i1, paint);
    }
    private void drawJumpingCat3(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat3, i, i1, paint);
    }
    private void drawJumpingCat4(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat4, i, i1, paint);
    }
    private void drawJumpingCat5(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat5, i, i1, paint);
    }
    private void drawJumpingCat6(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat6, i, i1, paint);
    }
    private void drawJumpingCat7(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat7, i, i1, paint);
    }
    private void drawJumpingCat8(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat8, i, i1, paint);
    }
    private void drawJumpingCat9(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat9, i, i1, paint);
    }
    private void drawJumpingCat10(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat10, i, i1, paint);
    }
    private void drawJumpingCat11(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat11, i, i1, paint);
    }
    private void drawJumpingCat12(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat12, i, i1, paint);
    }
    private void drawJumpingCat13(int i,int i1,Canvas canvas){
        canvas.drawBitmap(jumpingCat13, i, i1, paint);
    }








}