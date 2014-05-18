package com.heisenbugdev.heisenui.json;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.heisenbugdev.heisenui.HeisenUI;
import com.heisenbugdev.heisenui.api.json.HeisenViewModel;
import com.heisenbugdev.heisenui.logger.HeisenLogger;
import net.minecraft.util.StringUtils;

import java.io.*;

public class JSONHandler
{

    public static HeisenViewModel jsonLoaderFromFileLocation(String fileLocation) throws IOException
    {
        if (HeisenUI.DEBUG) HeisenLogger.debug("Reading JSON file" + fileLocation);
        return jsonLoader(new FileInputStream(fileLocation));
    }

    public static HeisenViewModel jsonLoader(InputStream jsonStream) throws IOException
    {
        String json = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(jsonStream));
        json = "";
        while (br.ready())
        {
            json += br.readLine();
        }

        if (StringUtils.isNullOrEmpty(json)) return null;

        return jsonLoader(json);
    }

    public static HeisenViewModel jsonLoader(String json)
    {

        Gson gson = new Gson();

        HeisenViewModel data = null;

        try
        {
            data = gson.fromJson(json, HeisenViewModel.class);
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
