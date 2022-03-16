package org.rubberduckies;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Used to create controllers that act as the API
 * between the Flytr front end and the JSON files.
 *
 * @author Alex Lay-Calvert
 */
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

            // FIXME
            // Bug: Possibility of file never closing
            //
            // Description: In the event of an error while
            //              writing to the file, the catch
            //              block catches the exception and
            //              never closes the file.
            file.write(json.toJSONString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected abstract void parse(JSONObject jsonObject);
}
