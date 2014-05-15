package com.heisenbugdev.heisenui.json;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.heisenbugdev.heisenui.HeisenUI;
import com.heisenbugdev.heisenui.logger.HeisenLogger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JSONHandler {

    public static Map jsonLoader(String fileLocation) throws IOException {

        Gson gson = new Gson();

        Map data = null;

        try {
            if(HeisenUI.DEBUG) HeisenLogger.debug("Reading JSON file" + fileLocation);

            BufferedReader br = new BufferedReader(new FileReader(fileLocation));

            data = gson.fromJson(br, Map.class);

        } catch (FileNotFoundException e) {
            HeisenLogger.warn(e + fileLocation);
        } catch (JsonSyntaxException e) {
            HeisenLogger.warn(e);
        } catch (JsonIOException e) {
            HeisenLogger.warn(e);
        }

        return data;

    }

}
