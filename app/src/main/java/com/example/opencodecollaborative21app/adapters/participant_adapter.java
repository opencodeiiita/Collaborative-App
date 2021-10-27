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
import com.example.opencodecollaborative21app.classes.Participant;

import java.util.ArrayList;

public class participant_adapter extends RecyclerView.Adapter<participant_adapter.MyViewHolder>{

    private ArrayList<Participant> participants=new ArrayList<>();

    public participant_adapter(ArrayList<Participant> projects) {
        this.participants = participants;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.participant_item,parent,false);
        return new participant_adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Participant curr=participants.get(position);
        holder.participantName.setText(curr.getName());
        holder.participantGithub.setText(curr.getGitId());
    }

    @Override
    public int getItemCount() {
        return participants.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView participantName, participantGithub;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            participantName=(TextView) itemView.findViewById(R.id.ParticipantName);
            participantGithub=(TextView) itemView.findViewById(R.id.ParticipantGithub);
        }
    }
}
