package org.rubberduckies;

import org.json.simple.JSONObject;

public abstract class Controller {

    protected abstract JSONObject readJSON(String filename);
    protected abstract boolean writeJSON(String filename, JSONObject json);

}
