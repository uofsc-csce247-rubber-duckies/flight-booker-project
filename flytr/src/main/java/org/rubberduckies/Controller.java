package org.rubberduckies;

import java.util.ArrayList;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.*;

/**
 * Used to create controllers that act as the API
 * between the Flytr front end and the JSON files.
 *
 * @author Alex Lay-Calvert
 */
public abstract class Controller {

    // TODO 
    // Possibly implement a singleton in the base class.
    // Putting in each child for now and will refactor later.

    /**
     * Returns the basic JSONObject that was read
     * from the given file.
     *
     * @param filename The file to read from.
     *
     * @return The JSONObject parsed from the file.
     */
    protected JSONObject readJson(String filename) {
        System.out.println("READING: " + filename);
        try {
            JSONParser parser = new JSONParser();
            Object jsonObject = parser.parse(new FileReader(filename));
            return (JSONObject) jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Takes the given JSONObject and writes it as a
     * JSON string to the given file.
     *
     * @param filename The file to write to.
     * @param json The JSONObject to write.
     */
    protected void writeJson(String filename, JSONObject json) {
        try {
            FileWriter file = new FileWriter(filename);

            // FIXME
            // Bug: Possibility of file never closing
            //
            // Description: In the event of an error while
            //              writing to the file, the catch
            //              block catches the exception and
            //              never closes the file.
            // json.writeJSONString(file);

            // Reference https://stackoverflow.com/questions/4105795/pretty-print-json-in-java
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement je = JsonParser.parseString(json.toJSONString());
            gson.toJson(je, file);
            // file.write(prettyString);
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns all filenames in the given directory,
     * usefule for finding all user directories in the
     * database or anything similar.
     *
     * @param directory The directory name to list.
     *
     * @return The list of files/directories in the given one.
     */
    protected String[] getFilesFromDirectory(String directory) {
        File file = new File(directory);
        return file.list();
    }

}
