package com.example.opencodecollaborative21app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opencodecollaborative21app.R;
import com.example.opencodecollaborative21app.classes.Project;

import java.util.ArrayList;

public class project_adapter extends RecyclerView.Adapter<project_adapter.MyViewHolder> {

    private ArrayList<Project> projects=new ArrayList<>();

    public project_adapter(ArrayList<Project> projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.project_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Project curr=projects.get(position);
        holder.projectName.setText(curr.getName());
        holder.projectDescription.setText(curr.getDescription());
        holder.repoLink.setText(curr.getGithubLink());
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView projectName, projectDescription, repoLink;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            projectName=(TextView) itemView.findViewById(R.id.ProjectName);
            projectDescription=(TextView) itemView.findViewById(R.id.ProjectDescription);
            repoLink=(TextView) itemView.findViewById(R.id.RepoLink);
        }
    }
}
