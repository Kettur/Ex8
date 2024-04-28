package com.example.ex7.DomainLayer.Protocol;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ex7.DataLayer.DS.Room.Entities.Character;
import com.example.ex7.DataLayer.DS.Room.Entities.Job;

import java.util.ArrayList;
import java.util.List;

public interface Repository {
    MutableLiveData<String> getCharacterName();
    MutableLiveData<String> getJobName();
    MutableLiveData<String> getBufferCharacterName();
    LiveData<List<Character>> getCharactersDB();
    LiveData<List<Job>> getJobsDB();
    void setCharacterName(String name);
    void setJobName(String name);
    void setBufferCharacterName(String name);
}
