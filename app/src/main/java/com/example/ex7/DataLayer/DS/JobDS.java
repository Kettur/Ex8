package com.example.ex7.DataLayer.DS;

import com.example.ex7.DataLayer.Models.Character;
import com.example.ex7.DataLayer.Models.Job;

import java.util.ArrayList;

public class JobDS {
    private static JobDS instance;
    private ArrayList<Job> jobs;

    public static JobDS getInstance(){
        if (instance == null){
            instance = new JobDS();
        }
        return instance;
    }
    private JobDS(){
        jobs = new ArrayList<>();
        jobs.add(new Job("Mine stone"));
        jobs.add(new Job("Mine coal"));
        jobs.add(new Job("Chop wood"));
        jobs.add(new Job("Mine iron"));
        jobs.add(new Job("Mine gold"));
        jobs.add(new Job("Mine diamonds"));
    }
    public ArrayList<Job> getJobs(){
        return jobs;
    }
    public void setJobs(ArrayList<Job> jobs){
        this.jobs = jobs;
    }
}
