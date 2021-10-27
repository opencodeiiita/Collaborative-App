package com.example.opencodecollaborative21app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.classes.Mentor;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class mentor_adapter extends RecyclerView.Adapter<mentor_adapter.MyViewHolder>{

    private ArrayList<Mentor> mentors=new ArrayList<>();

    public mentor_adapter(ArrayList<Mentor> mentors) {
        this.mentors = mentors;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.mentor_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Mentor mentor=mentors.get(position);
        holder.mentorNameId.setText(mentor.getName());
    }

    @Override
    public int getItemCount() {
        return mentors.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mentorNameId;
        CircleImageView profileImageMentor;
        ImageView mentorFb, mentorGithub, mentorTwitter;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mentorNameId=(TextView) itemView.findViewById(R.id.mentorNameId);
            profileImageMentor=(CircleImageView) itemView.findViewById(R.id.profile_image);
            mentorFb=(ImageView) itemView.findViewById(R.id.mentorFb);
            mentorGithub=(ImageView) itemView.findViewById(R.id.mentorGithub);
            mentorTwitter=(ImageView) itemView.findViewById(R.id.Twitter);


        }
    }
}
