package com.example.ex7.UILayer.ViewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ex7.DataLayer.DS.Room.Entities.Job;
import com.example.ex7.DataLayer.Rep.RepositoryImp;

import java.util.ArrayList;
import java.util.List;

public class JobListViewModel extends ViewModel {
    public LiveData<List<Job>> getJobs(Context context) {
        return RepositoryImp.getInstance(context).getJobsDB();
    }
}
