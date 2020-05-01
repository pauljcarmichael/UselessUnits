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

public class areaFragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.area_page_1, container
                        , false);
        TextView textView = rootView.findViewById(R.id.textView);

        ConvertArea cv = (ConvertArea) getActivity(); //this gets the current activity
        AreaObject areaObject = cv.getAreaObject(); //gets the object made in ConvertArea class
        String outputValue = areaObject.getAreaValue("oxgang"); //uses the getareavalue method of the object class
        String output = outputValue + " <b>Oxgangs!</b>";
        textView.setText(Html.fromHtml(output));
        return rootView;
    }

}
