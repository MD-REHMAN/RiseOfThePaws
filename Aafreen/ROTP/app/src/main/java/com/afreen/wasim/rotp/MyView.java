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

public class MyView extends View {

    Bitmap forestBack,runningCat1;
    int screenController=0;
    int forestBack_x=0, forestBack_y=0;

    Paint paint;

    public MyView(Context context) {
        super(context);
        forestBack = BitmapFactory.decodeResource(getResources(), R.drawable.forestback);

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
            case 0:
            runningCat1 = BitmapFactory.decodeResource(getResources(),R.drawable.runningcat1);


                break;


        case 1:
            drawForestBack(forestBack_x, forestBack_y, canvas);


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



