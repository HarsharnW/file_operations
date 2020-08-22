package iooperations.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader
{
    public static void main(String[] args) {
        read("./sample.txt");               //   ./ is the root directory
    }

    public static void read(String filePath){
        String content = null;
        try {
            //Scanner will read the content of the file & break the lines
            content = new Scanner(new File(filePath)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            System.out.println("Reading text file failed!");
            e.printStackTrace();
        }
        System.out.println(content);   //print text file contect if file is available
    }
}
