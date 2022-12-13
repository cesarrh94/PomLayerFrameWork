package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class JsonFileReader {

    private String filePath = "C:\\Optionals\\configs.json";
    public String getAttribute(String key) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
