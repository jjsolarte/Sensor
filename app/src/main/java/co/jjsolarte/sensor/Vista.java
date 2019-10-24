package co.jjsolarte.sensor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class Vista extends View {

    String action="down";
    float x=0;
    float y=0;
    Path path;

    public Vista(Context context) {
        super(context);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);

        int ancho = canvas.getWidth();
        if (action.equals("down"))
            path.moveTo(x,y);
        if (action.equals("move"))
            path.lineTo(x,y);

        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            action = "down";
        if (event.getAction() == MotionEvent.ACTION_MOVE)
            action = "move";
        invalidate();
        return true;
    }
}
