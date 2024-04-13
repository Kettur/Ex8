package com.example.ex7.DomainLayer.Protocol;

import androidx.lifecycle.MutableLiveData;

import com.example.ex7.DataLayer.Models.Character;
import com.example.ex7.DataLayer.Models.Job;

import java.util.ArrayList;

public interface Repository {
    MutableLiveData<String> getCharacterName();
    MutableLiveData<String> getJobName();
    MutableLiveData<String> getBufferCharacterName();
    ArrayList<Character> getCharactersDB();
    ArrayList<Job> getJobsDB();
    void setCharacterName(String name);
    void setJobName(String name);
    void setBufferCharacterName(String name);
}
