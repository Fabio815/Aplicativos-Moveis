package br.com.ifsc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimplePaint extends View {
    List<Paint> mPaintList;
    List<Path> mPathList;
    private Paint mPaint;
    private Path mPath;
    ColorDrawable currentColor;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaintList = new ArrayList<Paint>();
        mPathList = new ArrayList<Path>();
        mPaint.setColor(Color.BLACK);
        currentColor = new ColorDrawable();
        currentColor.setColor(Color.BLACK);
        initLayerDraq();
    }

    public void initLayerDraq() {
        mPaint = new Paint();
        mPath = new Path();

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setColor(currentColor.getColor());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mPathList.size(); i++) {
            canvas.drawPath(mPathList.get(i), mPaintList.get(i));
        }
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float lx = event.getX();
        float ly = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(lx, ly);
                mPath.lineTo(lx, ly);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(lx, ly);
                break;
            case MotionEvent.ACTION_UP:
                mPath.lineTo(lx, ly);
                mPaintList.add(mPaint);
                mPathList.add(mPath);
                initLayerDraq();
                break;
            default:
                break;
        }

        invalidate(); // redesenha
        return true;
    }

    public void setcColor(Color color) {
        currentColor.setColor(color.toArgb());
        mPaint.setColor(color.toArgb());
    }
}