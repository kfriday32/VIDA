package com.example.kristen.VIDA;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ExperienceHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public Experience experience;
    public TextView user;
    public TextView type;
    public TextView location;
    public TextView rating;
    public TextView description;
    public Context context;
    public ImageView typeImage;
    public ImageView mainImage;

    public ExperienceHolder(Context context, View convertView) {
        super(convertView);
        this.context = context;
        this.user = (TextView) convertView.findViewById(R.id.user);
        this.type = (TextView) convertView.findViewById(R.id.type);
        this.location = (TextView) convertView.findViewById(R.id.location);
        this.rating = (TextView) convertView.findViewById(R.id.rating);
        this.description = (TextView) convertView.findViewById(R.id.description);
        this.typeImage = (ImageView) convertView.findViewById(R.id.typeImage);
        this.mainImage = (ImageView) convertView.findViewById(R.id.image);

        convertView.setOnClickListener(this);
    }

    public void bindExperience(Experience exp){
        this.user.setText(exp.user);
        this.location.setText(exp.location);
        this.description.setText(exp.description);
        this.rating.setText(String.valueOf(exp.rating));
        this.type.setText(exp.type);
        if (this.type.getText().toString().equals("Outdoors")){
            this.typeImage.setImageResource(R.drawable.ic_outdoors);
            this.mainImage.setImageResource(R.mipmap.hiking_example);
        }
        else if (this.type.getText().toString().equals("Bars")) {
            this.typeImage.setImageResource(R.drawable.ic_beer);
            this.mainImage.setImageResource(R.mipmap.bar_example);
        }
    }

    @Override
    public void onClick(View v) {
        // 5. Handle the onClick event for the ViewHolder
        if (this.experience != null) {
            Toast.makeText(this.context, "Clicked on " + this.experience.type, Toast.LENGTH_SHORT ).show();
        }
    }
}
