package com.example.vehicle_object_parcelable_challenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button goto_firstactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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
