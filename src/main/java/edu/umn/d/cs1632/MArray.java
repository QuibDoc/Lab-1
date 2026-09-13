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
                    // checks if the cell is a certain type
                    // then prints the cell contents
                    // and the type to the screen
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

        while (!(userInput.equals("Q"))) {
            System.out.print("Query? ");
            userInput = user.nextLine();

            String[] userCommand = userInput.split(" ");

            switch (userCommand[0]) {
                case "H" -> queryH(allData, userCommand);
                case "V" -> queryV(allData, userCommand);
                case "M" -> queryM(allData, userCommand);
                default -> System.out.println("Command Not Recognized");
            }
        }
    }

    //Shows the types of arrays in a horizontal line
    public void queryV(List<String[]> allData, String[] userCommands) {

        int intCount = 0;
        int stringCount = 0;
        int doubleCount = 0;

        if (checkUserCommand(userCommands)) {

            int colNum = Integer.parseInt(userCommands[1]);
            int rowMin = Integer.parseInt(userCommands[2]);
            int rowMax = Integer.parseInt(userCommands[3]);

            for (int i = 0; allData.size() - 1 > i; i++) {
                String[] colArr = allData.get(i);
                System.out.println(colArr[0]);

                if (rowMin <= i && i <= rowMax) {
                    if (StrNumCheck.checkStrNum(colArr[colNum]).equals("(I)")) {
                        intCount++;

                    } else if (StrNumCheck.checkStrNum(colArr[colNum]).equals("(D)")) {
                        doubleCount++;

                    } else if (StrNumCheck.checkStrNum(colArr[colNum]).equals("(S)")) {
                        stringCount++;

                    }
                }
            }

            typeTotalChecker(intCount, stringCount, doubleCount);


        } else {
            System.out.println("Command Not Recognised");
        }
    }

    //Shows the types of data in a Vertical Line
    public void queryH(List<String[]> allData, String[] userCommands) {

        int intCount = 0;
        int stringCount = 0;
        int doubleCount = 0;

        if (checkUserCommand(userCommands)) {

            int colNum = Integer.parseInt(userCommands[1]);
            int colMin = Integer.parseInt(userCommands[2]);
            int colMax = Integer.parseInt(userCommands[3]);

            String[] colArr = allData.get(colNum);
            System.out.println(colArr[0]);

            for (int i = 0; colArr.length - 1 > i; i++) {

                if (colMin < i && colMax >= i) {
                    if (StrNumCheck.checkStrNum(colArr[i]).equals("(I)")) {
                        intCount++;

                    } else if (StrNumCheck.checkStrNum(colArr[i]).equals("(D)")) {
                        doubleCount++;

                    } else if (StrNumCheck.checkStrNum(colArr[i]).equals("(S)")) {
                        stringCount++;

                    }
                }
            }

            typeTotalChecker(intCount, stringCount, doubleCount);


        } else {
            System.out.println("Command Not Recognised");
        }
    }


    //Shows the types of data in a Submatrix of the original
    public void queryM(List<String[]> allData, String[] userCommands) {

        int intCount = 0;
        int stringCount = 0;
        int doubleCount = 0;

        if (checkUserCommand(userCommands)) {

            int rowMin = Integer.parseInt(userCommands[1]);
            int rowMax = Integer.parseInt(userCommands[2]);
            int colMin = Integer.parseInt(userCommands[3]);
            int colMax = Integer.parseInt(userCommands[4]);

            // For loop that goes though the submarine
            // of the array specified by the user
            for (int i = colMin; colMax >= i; i++){
                String[] targetCollum = allData.get(i);
                for (int j = rowMin; rowMax >= j; j++){
                    String cell = targetCollum[j];

                    if (StrNumCheck.checkStrNum(cell).equals("(I)")) {
                        intCount++;

                    } else if (StrNumCheck.checkStrNum(cell).equals("(D)")) {
                        doubleCount++;

                    } else if (StrNumCheck.checkStrNum(cell).equals("(S)")) {
                        stringCount++;

                    }

                }
            }

            typeTotalChecker(intCount, stringCount, doubleCount);

        } else {
            System.out.println("Command Not Recognised");
        }
    }

    public boolean checkUserCommand(String[] userCommands) {
        //Checks if the command is long enough
        if (userCommands.length >= 4) {
            // Checks if the first index of the array is a string
            if (userCommands[0].equals("H") || userCommands[0].equals("V") ||
                    userCommands[0].equals("M")) {

                // Checks if the following numbers are
                // considered Integers
                for (int i = 1; i < userCommands.length - 1; i++) {

                    if (!StrNumCheck.checkStrNum(userCommands[i]).equals(("(I)"))
                            || userCommands[i] == null) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    return false;
    }

    private void typeTotalChecker(int intCount, int stringCount, int doubleCount) {
        // Checks type count for each of the cells
        // checked and prints the single or multi type
        // to the screen
        if (stringCount == 0 && doubleCount == 0) {
            System.out.println("Integer");

        } else if (stringCount == 0 && intCount == 0) {
            System.out.println("Double");

        } else if (intCount == 0 && doubleCount == 0) {
            System.out.println("String");

        } else {
            System.out.println("Multi");

        }
    }

}



