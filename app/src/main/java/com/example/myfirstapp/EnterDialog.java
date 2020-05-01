package com.example.myfirstapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class EnterDialog extends AppCompatDialogFragment {

    private View mView; // only need mView if I call all buttons the same thing. then just change the M view..
    private EditText editText;
    private Spinner mSpinner;
    private Intent newIntent;

    public EnterDialog(View mView,Intent newIntent) {
        this.mView = mView;
        this.newIntent=newIntent;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        mBuilder.setTitle("Enter Value to Convert");
        editText = (EditText) mView.findViewById(R.id.editText); //gets info from edit text
        mSpinner = (Spinner) mView.findViewById(R.id.spinner); //gets info from spinner in set area popup
        mBuilder.setView(mView);

        Button mok = (Button) mView.findViewById(R.id.button);//gets button from custom interface for pop up

        mok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = editText.getText().toString();
                String units = mSpinner.getSelectedItem().toString();

                if(checkEntryValue(value)){
                    newIntent.putExtra("value", value);
                    newIntent.putExtra("unit", units);
                    startActivity(newIntent);
                } else {
                    String errorString = "Please enter a valid positive number e.g. 7.54";
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),errorString,Toast.LENGTH_LONG);
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    if( v != null) v.setGravity(Gravity.CENTER);
                    toast.show();
                }
            }
        });
        return mBuilder.create();
    }

    public boolean checkEntryValue(String entryValue){
        try{ //check if entry can be parsed to a double. if not return false
            Double entryDouble = Double.valueOf(entryValue);
            if (entryDouble<0){ //check if it is a positive value
                return false;
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }


}
