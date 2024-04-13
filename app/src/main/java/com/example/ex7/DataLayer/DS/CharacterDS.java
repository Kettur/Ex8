package com.example.ex7.DataLayer.DS;

import com.example.ex7.DataLayer.Models.Character;

import java.util.ArrayList;

public class CharacterDS {
    private static CharacterDS instance;
    private ArrayList<Character> characters;

    public static CharacterDS getInstance(){
        if (instance == null){
            instance = new CharacterDS();
        }
        return instance;
    }
    private CharacterDS(){
        characters = new ArrayList<>();
        characters.add(new Character("John"));
        characters.add(new Character("Karl"));
        characters.add(new Character("Arham"));
        characters.add(new Character("N"));
        characters.add(new Character("J"));
        characters.add(new Character("V"));
        characters.add(new Character("CYN"));
        characters.add(new Character("UZI"));
    }
    public ArrayList<Character> getCharacters(){
        return characters;
    }
    public void setCharacters(ArrayList<Character> characters){
        this.characters = characters;
    }
}
