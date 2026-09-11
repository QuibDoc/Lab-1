package edu.umn.d.cs1632;

public class StrNumCheck {

    public static String checkStrNum(String numString){

        try {
            Integer.valueOf(numString);
            return "(I)";
        } catch (NumberFormatException e) {
            //dont stop the program if it doesnt work
        }

        try {
            Double.valueOf(numString);
            return "(D)";
        } catch (NumberFormatException e) {
            //dont stop the program if it doesnt work
        }

        return "(S)";

    }

}