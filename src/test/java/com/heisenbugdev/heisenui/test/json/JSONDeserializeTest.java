package com.heisenbugdev.heisenui.test.json;

import com.heisenbugdev.heisenui.json.JSONHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by jacob on 5/15/14.
 */
public class JSONDeserializeTest
{

    @Test
    public void testJSONDeserialize()
    {
        String json = "{ 'identifier': 'Test', 'elements': [{'identifier': 'TestElement'}]}";

        Map data = JSONHandler.jsonLoader(json);

        String mainIdentifier = "";
        ArrayList<Map> array = null;
        Map element = null;
        String elementIdentifier = "";

        try
        {
            mainIdentifier = (String) data.get("identifier");
            array = (ArrayList<Map>)data.get("elements");
            element = (Map) array.get(0);
            elementIdentifier = (String)element.get("identifier");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            fail();
        }

        //assertEquals(0, 0);
        assertEquals("Test", mainIdentifier, "Test");
        assertEquals("TestElement", elementIdentifier, "TestElement");
    }
}
