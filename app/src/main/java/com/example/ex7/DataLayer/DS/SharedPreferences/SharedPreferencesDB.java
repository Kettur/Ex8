package com.example.ex7.DataLayer.DS.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesDB {
    private static SharedPreferencesDB instance;
    private String fileName;
    private Context context;
    private SharedPreferences db;
    private SharedPreferences.Editor editorDB;


    public static SharedPreferencesDB getInstance(Context context){
        if (instance == null){
            instance = new SharedPreferencesDB(context);
        }
        return instance;
    }
    private SharedPreferencesDB(Context context){
        fileName = "sharedPreferencesFile";
        this.context = context;
        db = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        editorDB = db.edit();
    }
    public void setValue(String key, String value){
        editorDB.putString(key, value);
        editorDB.apply();
    }

    public String getValue(String key){
        return db.getString(key, "Пусто");
    }
}
