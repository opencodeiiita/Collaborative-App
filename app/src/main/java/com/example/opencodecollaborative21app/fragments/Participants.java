package com.example.opencodecollaborative21app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.interfaces.CollabInterface;

public class Participants extends Fragment implements CollabInterface {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.participant, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    }

    @Override
    public void findViewsAndAttachListeners(View view) {

    }

    @Override
    public void setupViewModelAndNavController(View view) {

    }
}