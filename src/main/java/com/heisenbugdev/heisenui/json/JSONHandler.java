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

public class JSONHandler {

    public static void jsonLoader(String fileLocation) throws IOException {

        Gson gson = new Gson();

        try {
            if(HeisenUI.DEBUG) HeisenLogger.debug("Reading JSON file" + fileLocation);

            BufferedReader br = new BufferedReader(new FileReader(fileLocation));

            JSONGUI jsonGui = gson.fromJson(br, JSONGUI.class);
        } catch (FileNotFoundException e) {
            HeisenLogger.warn(e + fileLocation);
        } catch (JsonSyntaxException e) {
            HeisenLogger.warn(e);
        } catch (JsonIOException e) {
            HeisenLogger.warn(e);
        }


        /*Reader reader = new InputStreamReader(JSONHandler.class.getResourceAsStream(fileLocation), "UTF-8");
        Gson gson = new GsonBuilder().create();
        JSONGUI gui = gson.fromJson(reader, JSONGUI.class);*/

    }

}
