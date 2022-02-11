package com.rubberduckies.flytr;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * A database table-like class that reads data
 * from a JSON file and stores that information 
 * into an ArrayList of objects.
 *
 * Utilizes the json-simple library.
 * Source: https://github.com/fangyidong/json-simple
 *
 * @author Alexander Lay-Calvert
 */
public abstract class Table {

    protected ArrayList<Object> data;
    protected JSONObject json;

    public Table() {}

    public Table(ArrayList<Object> data) {
        this.data = data;
    }

    public void add(Object object) {
        data.add(object);
    }

    public void remove(Object object) {
        data.remove(object);
    }

    /**
     * Reads a JSON file filename and loads that
     * data into the JSONObject json.
     *
     * @param filename The JSON file to read from.
     */
    protected void readJson(String filename) {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(filename));
            json = (JSONObject) object;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Writes the JSONObject json to the file
     * given as a parameter.
     *
     * @param filename The file to write to.
     */
    protected void writeJson(String filename) {
        FileWriter file;
        try {
            file = new FileWriter(filename);
            file.write(json.toJSONString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public abstract void update(Object object);
    public abstract void parse();
}
