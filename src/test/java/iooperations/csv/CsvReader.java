package iooperations.csv;

import org.apache.poi.util.SystemOutLogger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
    public static void main(String[] args) {
        read("output.csv");
    }

    public static void read(String filePath){
        String line = "";
        String csvSplitBy = ",";
       // String csvSplitBy = "\t";      tab seperated

        String[] rowData;           // Array to store the Comma seperated split data individually

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while ((line = br.readLine()) !=null) {
                rowData = line.split(csvSplitBy);
                System.out.println("Name: " + rowData[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
