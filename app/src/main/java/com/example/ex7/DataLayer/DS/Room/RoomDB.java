package com.example.ex7.DataLayer.DS.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ex7.DataLayer.DS.Room.DAO.interfaceDAO;
import com.example.ex7.DataLayer.DS.Room.Entities.Character;
import com.example.ex7.DataLayer.DS.Room.Entities.Job;

@Database(entities = {Character.class, Job.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    public abstract interfaceDAO funcDAO();

    private static RoomDB instance;
    public static RoomDB getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class, "roomDB").allowMainThreadQueries().build();
        }
        init();
        return instance;
    }

    private static void init(){
        interfaceDAO myDAO = instance.funcDAO();
        myDAO.deleteCharacters();
        myDAO.deleteJobs();
        myDAO.insert(new Character("John"));
        myDAO.insert(new Character("Karl"));
        myDAO.insert(new Character("Arham"));
        myDAO.insert(new Character("N"));
        myDAO.insert(new Character("J"));
        myDAO.insert(new Character("V"));
        myDAO.insert(new Character("CYN"));
        myDAO.insert(new Character("UZI"));

        myDAO.insert(new Job("Mine stone"));
        myDAO.insert(new Job("Mine coal"));
        myDAO.insert(new Job("Mine iron"));
        myDAO.insert(new Job("Mine gold"));
        myDAO.insert(new Job("Mine diamonds"));
        myDAO.insert(new Job("Chop wood"));
    }
}

