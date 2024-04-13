package com.example.ex7.UILayer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ex7.R;
import com.example.ex7.UILayer.ViewModels.MainMenuViewModel;
import com.example.ex7.databinding.FragmentMenuBinding;


public class MenuFragment extends Fragment {
    private FragmentMenuBinding binding;
    private MainMenuViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(MainMenuViewModel.class);

        viewModel.getCharacterName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textViewSelectChar.setText(s);
            }
        });
        viewModel.getJobName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textViewSelectJob.setText(s);
            }
        });

        binding.textViewSelectChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_menuFragment_to_characterFragment);
            }
        });

        binding.textViewSelectJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_menuFragment_to_jobFragment);
            }
        });

        binding.buttonToSelectedJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_menuFragment_to_currentJobFragment);
            }
        });

        return binding.getRoot();
    }
}