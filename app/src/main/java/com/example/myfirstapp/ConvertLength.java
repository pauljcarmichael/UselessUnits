package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.lengthFragments.LengthFragment1;
import com.example.myfirstapp.lengthFragments.LengthFragment2;
import com.example.myfirstapp.lengthFragments.LengthFragment3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConvertLength extends AppCompatActivity {
    private TextView mmTextview;
    private TextView cmTextview;
    private TextView mTextview;
    private TextView inTextview;
    private TextView ftTextview;
    private TextView ydTextview;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private Double inputInMetres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_length);

        mmTextview = findViewById(R.id.textView6);
        cmTextview = findViewById(R.id.textView7);
        mTextview = findViewById(R.id.textView8);
        inTextview = findViewById(R.id.textView9);
        ftTextview = findViewById(R.id.textView10);
        ydTextview = findViewById(R.id.textView11);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String length = intent.getExtras().getString("value");
        Double lengthDouble = Double.valueOf(length);




        String units = intent.getExtras().getString("unit");

        switch (units) {
            case "mm": {
                lengthPrint(lengthDouble / 1000);
                break;
            }
            case "cm": {
                lengthPrint(lengthDouble / 100);
                break;
            }
            case "m": {
                lengthPrint(lengthDouble);
                break;
            }
            case "in": {
                lengthPrint(lengthDouble / 39.37);
                break;
            }
            case "ft": {
                lengthPrint(lengthDouble / 3.28);
                break;
            }
            case "yd": {
                lengthPrint(lengthDouble / 1.094);
                break;
            }
        }

        List<Fragment> list = new ArrayList<>();
        list.add(new LengthFragment1());
        list.add(new LengthFragment2());
        list.add(new LengthFragment3());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);

        Toast toast = Toast.makeText(getApplicationContext(),
                "Swipe for more conversions!",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

    }

    public void lengthPrint(Double length) { // always send as metres to this method
        DecimalFormat df2 = new DecimalFormat("#.##");
        //need to put in if statement if it is less than 0.00 then go scientifi
        this.inputInMetres=length;
        Double mm = length * 1000;
        mmTextview.setText(df2.format(mm) + " mm");
        Double cm = length * 100;
        cmTextview.setText(df2.format(cm) + " cm");
        Double m = length;
        mTextview.setText(df2.format(m) + " m");
        Double in = length * 39.37;
        inTextview.setText(df2.format(in) + " in");
        Double ft = length * 3.28;
        ftTextview.setText(df2.format(ft) + " ft");
        Double yd = length * 1.094;
        ydTextview.setText(df2.format(yd) + " yd");
    }

    public Double getInputInMetres() {
        return inputInMetres;
    }

}
