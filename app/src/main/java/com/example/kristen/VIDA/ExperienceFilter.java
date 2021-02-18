package com.example.kristen.VIDA;

/*
import android.widget.Filter;
import android.widget.Filter.FilterResults;

import java.util.ArrayList;
import java.util.List;

public class ExperienceFilter extends Filter {

    ArrayList<Experience> allExperiences = getIntent().getParcelableArrayListExtra("allExperiences");

    @Override
    public FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if (constraint == null || constraint.length() == 0) {
            results.values = allExperiences;
            results.count = allExperiences.size();
        }
        else {
            List<Experience> nExperienceList = new ArrayList<Experience>();
            for (Experience exp : nExperienceList) {
                if (exp.getLocation().toUpperCase()
                        .startsWith(constraint.toString().toUpperCase()))
                    nExperienceList.add(exp);
            }
            results.values = nExperienceList;
            results.count = nExperienceList.size();
            return results;
        }
    }

    @Override
    public void publishResults(CharSequence constraint, FilterResults results) {
        if (results.count == 0)
            notifyDataSetInvalidated();
        else {
            experienceList = (ArrayList<Experience>)results.values;
            notifyDataSetChanged();
        }
    }
}
*/