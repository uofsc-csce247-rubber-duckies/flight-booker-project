package com.rubberduckies.flytr;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public abstract class Controller {

    protected JSONObject readJson(String filename) {
        try {
            JSONParser parser = new JSONParser();
            Object jsonObject = parser.parse(new FileReader(filename));
            return (JSONObject) jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected void writeJson(String filename, JSONObject json) {
        try {
            FileWriter file = new FileWriter(filename);
            file.write(json.toJSONString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void parse(ArrayList<JSONObject> jsonObjects);

}
