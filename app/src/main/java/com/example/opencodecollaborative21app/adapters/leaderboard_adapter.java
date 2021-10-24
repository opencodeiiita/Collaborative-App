package com.example.opencodecollaborative21app.adapters;

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

import java.util.ArrayList;

public class leaderboard_adapter extends RecyclerView.Adapter<leaderboard_adapter.MyViewHolder> {
    private AdapterView.OnItemClickListener listener;

    private ArrayList<LeaderBoard> leaderBoard=new ArrayList<>();

    public leaderboard_adapter(ArrayList<LeaderBoard> leaderBoard) {
        this.leaderBoard=leaderBoard;
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
        LeaderBoard current=leaderBoard.get(position);
        holder.name.setText(current.getName());
        holder.username.setText(current.getUsername());
        holder.score.setText(current.getPoints());
        holder.rank.setText(current.getRank());
    }

    @Override
    public int getItemCount() {
        return leaderBoard.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView rank, name, score, username;
        ImageView profile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rank=(TextView) itemView.findViewById(R.id.rank);
            name=(TextView) itemView.findViewById(R.id.Name);
            score=(TextView) itemView.findViewById(R.id.Score);
            username=(TextView) itemView.findViewById(R.id.Username);
            profile=(ImageView) itemView.findViewById(R.id.profile_image);
        }
    }
}
