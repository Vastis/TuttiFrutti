package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private File file;
    private Scanner scanner;

    public FileReader(String fileName){
        this.file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        try {
            this.scanner = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file: " + this.file);
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

}
