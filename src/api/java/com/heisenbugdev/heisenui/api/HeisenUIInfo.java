package com.heisenbugdev.heisenui.api;

/**
 * Abstract Api implementation. This class stors the instance of the Api.
 */
public abstract class HeisenUIInfo implements IHeisenUIApi
{
    protected static IHeisenUIApi _api;

    /**
     * Gets the HeisenUI mod Api. If null, it's not initialized or not present.
     *
     * @return mod api
     */
    public static IHeisenUIApi api()
    {
        return _api;
    }
}
