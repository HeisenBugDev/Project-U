package com.heisenbugdev.heisenui.test.json;

import com.heisenbugdev.heisenui.json.HeisenViewModel;
import com.heisenbugdev.heisenui.json.JSONHandler;
import com.heisenbugdev.heisenui.proxy.UIProxy;
import com.heisenbugdev.heisenui.view.HeisenViewController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JSONDeserializeTest
{

    @Test
    public void testJSONDeserialize()
    {
        String json = "{ 'identifier': 'Test', 'view': {'identifier': 'TestElement', 'subviews': [{'identifier': 'TestElement'}]}}";

        HeisenViewModel data = JSONHandler.jsonLoader(json);

        //assertEquals(0, 0);
        assertEquals("Test", data.getIdentifier(), "Test");
        assertEquals("TestElement", data.getView().getIdentifier(), "TestElement");
    }

    @Test
    public void testOutlets()
    {
        new UIProxy().registerDefaultViewElements();

        String json = "{ 'identifier': 'Test', 'view': {'identifier': 'TestElement', 'subviews': [{'identifier': 'TestElement2'}]}}";
        HeisenViewModel data = JSONHandler.jsonLoader(json);

        HeisenViewController controller = new HeisenViewController(data, null);
        //Assert.fail();
    }
}
