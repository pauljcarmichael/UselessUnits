package com.example.myfirstapp.areaFragments;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfirstapp.AreaObject;
import com.example.myfirstapp.ConvertArea;
import com.example.myfirstapp.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class areaFragment3 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.area_page_3, container
                        , false);
        TextView textView = rootView.findViewById(R.id.textView);

        NumberFormat normalF = new DecimalFormat("#0.00");
        NumberFormat otherF = new DecimalFormat("0.#E0");

        ConvertArea cv = (ConvertArea) getActivity();
        AreaObject areaObject = cv.getAreaObject(); //gets the object made in ConvertArea class

        String outputValue = areaObject.getAreaValue("barn"); //uses the getareavalue method of the object class
        String output = outputValue + " <b>Barns!</b>";
        textView.setText(Html.fromHtml(output));
        return rootView;
    }


}
