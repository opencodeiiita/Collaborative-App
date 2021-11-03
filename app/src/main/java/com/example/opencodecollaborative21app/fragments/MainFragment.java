package com.example.opencodecollaborative21app.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.interfaces.CollabInterface;

public class MainFragment extends Fragment implements CollabInterface {
    View view;
    Button viewOurWebsite;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_main, container, false);
        findViewsAndAttachListeners(view);
        return view;
    }

    @Override
    public void findViewsAndAttachListeners(View view) {
        viewOurWebsite = view.findViewById(R.id.button);

        viewOurWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl ("https://opencodeiiita.github.io/");
            }
        });
    }

    @Override
    public void setupViewModelAndNavController(View view) {

    }
}