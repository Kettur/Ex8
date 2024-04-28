package com.example.ex7.DataLayer.DS.Files;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class AppSpecificStorage {
    private static AppSpecificStorage instance;
    private File file;
    private String fileName;
    private Context context;

    public static AppSpecificStorage getInstance(Context context){
        if (instance == null){
            instance = new AppSpecificStorage(context);
        }
        return instance;
    }
    private AppSpecificStorage(Context context){
        fileName = "appSpecificFile";
        this.context = context;
        file = new File(context.getFilesDir(), fileName);
    }
    public void writeData(String data) {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();
        } catch (IOException e){
            //
        }

    }
    public String readData() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fis = context.openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                Log.i("info", line);
                stringBuilder.append(line + "\n");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            //
        }
        return stringBuilder.toString();
    }
}
