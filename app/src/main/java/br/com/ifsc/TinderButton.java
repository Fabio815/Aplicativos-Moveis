package br.com.ifsc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TinderButton extends androidx.appcompat.widget.AppCompatButton {
    //Em relação ao botão.
    int x0;
    int y0;
    float colorR;
    float colorG;
    float colorB;
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
        //Em relação ao botão.
        float x = event.getRawX();
        float y = event.getRawY();

        Log.d("Posição", "X: " + x + " Posição Y: " + y + " Event: " + event.getAction());
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x0 = (int)x;
            y0 = (int)y;
        }
        int dx = (int)(x - x0);
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            colorR = Math.min(255, Math.max(0, 120 - dx / 5));
            colorG = Math.min(255, Math.max(0, 120 + dx / 5));
            colorB = 120;
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            colorR = 120; colorG = 120; colorB = 120;
        }
        this.setBackgroundColor(Color.rgb(colorR, colorG, colorB));

        return super.onTouchEvent(event);
    }
}
