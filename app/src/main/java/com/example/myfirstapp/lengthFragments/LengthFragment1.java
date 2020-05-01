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

public class LengthFragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.pager_1, container
                        , false);
        TextView textView = rootView.findViewById(R.id.textView13);

        NumberFormat normalF = new DecimalFormat("#0.00");
        NumberFormat otherF = new DecimalFormat("0.#E0");

        ConvertLength cv = (ConvertLength)getActivity();

        Double inputMetres =cv.getInputInMetres();
        Double altuves = inputMetres/1.651;
        String inputMetresString;
        String altuvesString;

        if (inputMetres>0.01 && inputMetres < 1000000){
            inputMetresString=normalF.format(inputMetres);
        } else {
            inputMetresString=otherF.format(inputMetres);
        }

        if (altuves>0.01 && altuves < 1000000){
            altuvesString=normalF.format(altuves);
        } else {
            altuvesString=otherF.format(altuves);
        }

        String output = inputMetresString +" metres gets you about " +altuvesString+" <b>Altuves!</b>";

        textView.setText(Html.fromHtml(output));

        return rootView;
    }
}
