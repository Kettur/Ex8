package com.example.ex7.UILayer.ViewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ex7.DataLayer.Rep.RepositoryImp;

public class CharacterInfoViewModel extends ViewModel {
    private MutableLiveData<String> bufferCharacterName = new MutableLiveData<>();

    public MutableLiveData<String> getBufferCharacterName() {
        return RepositoryImp.getInstance().getBufferCharacterName();
    }
}
