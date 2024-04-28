package com.example.ex7.UILayer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ex7.DataLayer.DS.Room.Entities.Character;
import com.example.ex7.DataLayer.Rep.RepositoryImp;
import com.example.ex7.R;
import com.example.ex7.SelectedItem;
import com.example.ex7.UILayer.Adapters.CharacterListAdapter;
import com.example.ex7.UILayer.ViewModels.CharacterListViewModel;
import com.example.ex7.databinding.FragmentCharacterBinding;

import java.util.List;


public class CharacterFragment extends Fragment implements SelectedItem {

    private FragmentCharacterBinding binding;
    private CharacterListViewModel viewmodel;
    private LiveData<List<Character>> characterList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCharacterBinding.inflate(getLayoutInflater());
        viewmodel = new ViewModelProvider(this).get(CharacterListViewModel.class);
        characterList = viewmodel.getCharacters(getContext());
        CharacterListAdapter adapter = new CharacterListAdapter(getContext(), characterList.getValue(), this);
        characterList.observe(getViewLifecycleOwner(), new Observer<List<Character>>() {
            @Override
            public void onChanged(List<Character> characters) {
                adapter.notifyDataSetChanged();
            }
        });
        binding.listViewCharacters.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onItemClicked(Object character) {
        RepositoryImp.getInstance(getContext()).setBufferCharacterName(character.toString());
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_characterFragment_to_characterInfoFragment);
    }
}