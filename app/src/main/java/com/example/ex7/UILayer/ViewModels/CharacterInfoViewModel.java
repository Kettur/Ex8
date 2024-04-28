package com.example.ex7.UILayer.ViewModels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ex7.DataLayer.Rep.RepositoryImp;

public class CharacterInfoViewModel extends ViewModel {
    public MutableLiveData<String> getBufferCharacterName(Context context) {
        return RepositoryImp.getInstance(context).getBufferCharacterName();
    }
}
