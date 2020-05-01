package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    private ImageButton lengthButton;
    private ImageButton areaButton;
    private ImageButton timeButton;
    private ImageButton powerButton;

    private String entryValue;
    private String entryUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lengthButton = (ImageButton) findViewById(R.id.imageButton);
        areaButton = (ImageButton) findViewById(R.id.imageButton2);
        timeButton = (ImageButton) findViewById(R.id.imageButton3);
        powerButton = (ImageButton) findViewById(R.id.imageButton4);

        lengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterLength();
            }
        });

        areaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterArea();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterTime();
            }
        });

        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterPower();
            }
        });
    }

    public void enterLength() { //length currently has its own intermediary class to do its data collection
        Intent lengthIntent = new Intent(this, ConvertLength.class);

        EnterDialog timeDialog = new EnterDialog(getLayoutInflater().inflate(R.layout.dialog_enter_length, null), lengthIntent);
        timeDialog.show(getSupportFragmentManager(), "Length Dialog");
    }

    public void enterArea() {
        Intent areaIntent = new Intent(this, ConvertArea.class);

        EnterDialog timeDialog = new EnterDialog(getLayoutInflater().inflate(R.layout.dialog_enter_area, null), areaIntent);
        timeDialog.show(getSupportFragmentManager(), "Area Dialog");
    }

    public void enterTime() {
        Intent timeIntent = new Intent(this, ConvertTime.class);

        EnterDialog timeDialog = new EnterDialog(getLayoutInflater().inflate(R.layout.dialog_enter_time, null), timeIntent);
        timeDialog.show(getSupportFragmentManager(), "Time Dialog");
    }

    public void enterPower() {
        Intent powerIntent = new Intent(this, ConvertPower.class);

        EnterDialog timeDialog = new EnterDialog(getLayoutInflater().inflate(R.layout.dialog_enter_power, null), powerIntent);
        timeDialog.show(getSupportFragmentManager(), "Power Dialog");
    }
}
