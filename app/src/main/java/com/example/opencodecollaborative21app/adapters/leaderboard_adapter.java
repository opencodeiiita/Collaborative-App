package com.example.opencodecollaborative21app.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.classes.LeaderBoard;
import com.example.opencodecollaborative21app.classes.Participant;

import java.util.ArrayList;

public class leaderboard_adapter extends RecyclerView.Adapter<leaderboard_adapter.MyViewHolder> {
    private AdapterView.OnItemClickListener listener;

    private ArrayList<Participant> leaderBoard=new ArrayList<Participant>();
    private Context context;
    public leaderboard_adapter(ArrayList<Participant> leaderBoard,Context context) {
        this.leaderBoard=leaderBoard;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.leaderboard_item,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Participant current=leaderBoard.get(position);
        holder.name.setText(current.getName());
        holder.username.setText(current.getGitId());
        holder.score.setText(current.getScore());

    }

    @Override
    public int getItemCount() {
        return leaderBoard.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView  name, score, username;
//        ImageView profile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.Name);
            score=(TextView) itemView.findViewById(R.id.Score);
            username=(TextView) itemView.findViewById(R.id.Username);
//            profile=(ImageView) itemView.findViewById(R.id.profile_image);
        }
    }
}
