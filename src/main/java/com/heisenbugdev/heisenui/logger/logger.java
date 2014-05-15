package com.heisenbugdev.heisenui.logger;

import cpw.mods.fml.common.FMLLog;

import java.util.logging.Level;

/**
 * Created by Ash on 15/05/2014.
 */
public class logger {

    public static void log(Level logLevel, Object object) {
        FMLLog.log("HeisenUI", logLevel, "[HeisenUI] " + String.valueOf(object));
    }

    public static void off(Object object) {
        log(Level.OFF, object);
    }

    public static void info(Object object) {
        log(Level.INFO, object);
    }

    public static void config(Object object) {
        log(Level.CONFIG, object);
    }

    public static void warning(Object object) {
        log(Level.WARNING, object);
    }

    public static void severe(Object object) {
        log(Level.SEVERE, object);
    }

    public static void fine(Object object) {
        log(Level.FINE, object);
    }

    public static void finer(Object object) {
        log(Level.FINER, object);
    }

    public static void finest(Object object) {
        log(Level.FINEST, object);
    }

    public static void all(Object object) {
        log(Level.ALL, object);
    }
}
