package com.example.ex7.DataLayer.DS.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.ex7.DataLayer.DS.Room.Entities.Character;
import com.example.ex7.DataLayer.DS.Room.Entities.Job;

import java.util.List;

@Dao
public interface interfaceDAO {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert(Character character);
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert(Job job);

    @Query("SELECT * FROM characterTable")
    LiveData<List<Character>> getCharacterFromRoom();
    @Query("SELECT * FROM jobTable")
    LiveData<List<Job>> getJobFromRoom();

    @Query("DELETE FROM characterTable")
    void deleteCharacters();
    @Query("DELETE FROM jobTable")
    void deleteJobs();
}
