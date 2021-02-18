package com.example.kristen.VIDA;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database (entities={Experience.class}, version=3)
public abstract class AppDatabase extends RoomDatabase{
    public abstract ExperienceDao experienceDao();
}
