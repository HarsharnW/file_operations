package iooperations.text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextWriter {

    public static void main(String[] args) {
        write("Java 8 is cool!", "./sample2.txt");
    }

    public static void write(String text, String filePath) {
        BufferedWriter writer = null;            // Java utils used to write data to file (visa versa of Scanner)
        Path pathToFile = Paths.get(filePath);
        try {
            Files.createDirectories(pathToFile.getParent());
            File file = new File(filePath);
            file.createNewFile();                                                //create the file
            writer = new BufferedWriter(new FileWriter(filePath));               //writer will write to file
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
