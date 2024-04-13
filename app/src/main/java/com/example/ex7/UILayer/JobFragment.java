package com.example.ex7.UILayer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
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
import com.example.ex7.UILayer.ViewModels.JobListViewModel;
import com.example.ex7.databinding.FragmentJobBinding;

import java.util.ArrayList;
import java.util.Objects;

public class JobFragment extends Fragment implements SelectedItem {
    private FragmentJobBinding binding;
    private JobListViewModel viewModel;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJobBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(JobListViewModel.class);
        JobListAdapter adapter = new JobListAdapter(getContext(), viewModel.getJobs(), this);
        binding.listViewJobs.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onItemClicked(Object job){
        RepositoryImp.getInstance().setJobName(job.toString());
        Navigation.findNavController(binding.getRoot()).popBackStack();
    }
}