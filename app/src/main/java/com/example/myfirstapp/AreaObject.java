package com.example.myfirstapp;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AreaObject {
/* Improvements
If I was to add a lot of new area types. Would store the Area>ConversionFactor in a String,Double Map.

 */

    private Double valueM2; //will always be stored as a m2 for easy conversion to other area values

    public AreaObject(String unit, String value) {
        this.valueM2 = convertToM2(unit, value);
    }

    public String getAreaValue(String newUnit) {

        switch (newUnit) {
            case "oxgang": {
                Double returnValue = this.valueM2 * 0.0000166;
                return stringCreator(returnValue);
            }
            case "football": {
                Double returnValue = this.valueM2 * 0.0001401;
                return stringCreator(returnValue);
            }
            case "barn": {
                Double returnValue = this.valueM2 *10000000000000000000000000000.0;
                return returnValue.toString();
            }
        }
        return "getAreaError";
    }

    //this returns the string in proper number format for size of number (scientific or normal)
    private String stringCreator(Double value) {
        NumberFormat normalF = new DecimalFormat("#0.000");
        NumberFormat otherF = new DecimalFormat("0.###E0");

        if (value>0.01 && value < 1000000){
            return normalF.format(value);
        } else {
            return otherF.format(value);
        }
    }

    //This converts the entry input to m2 and stores it. - for simplicity
    private Double convertToM2(String unit, String value) {
        Double valueDouble = Double.valueOf(value);
        switch (unit) {
            case "cm2": {
                return valueDouble / 1000;
            }
            case "m2": {
                return valueDouble;
            }
            case "hectare": {
                return valueDouble * 10000;
            }
            case "in2": {
                return valueDouble / 1550;
            }
            case "ft2": {
                return valueDouble / 10.7639;
            }
            case "acre": {
                return valueDouble * 4046.86;
            }
        }
        return 0.0;
    }

}
