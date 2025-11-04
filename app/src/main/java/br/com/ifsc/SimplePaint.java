package br.com.ifsc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.List;

public class SimplePaint extends View {
    List<Paint> mPaintList;
    List<Path> mPathList;
    private final Paint mPaint;
    private final Path mPath;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPath = new Path();

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8f);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float lx = event.getX();
        float ly = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(lx, ly);
                return true;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                mPath.lineTo(lx, ly);
                break;
        }

        invalidate(); // redesenha
        return true;
    }

    public void setcColor(Color color) {
        mPaint.setColor(color.toArgb());
    }
}