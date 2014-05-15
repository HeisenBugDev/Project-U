package com.heisenbugdev.heisenui.json;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.heisenbugdev.heisenui.HeisenUI;
import com.heisenbugdev.heisenui.logger.HeisenLogger;
import net.minecraft.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JSONHandler {

    public static Map jsonLoaderFromFileLocation(String fileLocation) throws IOException
    {
        if(HeisenUI.DEBUG) HeisenLogger.debug("Reading JSON file" + fileLocation);
        String json = "";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));
            json = "";
            while (br.ready())
            {
                json += br.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            HeisenLogger.warn(e + fileLocation);
        }

        if (StringUtils.isNullOrEmpty(json)) return null;

        return jsonLoader(json);
    }

    public static Map jsonLoader(String json) {

        Gson gson = new Gson();

        Map data = null;

        try
        {
            data = gson.fromJson(json, Map.class);
        }
        catch (JsonSyntaxException e)
        {
            HeisenLogger.warn(e);
        }
        catch (JsonIOException e)
        {
            HeisenLogger.warn(e);
        }

        return data;
    }

}
