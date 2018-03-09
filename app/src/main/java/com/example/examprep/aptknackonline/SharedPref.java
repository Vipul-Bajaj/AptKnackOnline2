package com.example.examprep.aptknackonline;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SharedPref {
    public static void saveIt(Context ctx, String name, int data) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        Editor ed = sp.edit();
        ed.putInt(name, data);
        ed.commit();
    }

    public static int getIt(Context ctx, String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        return sp.getInt(key, 0);
    }

}
