package com.example.myfirstapp.lengthFragments;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfirstapp.ConvertLength;
import com.example.myfirstapp.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LengthFragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater
                .inflate(R.layout.pager_3,container
                        , false);

        TextView textView = rootView.findViewById(R.id.textView3);

        NumberFormat normalF = new DecimalFormat("#0.00");
        NumberFormat otherF = new DecimalFormat("0.#E0");

        ConvertLength cv = (ConvertLength)getActivity();

        Double inputMetres =cv.getInputInMetres();
        Double furlong = inputMetres/201.2;
        String inputMetresString;
        String furlongString;

        if (inputMetres>0.01 && inputMetres < 1000000){
            inputMetresString=normalF.format(inputMetres);
        } else {
            inputMetresString=otherF.format(inputMetres);
        }

        if (furlong>0.01 && furlong < 1000000){
            furlongString=normalF.format(furlong);
        } else {
            furlongString=otherF.format(furlong);
        }

        String output = inputMetresString +" metres will take your oxen team about " +furlongString+" <b> Furlongs!</b> ";

        textView.setText(Html.fromHtml(output));
        return rootView;
    }
}
