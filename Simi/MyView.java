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
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.afreen.wasim.rotp.R;

public class MyView extends View {

    Bitmap forestBack;
    Bitmap backUp2;
    Bitmap runningCat1,runningCat2,runningCat3,runningCat4,runningCat5,runningCat6,runningCat7,runningCat8,runningCat9,runningCat10;
    Bitmap one,two,three,four,five,six,seven,eight,nine,zero;
    Bitmap playButton,pauseButton,howToPlayButton,aboutUsButton;
    Bitmap bamboo1,bamboo2,bamboo3,bamboo4,bamboo5,bamboo6,bamboo7,bamboo8;
    Bitmap jumpingCat2,jumpingCat3,jumpingCat4,jumpingCat5,jumpingCat6,jumpingCat7,jumpingCat8,jumpingCat9,jumpingCat10,jumpingCat11,jumpingCat12,jumpingCat13;

    int screenController=-1, cat_y;
    int devHeight, devWidth, devUnitHeight, devUnitWidth;
    int speed, Score, Time, jumpSpeed=5, jumpStartFlag=0, fallStartFlag=0;
    float touch_x, touch_y;
    int forestBack_x=0, forestBack_y=0;
    int bamboo1_x=0,bamboo1_y=0;
    int bamboo2_x=0,bamboo2_y=0;
    int bamboo3_x=0,bamboo3_y=0;
    int bamboo4_x=0,bamboo4_y=0;
    int bamboo5_x=0,bamboo5_y=0;
    int  bamboo6_x=0,bamboo6_y=0;
    int  bamboo7_x=0,bamboo7_y=0;
    int  bamboo8_x=0,bamboo8_y=0;
    int Speed=15, forestBackIniPos, forestBack1, forestBack2,backUp2_x;
    int baseTime=0, realTime=0;
    int runningCat[] = new int [10];


    Paint paint;
    private int IsFalling;
    private int Isjumping;

    public MyView(Context context) {
        super(context);
        forestBack = BitmapFactory.decodeResource(getResources(), R.drawable.forestback);
        backUp2 = BitmapFactory.decodeResource(getResources(),R.drawable.backup2);
        runningCat1 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat1);
        runningCat2 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat2);
        runningCat3 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat3);
        runningCat4 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat4);
        runningCat5 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat5);
        runningCat6 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat6);
       /* runningCat7 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat7);
        runningCat8 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat8);
        runningCat9 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat9);
        runningCat10 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat10);*/
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
        zero = BitmapFactory.decodeResource(getResources(),R.drawable.zero);
        one = BitmapFactory.decodeResource(getResources(),R.drawable.one);
        two = BitmapFactory.decodeResource(getResources(),R.drawable.two);
        three = BitmapFactory.decodeResource(getResources(),R.drawable.three);
        four = BitmapFactory.decodeResource(getResources(),R.drawable.four);
        five = BitmapFactory.decodeResource(getResources(),R.drawable.five);
        six = BitmapFactory.decodeResource(getResources(),R.drawable.six);
        seven = BitmapFactory.decodeResource(getResources(),R.drawable.seven);
        eight = BitmapFactory.decodeResource(getResources(),R.drawable.eight);
        nine = BitmapFactory.decodeResource(getResources(),R.drawable.nine);
        playButton = BitmapFactory.decodeResource(getResources(),R.drawable.playbutton);
        pauseButton = BitmapFactory.decodeResource(getResources(),R.drawable.pausebutton);
       howToPlayButton = BitmapFactory.decodeResource(getResources(),R.drawable.howtoplaybutton);
       aboutUsButton = BitmapFactory.decodeResource(getResources(),R.drawable.aboutusbutton);
        bamboo1 = BitmapFactory.decodeResource(getResources(),R.drawable.bamboo1);
        bamboo2 = BitmapFactory.decodeResource(getResources(),R.drawable.bamboo2);
        bamboo3 = BitmapFactory.decodeResource(getResources(),R.drawable.bamboo3);
        bamboo4 = BitmapFactory.decodeResource(getResources(),R.drawable.bamboo4);
        bamboo5 = BitmapFactory.decodeResource(getResources(),R.drawable.bamboo5);
        bamboo6 = BitmapFactory.decodeResource(getResources(),R.drawable.bamboo6);
        bamboo7 = BitmapFactory.decodeResource(getResources(),R.drawable.bamboo7);
        bamboo8 = BitmapFactory.decodeResource(getResources(),R.drawable.bamboo8);





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
                forestBackIniPos = devWidth + devUnitWidth*20;
                devUnitHeight = devHeight/100;
                devUnitWidth = devWidth/100;
                cat_y=devHeight-runningCat1.getHeight();

                screenController = 1;

                break;


            case 0:


                break;


            case 1:

                setOnTouchListener(new View.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                touch_x = event.getX();
                                touch_y = event.getY();
                                break;
                            default:
                                break;
                        }
                       if(touch_x>0 && touch_y>0) {
                            jumpStartFlag=1;
                            Isjumping = 1;
                        }

                        if(Isjumping == 1) {
                            cat_y = cat_y - jumpSpeed;
                            // This is the part we're we will draw jumping cats
                        }


                        if(cat_y >= runningCat1.getHeight()) {
                            Isjumping = 0;
                            IsFalling = 1;
                        }

                        if(IsFalling == 1) {
                            int fallSpeed=0;
                            cat_y = cat_y - fallSpeed;
                            // And in the part we'll draw falling cats
                        }


                        int ground_y = 0;
                        if(cat_y <= ground_y) {
                            cat_y = ground_y;
                            IsFalling = 0;
                        }
                        return false;



                        }



                });


               /* if (jumpStartFlag==1 && cat_y>=jumpingCat10.getHeight()+jumpingCat10.getHeight()/2){
                    Toast.makeText(getContext(),"jump start",Toast.LENGTH_LONG).show();
                    cat_y = cat_y - jumpSpeed;

                }
                if (fallStartFlag==1 && cat_y<=devHeight) {

                    cat_y = cat_y + jumpSpeed;
                }*/





            //drawForestBack(forestBack1, forestBack_y, canvas);
                //drawForestBack(forestBack2, forestBack_y, canvas);

                //drawbackUp2(forestBack1, forestBack_y, canvas);
                drawbamboo1(bamboo1_x, bamboo1_y, canvas);
                drawbamboo3(bamboo3_x, bamboo3_y,canvas);
                drawbamboo5(bamboo5_x, bamboo5_y,canvas);
                drawbamboo6(bamboo6_x, bamboo6_y,canvas);
                drawbamboo7(bamboo7_x, bamboo7_y,canvas);
                drawbamboo4(bamboo4_x, bamboo4_y,canvas);
                drawbamboo2(bamboo2_x, bamboo2_y,canvas);
                drawbamboo8(bamboo8_x, bamboo8_y,canvas);
                drawJumpingCat10(forestBack1, devHeight-runningCat1.getHeight(), canvas);

                // Toast.makeText(getContext(),devWidth+", "+devHeight,Toast.LENGTH_SHORT).show();
                //Toast.makeText(getContext(),runningCat1.getWidth()+", "+runningCat1.getHeight(),Toast.LENGTH_SHORT).show();

                //Speed

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

                if(forestBack1+backUp2.getWidth()<=0) {
                    forestBack1 = forestBackIniPos;
                }else {
                forestBack1 = forestBack1 - Speed;
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
                if(realTime%6==0) {
                    drawRunningCat1(0, cat_y, canvas);
                }
                if(realTime%6==1) {
                    drawRunningCat2(0, cat_y, canvas);
                }
                if(realTime%6==2) {
                    drawRunningCat3(0, cat_y, canvas);
                }
                if(realTime%6==3) {
                    drawRunningCat4(0, cat_y, canvas);
                }
                if(realTime%6==4) {
                    drawRunningCat5(0, cat_y, canvas);
                }
                if(realTime%6==5) {
                    drawRunningCat6(0, cat_y, canvas);
                }
                /*if(realTime%10==6) {
                    drawRunningCat7(0, cat_y, canvas);
                }
                if(realTime%10==7) {
                    drawRunningCat8(0, cat_y, canvas);
                }
                if(realTime%10==8) {
                    drawRunningCat9(0, cat_y, canvas);
                }
                if(realTime%10==9) {
                    drawRunningCat10(0, cat_y, canvas);
                }
*/



                break;



        }

    invalidate(); {

    }

}



    void jumpStart(int cat_y) {
        //cat_y = cat_y + jumpSpeed;
        if (cat_y>=jumpingCat10.getHeight()+jumpingCat10.getHeight()/2){
            cat_y = cat_y - jumpSpeed;
        } else {
            cat_y = cat_y + jumpSpeed;
        }
    }

    private void drawbamboo1(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(bamboo1, i, i1, paint);
    }
    private void drawbamboo3(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(bamboo3, i, i1, paint);
    }
    private void drawbamboo5(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(bamboo5, i, i1, paint);
    }
    private void drawbamboo6(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(bamboo6, i, i1, paint);
    }
    private void drawbamboo7(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(bamboo7, i, i1, paint);
    }
    private void drawbamboo4(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(bamboo4, i, i1, paint);
    }
    private void drawbamboo2(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(bamboo2, i, i1, paint);
    }
    private void drawbamboo8(int i, int i1, Canvas canvas) {
        canvas.drawBitmap(bamboo8, i, i1, paint);
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
   /* private void drawRunningCat7(int i, int i1, Canvas canvas) {
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
    }*/
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