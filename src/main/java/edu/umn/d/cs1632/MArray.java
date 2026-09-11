package edu.umn.d.cs1632;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

class MArray {
    // ArrayList<Feature> featureList;
    // ArrayList<ArrayList<DataItem>> data;
    private MArray() {}
    public MArray(String fileName) {
        try {
            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(filereader);
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                for (String cell : row) {
                    int stringCheck = 0;
                    try {
                        Integer.valueOf(cell);
                        System.out.print(cell + "(I) \t");
                        stringCheck += 1;
                    } catch (NumberFormatException e) {
                    //dont stop the program if it doesnt work
                    }

                    try {
                        Double.valueOf(cell);
                        System.out.print(cell + "(D) \t");
                        stringCheck += 1;
                    } catch (NumberFormatException e) {
                        //dont stop the program if it doesnt work
                    }
                    if (!(stringCheck > 0)){
                        System.out.print(cell + "(S) \t");
                    }

                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
