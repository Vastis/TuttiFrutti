package utils;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class JsonParser<T extends Wrapper> {

    private final Class<T> genericClass;

    public JsonParser(Class<T> genericClass){
        this.genericClass = genericClass;
    }

    public T fromFile(String filename) throws NullPointerException {
        String content = null;
        try {
            URL resource = JsonParser.class.getResource(filename);
            content = Files.readString(new File(resource.getFile()).toPath());
        } catch (IOException e) {
            System.out.println("Something's wrong with JSON file (wrong filepath, or the file doesn't exist).");
        }
        return toJsonObject(content);
    }

    public T toJsonObject(String jsonString){
        T wrapper = new Gson().fromJson(jsonString, this.genericClass);
        wrapper.initialize();
        return wrapper;
    }

    public void toFile(T jsonObject, String filename){
        try {
            URL resource = JsonParser.class.getResource(filename);
            String filepath = Files.readString(new File(resource.getFile()).toPath());
            String json = toJson(jsonObject);
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toJson(T jsonObject) {
        String json = new Gson().toJson(jsonObject);
        return json;
    }
}
