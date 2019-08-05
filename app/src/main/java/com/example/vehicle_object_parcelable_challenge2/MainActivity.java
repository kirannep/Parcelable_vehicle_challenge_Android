package com.example.vehicle_object_parcelable_challenge2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView display_vehicleInfo;
    private Button goto_secondActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display_vehicleInfo = findViewById(R.id.display_vehicleInfo_tv);
        goto_secondActivity = findViewById(R.id.goto_secondActivity);
        goto_secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                Vehicle car = data.getParcelableExtra("vehicleInfo");
                display_vehicleInfo.setText("This Vehicle is of "+car.getMake()+" brand with "+car.getColor()+" color and has "+car.getNum_of_doors()+" doors");
            }
            if (resultCode == RESULT_CANCELED){

            }
        }
    }
}
