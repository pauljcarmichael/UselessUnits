package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myfirstapp.areaFragments.areaFragment1;
import com.example.myfirstapp.areaFragments.areaFragment2;
import com.example.myfirstapp.areaFragments.areaFragment3;

import java.util.ArrayList;
import java.util.List;

public class ConvertArea extends AppCompatActivity {

    private String inputValue;
    private String inputUnits;
    private AreaObject areaObject;

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_area);

        TextView titleBox = findViewById(R.id.textView);

        Intent intent = getIntent();

        inputValue = intent.getExtras().getString("value");
        inputUnits = intent.getExtras().getString("unit");

        areaObject = new AreaObject(inputUnits, inputValue); //creates object for fragments to use

        String titleString = createTitleString(inputUnits, inputValue);
        titleBox.setText(titleString);


        Toast toast = Toast.makeText(getApplicationContext(),
                "Swipe for more conversions!",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();


        List<Fragment> list = new ArrayList<>();
        list.add(new areaFragment1());
        list.add(new areaFragment2());
        list.add(new areaFragment3());


        pager = findViewById(R.id.area_pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);
    }


    public String createTitleString(String unit, String value) {

        if (unit.equals("hectare") || unit.equals("acre")) {
            if (value.equals("1")) {
                return inputValue + " " + inputUnits + " equals:";
            } else {
                return inputValue + " " + inputUnits + "s are equal to:";
            }
        }
        return inputValue + " " + inputUnits + " is equal to:";
    }

    public AreaObject getAreaObject() {
        return areaObject;
    }

    public String getInputValue() {
        return inputValue;
    }

    public String getInputUnits() {
        return inputUnits;
    }

}
