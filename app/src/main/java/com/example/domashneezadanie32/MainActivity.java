package com.example.domashneezadanie32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textCoordinates;
    float x, y;
    String sDown, sMove, sUp;
    final float xCat = 800, yCat = 800, deltaCat = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textCoordinates = findViewById(R.id.textView);
        textCoordinates.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getX();
                y = event.getY();
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        sDown = "Нажатие:\nкоордината Х: " + x + "\nкоордината Y: " + y;
                        sMove = "";
                        sUp = "";
                        break;
                    case MotionEvent.ACTION_UP:
                        sDown = "";
                        sMove = "";
                        sUp = "Отпускание:\nкоордината Х: " + x + "\nкоордината Y: " + y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        sMove = "Движение:\nкоордината Х: " + x + "\nкоордината Y: " + y;
                        if (x<(xCat+deltaCat) && x>(xCat-deltaCat) && y<(yCat+deltaCat)
                                && y>(yCat-deltaCat)){
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "УРА!!! КОТ НАШЁЛСЯ!", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.START|Gravity.TOP, (int) x, (int) y);
                            LinearLayout toastConteiner = (LinearLayout) toast.getView();
                            ImageView cat = new ImageView(getApplicationContext());
                            cat.setImageResource(R.drawable.cat);
                            toastConteiner.addView(cat);
                            toast.show();
                        }
                        break;
                }
                textCoordinates.setText(sDown+"\n"+sMove+"\n"+sUp);
                return true;
            }
        });
    }
}