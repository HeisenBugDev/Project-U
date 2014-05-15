package com.heisenbugdev.heisenui.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.heisenbugdev.heisenui.logger.HeisenLogger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Ash on 15/05/2014.
 */
public class JSONHandler {

    public static void jsonLoader(String fileLocation) throws IOException {
        try {
            Reader reader = new InputStreamReader(JSONHandler.class.getResourceAsStream(fileLocation), "UTF-8");
            Gson gson = new GsonBuilder().create();
            GUIReader gui = gson.fromJson(reader, GUIReader.class);
        } catch(Exception e) {
            HeisenLogger.fatal(e);
        }
    }

}
