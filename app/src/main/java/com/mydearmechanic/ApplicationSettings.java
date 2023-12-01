package com.bosco.cristo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Zentere Inc.
 */

public class ApplicationSettings {

    private static SharedPreferences mSharedPref;
    private static SharedPreferences.Editor prefsEditor;

    public ApplicationSettings() {

    }

    public static void init(Context context) {
        if (mSharedPref == null)
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }

    public static String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }

    public static void write(String key, String value) {
        prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
        prefsEditor.commit();
    }


    public static void write(String key, int value) {
        prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.apply();
        prefsEditor.commit();
    }

    public static void write(String key, float value) {
        prefsEditor = mSharedPref.edit();
        prefsEditor.putFloat(key, value);
        prefsEditor.apply();
        prefsEditor.commit();
    }

    public static boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }

    public static void write(String key, boolean value) {
        prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
        prefsEditor.commit();
    }

    public static int read(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    public static float read(String key, float defValue) {
        return mSharedPref.getFloat(key, defValue);
    }

    public static void clear() {
        prefsEditor = mSharedPref.edit();
        prefsEditor.clear();
        prefsEditor.apply();
        prefsEditor.commit();
    }

}
