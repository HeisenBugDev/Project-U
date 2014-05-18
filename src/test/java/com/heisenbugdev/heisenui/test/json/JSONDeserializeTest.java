package com.heisenbugdev.heisenui.test.json;

import com.heisenbugdev.heisenui.api.json.HeisenViewModel;
import com.heisenbugdev.heisenui.json.JSONHandler;
import com.heisenbugdev.heisenui.proxy.UIProxy;
import com.heisenbugdev.heisenui.core.api.view.HeisenView;
import com.heisenbugdev.heisenui.core.api.view.HeisenViewController;
import com.heisenbugdev.heisenui.api.annotation.UIOutlet;
import com.heisenbugdev.heisenui.api.annotation.UITarget;
import org.junit.Assert;
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
    public void testOutletsAndTargets()
    {
        new UIProxy().registerDefaultViewElements();

        String json = "{ 'identifier': 'Test', 'view': {'identifier': 'TestElement', 'subviews': [{'identifier': 'TestElement2'}]}}";
        HeisenViewModel data = JSONHandler.jsonLoader(json);

        TestViewController controller = new TestViewController(data, null);
        controller.view().invokeTarget("test");

        Assert.assertEquals("Hello World!", controller.targetTest1);
        Assert.assertNotNull(controller.outletTest1);
    }

    public static class TestViewController extends HeisenViewController
    {
        public String targetTest1 = "";

        @UIOutlet("TestElement2")
        public HeisenView outletTest1;

        public TestViewController(HeisenViewModel model, HeisenViewController parent)
        {
            super(model, parent);
        }

        @UITarget("test")
        public void testTarget()
        {
            this.targetTest1 = "Hello World!";
        }

    }

}
