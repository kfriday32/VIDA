package com.example.kristen.VIDA;

import android.arch.persistence.room.Room;
import android.content.Context;

public class ExperienceDatabase {

    private final AppDatabase db;

    ExperienceDatabase(Context context){
        db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "LINES_db")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }

    public Experience[] getAllExperiences(){
        return db.experienceDao().getAllExperiences();
    }

    public Experience[] getEachType(String type){
        return db.experienceDao().getExperiencesByType(type);
    }

    public Experience[] getLocationInfo(String loc){
        return db.experienceDao().getExperiencesByLocation(loc);
    }

    public Experience[] getRatingInfo(int rating){
        return db.experienceDao().getExperiencesByRating(rating);
    }

    public void insertExperience(Experience experience){
        db.experienceDao().insertAll(experience);
    }

    public Experience[] getFilterExperiences(String loc, String type){
        return db.experienceDao().getFilteredExperience(type, loc);
    }

    public void deleteExperience(Experience experience){
        db.experienceDao().delete(experience);
    }

}
