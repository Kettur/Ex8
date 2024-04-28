package com.example.ex7.DataLayer.Rep;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ex7.DataLayer.DS.CharacterDS;
import com.example.ex7.DataLayer.DS.JobDS;
import com.example.ex7.DataLayer.DS.Room.DAO.interfaceDAO;
import com.example.ex7.DataLayer.DS.Room.Entities.Character;
import com.example.ex7.DataLayer.DS.Room.Entities.Job;
import com.example.ex7.DataLayer.DS.Room.RoomDB;
import com.example.ex7.DataLayer.DS.TransmittedData;
import com.example.ex7.DomainLayer.Protocol.Repository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImp implements Repository {
    private static RepositoryImp instance;
    private MutableLiveData<String> characterName;
    private MutableLiveData<String> jobName;
    private MutableLiveData<String> bufferCharacterName;
    private LiveData<List<Character>> charactersList;
    private LiveData<List<Job>> jobsList;
    private interfaceDAO myDAO;
    private final Context context;
    public static RepositoryImp getInstance(Context context){
        if (instance == null){
            instance = new RepositoryImp(context);
        }
        return instance;
    }
    private RepositoryImp(Context context){
        this.context = context;
        RoomDB roomDB = RoomDB.getDatabase(context);
        myDAO = roomDB.funcDAO();
        charactersList = myDAO.getCharacterFromRoom();
        jobsList = myDAO.getJobFromRoom();
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
    public LiveData<List<Character>> getCharactersDB() {
        return charactersList;
    }

    @Override
    public LiveData<List<Job>> getJobsDB() {
        return jobsList;
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
