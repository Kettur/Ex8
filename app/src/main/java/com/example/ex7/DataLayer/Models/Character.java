package com.example.ex7.DataLayer.Models;

import androidx.annotation.NonNull;

public class Character {
    private String name;

    public Character(String name){
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
