package com.example.opencodecollaborative21app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.adapters.leaderboard_adapter;
import com.example.opencodecollaborative21app.classes.LeaderBoard;
import com.example.opencodecollaborative21app.viewmodel.MainViewModel;

import java.util.ArrayList;

public class Leaderboard extends Fragment {

    View view;
    private ArrayList<LeaderBoard> leaderboards;
    MainViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.leaderboard, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.leaderboardRecyclerView);
        leaderboard_adapter leaderboardAdapter = new leaderboard_adapter(leaderboards);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(leaderboardAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        viewModel.getSelected().observe(getViewLifecycleOwner(), item -> {

        });
    }
}
