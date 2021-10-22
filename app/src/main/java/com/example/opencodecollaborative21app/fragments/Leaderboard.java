package com.example.opencodecollaborative21app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.opencodecollaborative21app.R;

public class Leaderboard extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.leaderboard, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    }
}