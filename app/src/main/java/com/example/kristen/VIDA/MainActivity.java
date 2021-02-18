package com.example.kristen.VIDA;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ExperienceDatabase experienceDatabase;
    Experience[] allExperiences;
    ArrayList<Experience> experienceList;
    ArrayList<Experience> filteredList;
    Experience[] outdoors;
    Experience[] bars;
    ArrayList<Experience> outdoorsList;
    ArrayList<Experience> barsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        experienceDatabase = new ExperienceDatabase(this);
        Utils.setMyDatabase(experienceDatabase);
        allExperiences = experienceDatabase.getAllExperiences();
        outdoors = experienceDatabase.getEachType("Outdoors");
        bars = experienceDatabase.getEachType("Bars");
        filteredList = new ArrayList<Experience>(Arrays.asList(allExperiences));
        outdoorsList = new ArrayList<Experience>(Arrays.asList(outdoors));
        barsList = new ArrayList<Experience>(Arrays.asList(bars));

        DividerItemDecoration myDivider = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        myDivider.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerBars = new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false);

        RecyclerView recView = (RecyclerView) findViewById(R.id.listViewExperiences);
        RecyclerView recViewBars = (RecyclerView) findViewById(R.id.barExperiences);

        recView.setLayoutManager(layoutManager);
        recViewBars.setLayoutManager(layoutManagerBars);

        recView.addItemDecoration(myDivider);
        recViewBars.addItemDecoration(myDivider);

        ExperienceAdapter adapterOut = new ExperienceAdapter(this, R.layout.recycler_experiences, outdoorsList);
        ExperienceAdapter adapterBar = new ExperienceAdapter(this, R.layout.recycler_experiences, barsList);

        recView.setAdapter(adapterOut);
        recViewBars.setAdapter(adapterBar);

        recView.setNestedScrollingEnabled(false);
        recViewBars.setNestedScrollingEnabled(false);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 1){
                    Intent intent = new Intent(MainActivity.this, ExperienceType.class);
                    experienceList = new ArrayList<Experience>(Arrays.asList(allExperiences));
                    Utils.setMyExperiences(experienceList);
                    MainActivity.this.startActivity(intent);
                }
                else if (position == 2){
                    Intent intent = new Intent(MainActivity.this, WriteReview.class);
                    MainActivity.this.startActivity(intent);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}
