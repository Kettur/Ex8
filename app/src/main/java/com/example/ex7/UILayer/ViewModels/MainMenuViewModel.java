package com.example.ex7.UILayer.ViewModels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ex7.DataLayer.Rep.RepositoryImp;

public class MainMenuViewModel extends ViewModel {

    public MutableLiveData<String> getCharacterName(Context context) {
        return RepositoryImp.getInstance(context).getCharacterName();
    }

    public MutableLiveData<String> getJobName(Context context) {
        return RepositoryImp.getInstance(context).getJobName();
    }
}
