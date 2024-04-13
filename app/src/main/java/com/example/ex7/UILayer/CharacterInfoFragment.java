package com.example.ex7.UILayer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ex7.DataLayer.Rep.RepositoryImp;
import com.example.ex7.R;
import com.example.ex7.UILayer.ViewModels.CharacterInfoViewModel;
import com.example.ex7.databinding.FragmentCharacterBinding;
import com.example.ex7.databinding.FragmentCharacterInfoBinding;


public class CharacterInfoFragment extends Fragment {

    private FragmentCharacterInfoBinding binding;
    private CharacterInfoViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharacterInfoBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(CharacterInfoViewModel.class);

        viewModel.getBufferCharacterName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textViewFullName.setText(s);
                binding.textViewDescription.setText(s + " - good worker");
            }
        });

        binding.buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RepositoryImp.getInstance().setCharacterName(viewModel.getBufferCharacterName().getValue());
                Navigation.findNavController(binding.getRoot()).popBackStack();
                Navigation.findNavController(binding.getRoot()).popBackStack();
            }
        });
        return binding.getRoot();
    }
}