package com.example.opencodecollaborative21app.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.interfaces.CollabInterface;

public class SplashScreenFragment extends Fragment implements CollabInterface {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViewModelAndNavController(view);
    }

    @Override
    public void findViewsAndAttachListeners(View view) {

    }

    @Override
    public void setupViewModelAndNavController(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigation.findNavController(view).navigate(R.id.action_splashScreenFragment_to_mainFragment);
            }
        }, 1500); //adding 1.5 sec delay
    }
}
