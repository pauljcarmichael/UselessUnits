package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConvertTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_time);
        TextView mmTextview = findViewById(R.id.textView);

        Intent intent = getIntent();
        String area = intent.getExtras().getString("value");
        Double areaDouble = Double.valueOf(area);

        String units = intent.getExtras().getString("unit");
        mmTextview.setText(areaDouble.toString());

    }



}
