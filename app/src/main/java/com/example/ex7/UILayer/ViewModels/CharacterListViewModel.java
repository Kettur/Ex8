package com.example.ex7.UILayer.ViewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ex7.DataLayer.DS.Room.Entities.Character;
import com.example.ex7.DataLayer.Rep.RepositoryImp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CharacterListViewModel extends ViewModel {

    public LiveData<List<Character>> getCharacters(Context context) {
        return RepositoryImp.getInstance(context).getCharactersDB();
    }
}
