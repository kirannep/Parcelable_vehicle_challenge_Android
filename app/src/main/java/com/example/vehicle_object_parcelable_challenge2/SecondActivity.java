package com.example.vehicle_object_parcelable_challenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import static android.view.View.VISIBLE;
import static android.view.animation.Animation.*;

public class SecondActivity extends AppCompatActivity {
    private Button goto_firstactivity;
    private ImageView car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        car = findViewById(R.id.iv_car);
        ObjectAnimator blink = ObjectAnimator.ofInt(car, "backgroundColor",Color.WHITE,Color.RED,Color.WHITE);
        blink.setDuration(1000);
        blink.setEvaluator(new ArgbEvaluator());
        blink.setRepeatMode(ValueAnimator.REVERSE);
        blink.setRepeatCount(ValueAnimator.INFINITE);
        blink.start();

        goto_firstactivity = findViewById(R.id.goto_firstActivity);
        goto_firstactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vehicle vehicle = new Vehicle("Ford","blue",4);
                Intent intent = new Intent();
                intent.putExtra("vehicleInfo",vehicle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
