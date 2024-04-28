package com.example.ex7.UILayer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ex7.DataLayer.DS.Room.Entities.Character;
import com.example.ex7.DataLayer.DS.Room.Entities.Job;
import com.example.ex7.DataLayer.Rep.RepositoryImp;
import com.example.ex7.SelectedItem;
import com.example.ex7.UILayer.Adapters.JobListAdapter;
import com.example.ex7.UILayer.ViewModels.JobListViewModel;
import com.example.ex7.databinding.FragmentJobBinding;

import java.util.ArrayList;
import java.util.List;

public class JobFragment extends Fragment implements SelectedItem {
    private FragmentJobBinding binding;
    private JobListViewModel viewModel;
    private LiveData<List<Job>> jobList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJobBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(JobListViewModel.class);
        jobList = viewModel.getJobs(getContext());
        JobListAdapter adapter = new JobListAdapter(getContext(), jobList.getValue(), this);

        jobList.observe(getViewLifecycleOwner(), new Observer<List<Job>>() {
            @Override
            public void onChanged(List<Job> jobs) {
                adapter.notifyDataSetChanged();
            }
        });
        binding.listViewJobs.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onItemClicked(Object job){
        RepositoryImp.getInstance(getContext()).setJobName(job.toString());
        Navigation.findNavController(binding.getRoot()).popBackStack();
    }
}