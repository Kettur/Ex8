package com.example.ex7.UILayer.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.ex7.DataLayer.Models.Character;
import com.example.ex7.DataLayer.Rep.RepositoryImp;

import java.util.ArrayList;

public class CharacterListViewModel extends ViewModel {
    private ArrayList<Character> characters;

    public ArrayList<Character> getCharacters() {
        return RepositoryImp.getInstance().getCharactersDB();
    }
}
