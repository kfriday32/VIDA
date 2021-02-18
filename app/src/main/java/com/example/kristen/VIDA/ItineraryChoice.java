package com.example.kristen.VIDA;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class ItineraryChoice extends AppCompatActivity {

    ArrayList<Experience> filteredExperiences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_choice);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_no_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        filteredExperiences = Utils.getMyExperiences();

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recView = (RecyclerView) findViewById(R.id.listViewExperiences);
        recView.setLayoutManager(layoutManager);
        ExperienceAdapter adapter = new ExperienceAdapter(this, R.layout.recycler_experiences, filteredExperiences);
        recView.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        TabLayout.Tab tab = tabLayout.getTabAt(1);
        tab.select();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0){
                    Intent intent = new Intent(ItineraryChoice.this, MainActivity.class);
                    ItineraryChoice.this.startActivity(intent);
                }
                else if (position == 2){
                    Intent intent = new Intent(ItineraryChoice.this, WriteReview.class);
                    ItineraryChoice.this.startActivity(intent);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    public boolean onOptionsItemsSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), ExperienceType.class);
        this.startActivityForResult(myIntent, 104);
        return true;
    }
}
