package com.example.ex7.DataLayer.Rep;

import androidx.lifecycle.MutableLiveData;

import com.example.ex7.DataLayer.DS.CharacterDS;
import com.example.ex7.DataLayer.DS.JobDS;
import com.example.ex7.DataLayer.DS.TransmittedData;
import com.example.ex7.DataLayer.Models.Character;
import com.example.ex7.DataLayer.Models.Job;
import com.example.ex7.DomainLayer.Protocol.Repository;

import java.util.ArrayList;

public class RepositoryImp implements Repository {
    private static RepositoryImp instance;
    private MutableLiveData<String> characterName, jobName, bufferCharacterName;

    public static RepositoryImp getInstance() {
        if (instance == null){
            instance = new RepositoryImp();
        }
        return instance;
    }

    private RepositoryImp(){
        characterName = new MutableLiveData<>();
        jobName = new MutableLiveData<>();
        bufferCharacterName = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<String> getCharacterName() {
        characterName.setValue(TransmittedData.getInstance().getCharacterName());
        return characterName;
    }

    @Override
    public MutableLiveData<String> getJobName() {
        jobName.setValue(TransmittedData.getInstance().getJobName());
        return jobName;
    }

    @Override
    public MutableLiveData<String> getBufferCharacterName() {
        bufferCharacterName.setValue(TransmittedData.getInstance().getBufferCharacterName());
        return bufferCharacterName;
    }

    @Override
    public ArrayList<Character> getCharactersDB() {
        return CharacterDS.getInstance().getCharacters();
    }

    @Override
    public ArrayList<Job> getJobsDB() {
        return JobDS.getInstance().getJobs();
    }

    @Override
    public void setCharacterName(String name) {
        TransmittedData.getInstance().setCharacterName(name);
    }

    @Override
    public void setJobName(String name) {
        TransmittedData.getInstance().setJobName(name);
    }

    @Override
    public void setBufferCharacterName(String name) {
        TransmittedData.getInstance().setBufferCharacterName(name);
    }
}
