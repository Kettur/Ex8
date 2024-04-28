package com.example.ex7.DataLayer.DS.Room.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

@Entity (tableName = "jobTable")
public class Job {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "jobName")
    private String name;
    public Job(){
        name = "";
    }
    public Job(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}