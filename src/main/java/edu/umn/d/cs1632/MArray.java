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
                    if(StrNumCheck.checkStrNum(cell).equals("(I)")){
                        System.out.print(cell + "(I) \t");
                    } else if(StrNumCheck.checkStrNum(cell).equals("(D)")){
                        System.out.print(cell + "(D) \t");
                    } else {
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
