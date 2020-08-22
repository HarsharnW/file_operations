package iooperations.csv;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter
{
    public static void main(String[] args) {
        String[] employeeDetails = {"1","Name10","Address1"};
        write(employeeDetails,"MyWrittenCSVFile.csv");
    }

    public static void write(String[] data, String filePath) {
        File file = new File(filePath);
        try {
            FileWriter output = new FileWriter(file);
            CSVWriter writer = new CSVWriter(output);

            String[] header = {"ID","Name","Address"};
            writer.writeNext(header);

            writer.writeNext(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
