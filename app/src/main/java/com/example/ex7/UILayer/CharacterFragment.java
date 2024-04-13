package com.example.ex7.UILayer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ex7.DataLayer.DS.CharacterDS;
import com.example.ex7.DataLayer.DS.JobDS;
import com.example.ex7.DataLayer.Models.Character;
import com.example.ex7.DataLayer.Models.Job;
import com.example.ex7.DataLayer.Rep.RepositoryImp;
import com.example.ex7.R;
import com.example.ex7.SelectedItem;
import com.example.ex7.UILayer.Adapters.CharacterListAdapter;
import com.example.ex7.UILayer.Adapters.JobListAdapter;
import com.example.ex7.UILayer.ViewModels.CharacterListViewModel;
import com.example.ex7.databinding.FragmentCharacterBinding;
import com.example.ex7.databinding.FragmentJobBinding;

import java.util.ArrayList;


public class CharacterFragment extends Fragment implements SelectedItem {

    private FragmentCharacterBinding binding;
    private CharacterListViewModel viewmodel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCharacterBinding.inflate(getLayoutInflater());
        viewmodel = new ViewModelProvider(this).get(CharacterListViewModel.class);
        CharacterListAdapter adapter = new CharacterListAdapter(getContext(), viewmodel.getCharacters(), this);
        binding.listViewCharacters.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onItemClicked(Object character) {
        RepositoryImp.getInstance().setBufferCharacterName(character.toString());
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_characterFragment_to_characterInfoFragment);
    }
}