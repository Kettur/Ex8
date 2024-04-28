package com.example.ex7.UILayer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ex7.R;
import com.example.ex7.UILayer.ViewModels.CurrentJobViewModel;
import com.example.ex7.databinding.FragmentCurrentJobBinding;


public class CurrentJobFragment extends Fragment {

    private FragmentCurrentJobBinding binding;
    private CurrentJobViewModel viewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCurrentJobBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(CurrentJobViewModel.class);

        viewModel.getCharacterName(getContext()).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textViewInfo.setText("Worker: " + s + "\n");
            }
        });

        viewModel.getJobName(getContext()).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textViewInfo.setText(binding.textViewInfo.getText() + "Current job: " + s);
            }
        });
        //        app-specific/general{
//        String data = AppSpecificStorage.getInstance(getActivity()).readData();
//        binding.textViewVisitInfo.setText(data);
//        }

//        String masterName = SharedPreferencesDB.getInstance(getContext()).getValue("Специалист");
//        String serviceName = SharedPreferencesDB.getInstance(getContext()).getValue("Услуга");
//        binding.textViewVisitInfo.setText("Выбранный специалист: " + masterName + "\n" + "Выбранная услуга: " + serviceName);

        return binding.getRoot();
    }
}