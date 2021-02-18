package com.example.kristen.VIDA;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceHolder>{

    public ArrayList<Experience> experiences;
    public Context context;
    public int itemResource;

    public ExperienceAdapter(Context context, int itemResource, ArrayList<Experience> experienceArrayList) {
        this.context = context;
        this.itemResource = itemResource;
        this.experiences = experienceArrayList;
    }

    @Override
    public ExperienceHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(this.itemResource, parent, false);
        return new ExperienceHolder(this.context, view);
    }

    @Override
    public void onBindViewHolder(ExperienceHolder holder, int position) {

        Experience experience = this.experiences.get(position);
        holder.bindExperience(experience);
    }

    @Override
    public int getItemCount() {
        return this.experiences.size();
    }
}
