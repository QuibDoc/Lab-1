package edu.umn.d.cs1632;

// This class is responsible for displaying the datatype
// of the given input string
public class cvsTypeReader {

    public String readType(String s){
        return switch (s) {
            case "o" -> "(I)";
            case "p" -> "(S)";
            case "l" -> "(D)";
            default -> "(NA)";
        };

    }
}
