package it.betacom.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVFileWriter {

    public static void write(String filePath, String content) {
        File file = new File(filePath);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(content);
            System.out.println("  ! File CSV creato correttamente: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
