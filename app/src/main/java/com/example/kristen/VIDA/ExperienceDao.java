package com.example.kristen.VIDA;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface ExperienceDao {
    @Query("SELECT * FROM experience")
    Experience[] getAllExperiences();

    @Query("SELECT * FROM experience WHERE Experience_Type LIKE :type")
    Experience[] getExperiencesByType(String type);

    @Query("SELECT * FROM experience WHERE Location LIKE :loc")
    Experience[] getExperiencesByLocation(String loc);

    @Query("SELECT * FROM experience WHERE Rating LIKE :rate")
    Experience[] getExperiencesByRating(int rate);

    @Query("SELECT * FROM experience WHERE (Location LIKE :loc or Location == null) and " +
            "(Experience_Type LIKE :type or Experience_Type == null)")
    Experience[] getFilteredExperience(String type, String loc);

    @Insert
    void insertAll(Experience...experiences);

    @Delete
    void delete(Experience experience);
}
