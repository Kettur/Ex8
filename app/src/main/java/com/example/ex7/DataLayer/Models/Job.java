package com.example.ex7.DataLayer.Models;

import androidx.annotation.NonNull;

public class Job {
    private String name;

    public Job(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
