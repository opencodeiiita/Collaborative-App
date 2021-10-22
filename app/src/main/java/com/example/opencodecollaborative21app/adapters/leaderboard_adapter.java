package com.example.opencodecollaborative21app.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opencodecollaborative21app.classes.LeaderBoard;

import java.util.ArrayList;

public class leaderboard_adapter extends RecyclerView.Adapter<leaderboard_adapter.MyViewHolder> {
    private AdapterView.OnItemClickListener listener;

    public leaderboard_adapter(ArrayList<LeaderBoard> leaderBoards) {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
