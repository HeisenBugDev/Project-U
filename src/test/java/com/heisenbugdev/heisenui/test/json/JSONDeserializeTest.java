package com.heisenbugdev.heisenui.test.json;

import com.heisenbugdev.heisenui.json.HeisenViewModel;
import com.heisenbugdev.heisenui.json.JSONHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jacob on 5/15/14.
 */
public class JSONDeserializeTest
{

    @Test
    public void testJSONDeserialize()
    {
        String json = "{ 'identifier': 'Test', 'subviews': [{'identifier': 'TestElement'}]}";

        HeisenViewModel data = JSONHandler.jsonLoader(json);

        //assertEquals(0, 0);
        assertEquals("Test", data.getIdentifier(), "Test");
        assertEquals("TestElement", data.getElements().get(0).getIdentifier(), "TestElement");
    }
}
