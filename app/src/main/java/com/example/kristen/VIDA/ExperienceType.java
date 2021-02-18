package com.example.kristen.VIDA;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ExperienceType extends AppCompatActivity {

    ArrayList<Experience> experiences;
    Experience[] filteredExperiences;
    ExperienceDatabase experienceDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_type);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        TextView activation = findViewById(R.id.activate_button);
        experiences = Utils.getMyExperiences();

        ArrayList<String> loc_list = new ArrayList<String>();
        ArrayList<String> type_list = new ArrayList<String>();
        for (int i = 0; i < experiences.size(); i++){
            Experience experience = experiences.get(i);
            String type = experience.getType();
            String location = experience.getLocation();
            if (!(loc_list.contains(location))){
                loc_list.add(location);
            }
            if (!(type_list.contains(type))){
                type_list.add(type);
            }
        }

        ArrayAdapter<CharSequence> adapterLocation = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, loc_list);
        ArrayAdapter<CharSequence> adapterType = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, type_list);
        AutoCompleteTextView locText = (AutoCompleteTextView) findViewById(R.id.city_input);
        AutoCompleteTextView typeText = (AutoCompleteTextView) findViewById(R.id.type_input);
        locText.setAdapter(adapterLocation);
        typeText.setAdapter(adapterType);

        experienceDatabase = Utils.getMyDatabase();

        activation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = ((EditText) findViewById(R.id.city_input)).getText().toString();
                String type = ((EditText) findViewById(R.id.type_input)).getText().toString();

                if (location.isEmpty() && type.isEmpty()){
                    filteredExperiences = experienceDatabase.getAllExperiences();
                }
                else if (location.isEmpty()){
                    filteredExperiences = experienceDatabase.getEachType(type);
                }
                else if (type.isEmpty()){
                    filteredExperiences = experienceDatabase.getLocationInfo(location);
                }
                else{
                    filteredExperiences = experienceDatabase.getFilterExperiences(location, type);
                }
                Utils.setMyExperiences(new ArrayList<Experience>(Arrays.asList(filteredExperiences)));

                Intent newIntent = new Intent(ExperienceType.this, ItineraryChoice.class);
                ExperienceType.this.startActivity(newIntent);
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        TabLayout.Tab tab = tabLayout.getTabAt(1);
        tab.select();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0){
                    Intent intent = new Intent(ExperienceType.this, MainActivity.class);
                    ExperienceType.this.startActivity(intent);
                }
                else if (position == 2){
                    Intent intent = new Intent(ExperienceType.this, WriteReview.class);
                    ExperienceType.this.startActivity(intent);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}
