package org.rubberduckies;

import java.util.ArrayList;
import org.json.simple.JSONObject;

public abstract class Controller {

    protected abstract JSONObject readJSON(String filename);
    protected abstract boolean writeJSON(String filename, JSONObject json);
    protected abstract void parse(ArrayList<JSONObject> jsonObjects);

}
