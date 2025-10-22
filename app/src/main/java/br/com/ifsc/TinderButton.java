package br.com.ifsc;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TinderButton extends androidx.appcompat.widget.AppCompatButton {

    public TinderButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setText("Tinder Button");
    }

    public TinderButton(@NonNull Context context) {
        super(context);
        this.setText("Tinder Button");
    }

    public TinderButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setText("Tinder Button");
    }

    @Override
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
    }
    //Trata o evento de clique, a skia procura qual o componente que vai ser procurado.
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        Log.d("Posição", "X: " + x + "Posição Y: " + y);
        return super.onTouchEvent(event);
    }
}
