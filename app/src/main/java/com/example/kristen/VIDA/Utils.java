package com.example.kristen.VIDA;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Experience> myExperiences;

    public static ArrayList<Experience> getMyExperiences(){
        return myExperiences;
    }

    public static void setMyExperiences(ArrayList<Experience> expList){
        myExperiences = expList;
    }

    public static ExperienceDatabase myDatabase;

    public static ExperienceDatabase getMyDatabase(){
        return myDatabase;
    }

    public static void setMyDatabase(ExperienceDatabase expDb){
        myDatabase = expDb;
    }
}
