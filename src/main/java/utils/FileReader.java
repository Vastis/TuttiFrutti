package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private File file;
    private Scanner scanner;

    public FileReader(String fileName){
        this.file = new File(getClass().getClassLoader().getResource(fileName).getFile());
    }

    public File getFile() {
        return file;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
