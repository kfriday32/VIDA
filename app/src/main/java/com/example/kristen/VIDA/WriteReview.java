package com.example.kristen.VIDA;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class WriteReview extends AppCompatActivity {

    ArrayList<Experience> experiences;
    Experience[] allExperiences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        TextView shareButton = findViewById(R.id.submit);
        experiences = Utils.getMyExperiences();

        shareButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String type = ((EditText) findViewById(R.id.type)).getText().toString();
                String location = ((EditText) findViewById(R.id.location)).getText().toString();
                String ratingText = ((EditText) findViewById(R.id.rating)).getText().toString();
                String description = ((EditText) findViewById(R.id.description)).getText().toString();

                if ((name.equals("")) || (type.equals("")) || (location.equals("")) || (ratingText.equals("")) || (description.equals(""))) {
                    Toast toastMessage = Toast.makeText(getApplicationContext(), "Must fill all entry fields", Toast.LENGTH_LONG);
                    toastMessage.show();
                }
                else{
                    int rating = Integer.parseInt(ratingText);

                    Experience experience = new Experience(type, location, name, rating, description);
                    ExperienceDatabase expDb = Utils.getMyDatabase();
                    expDb.insertExperience(experience);
                    Utils.setMyDatabase(expDb);
                    allExperiences = expDb.getAllExperiences();
                    Utils.setMyExperiences(new ArrayList<Experience>(Arrays.asList(allExperiences)));

                    ((EditText) findViewById(R.id.name)).setText("");
                    ((EditText) findViewById(R.id.type)).setText("");
                    ((EditText) findViewById(R.id.location)).setText("");
                    ((EditText) findViewById(R.id.rating)).setText("");
                    ((EditText) findViewById(R.id.description)).setText("");

                    Snackbar.make(findViewById(R.id.header),
                            "LINE successfully created!",
                            Snackbar.LENGTH_LONG)
                            .show();
                }
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        TabLayout.Tab tab = tabLayout.getTabAt(2);
        tab.select();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0){
                    Intent intent = new Intent(WriteReview.this, MainActivity.class);
                    WriteReview.this.startActivity(intent);
                }
                else if (position == 1){
                    Intent intent = new Intent(WriteReview.this, ExperienceType.class);
                    WriteReview.this.startActivity(intent);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}
