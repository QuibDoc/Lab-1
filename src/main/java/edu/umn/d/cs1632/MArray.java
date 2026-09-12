package edu.umn.d.cs1632;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

class MArray {
    // ArrayList<Feature> featureList;
    // ArrayList<ArrayList<DataItem>> data;
    private MArray() {
    }

    public MArray(String fileName) {
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                for (String cell : row) {
                    if (StrNumCheck.checkStrNum(cell).equals("(I)")) {
                        System.out.print(cell + "(I) \t");
                    } else if (StrNumCheck.checkStrNum(cell).equals("(D)")) {
                        System.out.print(cell + "(D) \t");
                    } else {
                        System.out.print(cell + "(S) \t");
                    }
                }
                System.out.println();
            }
            //Query Function to allow the user
            //to search row data types
            query(allData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void query(List<String[]> allData) {
        Scanner user = new Scanner(System.in);
        String userInput = " ";
        int numInt;
        int numDouble;
        int numString;

        while (!(userInput.equals("Q"))) {
            System.out.print("Query? ");
            userInput = user.nextLine();

            String[] userCommand = userInput.split(" ");

            switch (userCommand[0]) {
                case "H" -> queryH(allData, userCommand);
                case "V" -> queryV(allData, userCommand);
                case "M" -> queryM(allData, userCommand);
                default -> System.out.print("Command Not Recognized");
            }
        }
    }

    //Shows the types of arrays in a horizontal line
    public void queryH(List<String[]> allData, String[] userCommands) {
        String[] Target = allData.get(Integer.parseInt(userCommands[1]));

        if (StrNumCheck.checkStrNum(userCommands[1]).equals("(I)")) {
            int targetHorizontal = Integer.parseInt(userCommands[1]);

            for (int i = Integer.parseInt(userCommands[1]); i < allData.size() - 1; i++) {
                allData.get(0);
            }
        }else {
            System.out.print("Command Not Recognised");
        }
    }
    //Shows the types of data in a Vertical Line
    public void queryV (List < String[]>allData, String[]userCommands){

    }

    //Shows the types of data in a Submatrix of the original
    public void queryM (List < String[]>allData, String[]userCommands){

    }

    public boolean checkUserCommand (String[] userCommands) {

        // Checks if the first index of the array is a string
        if (userCommands[0].equals("H") ||
                userCommands[0].equals("V") ||
                userCommands[0].equals("M")) {

            // Checks if the following numbers are
            // considered Integers
            for (int i = 1; i < userCommands.length - 1; i++) {
                if (StrNumCheck.checkStrNum(userCommands[i]).equals(("(I)"))
                        || userCommands[i] == null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}



