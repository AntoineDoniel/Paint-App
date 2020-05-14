package com.example.paint;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class PaintView extends View {
    public LayoutParams params;
    private Path path = new Path() {

        private Paint brush = new Paint();

        {
            brush.setAntiAlias(true);
            brush.setColor(Color.MAGENTA);
            brush.setStyle(Paint.Style.STROKE);
            brush.setStrokeJoin(Paint.Join.ROUND);

            brush.setStrokeWidth(8f);
            params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        }


        public boolean onTouchEvent(MotionEvent event) {
            float pointX = event.getX();
            float pointY = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(pointX, pointY);
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(pointX, pointY);
                    break;
                default:
                    return false;
            }
            postInvalidate();
            return false;
        }


        protected void onDraw(Canvas Canvas) {
            Canvas.drawPath(path, brush);
        }

    } ;

    public PaintView(Context context) {
        super(context);
    }
}




