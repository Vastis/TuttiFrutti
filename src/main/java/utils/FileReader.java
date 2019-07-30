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

    private void readConnectionConfig(){
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Scanner getScanner() {
        return scanner;
    }
}
