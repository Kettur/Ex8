package com.example.ex7.UILayer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ex7.DataLayer.DS.Files.AppSpecificStorage;
import com.example.ex7.DataLayer.DS.Files.GeneralStorage;
import com.example.ex7.DataLayer.DS.SharedPreferences.SharedPreferencesDB;
import com.example.ex7.DataLayer.Rep.RepositoryImp;
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

        viewModel.getCharacterName(getContext()).observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textViewSelectChar.setText(s);
            }
        });
        viewModel.getJobName(getContext()).observe(getViewLifecycleOwner(), new Observer<String>() {
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
//                app-specific{
//                AppSpecificStorage.getInstance(getActivity()).writeData(
//                        "Ваш специалист: " + RepositoryImp.getInstance().getMasterName().getValue() + "\n" +
//                               "Выбранная услуга: " + RepositoryImp.getInstance().getServiceName().getValue());
//                }
//                int result = ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
//                if (result != PackageManager.PERMISSION_GRANTED){
//                    ActivityCompat.requestPermissions(getActivity(),
//                            new String[]{
//                                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                    Manifest.permission.READ_EXTERNAL_STORAGE,
//                            },
//                            1);
//                }
//                else {
//                    GeneralStorage.getInstance(getContext()).writeData("Ваш специалист: " + RepositoryImp.getInstance().getMasterName().getValue() + "\n" +
//                            "Выбранная услуга: " + RepositoryImp.getInstance().getServiceName().getValue());
//                }
//                SharedPreferencesDB.getInstance(getContext()).setValue("Специалист", RepositoryImp.getInstance().getMasterName().getValue());
//                SharedPreferencesDB.getInstance(getContext()).setValue("Услуга", RepositoryImp.getInstance().getServiceName().getValue());

                Navigation.findNavController(v).navigate(R.id.action_menuFragment_to_currentJobFragment);
            }
        });

        return binding.getRoot();
    }
}