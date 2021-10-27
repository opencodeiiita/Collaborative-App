package com.example.opencodecollaborative21app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.classes.Participant;

import java.util.ArrayList;

public class ParticipantAdapter extends RecyclerView.Adapter<ParticipantAdapter.MyViewHolder>{

    private ArrayList<Participant> participants=new ArrayList<>();

    public ParticipantAdapter(ArrayList<Participant> projects) {
        this.participants = participants;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.participant_item,parent,false);
        return new ParticipantAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Participant curr=participants.get(position);
        holder.participantName.setText(curr.getName());

    }

    @Override
    public int getItemCount() {
        return participants.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView participantName;
        ImageView participantFb, participantGithub, participantTwitter;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            participantName=(TextView) itemView.findViewById(R.id.ParticipantName);
            participantFb=(ImageView) itemView.findViewById(R.id.ParticipantFB);
            participantGithub=(ImageView) itemView.findViewById(R.id.ParticipantGithub);
            participantTwitter=(ImageView) itemView.findViewById(R.id.ParticipantTwitter);
        }
    }
}
