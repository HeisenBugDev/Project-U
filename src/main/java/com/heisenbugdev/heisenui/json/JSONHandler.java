package com.heisenbugdev.heisenui.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Ash on 15/05/2014.
 */
public class JSONHandler {

    public static void main(String[] args) throws IOException {
        try(Reader reader = new InputStreamReader(JSONHandler.class.getResourceAsStream("/file.json"), "UTF-8")) {
            Gson gson = new GsonBuilder().create();
            GUIReader gui = gson.fromJson(reader, GUIReader.class);
        }
    }

}
