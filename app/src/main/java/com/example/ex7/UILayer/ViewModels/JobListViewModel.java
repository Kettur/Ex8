package com.example.ex7.UILayer.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.ex7.DataLayer.Models.Job;
import com.example.ex7.DataLayer.Rep.RepositoryImp;

import java.util.ArrayList;

public class JobListViewModel extends ViewModel {
    private ArrayList<Job> jobs;

    public ArrayList<Job> getJobs() {
        return RepositoryImp.getInstance().getJobsDB();
    }
}
