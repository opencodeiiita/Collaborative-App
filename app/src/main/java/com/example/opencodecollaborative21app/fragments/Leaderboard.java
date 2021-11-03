package com.example.opencodecollaborative21app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.adapters.leaderboard_adapter;
import com.example.opencodecollaborative21app.api.FetchApiSingleton;
import com.example.opencodecollaborative21app.classes.LeaderBoard;
import com.example.opencodecollaborative21app.classes.Participant;
import com.example.opencodecollaborative21app.interfaces.ApiResponseHandler;
import com.example.opencodecollaborative21app.interfaces.CollabInterface;
import com.example.opencodecollaborative21app.viewmodel.MainViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Leaderboard extends Fragment implements CollabInterface {

    ArrayList<Participant> list;
    leaderboard_adapter leaderboardAdapter;
    private RecyclerView recyclerView;
    private NestedScrollView nestedSV;
    private int pg_no = 1;
    private boolean fg = false;
    FetchApiSingleton fetchApiSingleton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.leaderboard, container, false);
        list = new ArrayList<Participant>();
        findViewsAndAttachListeners(view);
        getLeaderboardData();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewModelAndNavController(view);
        list = new ArrayList<Participant>();
        fetchApiSingleton = new FetchApiSingleton(getContext());

    }

    private void getLeaderboardData() {
        fetchApiSingleton = new FetchApiSingleton(getContext());
        fetchApiSingleton.fetchApi("https://opencodeiiita.herokuapp.com/get-all-data/?page=" + pg_no,
                new ApiResponseHandler() {
                    @Override
                    public void onObjectResponse(JSONObject response) throws JSONException {
                        boolean has_next = response.getBoolean("has_next");
                        fg = !has_next;
                        JSONArray data = response.getJSONArray("data");
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject user_data = data.getJSONObject(i);
                            Participant participant = new Participant(user_data.getString("name"), user_data.getString("username"));
                            ArrayList<Participant.Repo> repos = new ArrayList<>();
                            JSONArray pointPerPR = user_data.getJSONArray("pointPerPR");
                            int score = 0;
                            for (int j = 0; j < pointPerPR.length(); j++) {
                                JSONObject repo_data = pointPerPR.getJSONObject(j);
                                Participant.Repo repo = new Participant.Repo(repo_data.getString("repoName"), repo_data.getInt("PRID"), repo_data.getInt("issueid"), repo_data.getInt("points"));
                                repos.add(repo);
                                score+=repo.getPoints();
                            }
                            participant.setScore(score);
                            participant.setRepo(repos);
                            list.add(participant);
                            leaderboardAdapter = new leaderboard_adapter(list,getContext());
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            recyclerView.setAdapter(leaderboardAdapter);
                        }
                    }

                    @Override
                    public void onErrorResponse(String error) {
                    }

                    @Override
                    public void onArrayResponse(JSONArray response) throws JSONException {
                    }
                }

        );

    }

    @Override
    public void findViewsAndAttachListeners(View view) {
        recyclerView = view.findViewById(R.id.leaderboardRecyclerView);
        nestedSV = view.findViewById(R.id.lbNestedSV);
        nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (!fg) {
                    if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                        pg_no++;
                        getLeaderboardData();
                    }
                }
            }
        });
    }

    @Override
    public void setupViewModelAndNavController(View view) {
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        viewModel.getSelected().observe(getViewLifecycleOwner(), item -> {
            list = item;
            leaderboardAdapter.notifyDataSetChanged();
        });
    }
}
