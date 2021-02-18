package com.example.kristen.VIDA;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity
public class Experience implements Parcelable {

    public Experience(String type, String location, String user, int rating, String description){
        this.uuid = UUID.randomUUID().toString();
        this.type = type;
        this.location = location;
        this.user = user;
        this.rating = rating;
        this.description = description;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo (name="UUID")
    public String uuid;

    @NonNull
    public String getUUID(){
        return uuid;
    }

    public void setUUID(String id){
        this.uuid = id;
    }

    @ColumnInfo (name="Experience_Type")
    public String type;

    @NonNull
    public String getType(){
        return type;
    }

    public void setType(String exp_type){
        this.type = exp_type;
    }

    @ColumnInfo (name="Location")
    public String location;

    @NonNull
    public String getLocation(){
        return location;
    }

    public void setLocation(String loc){
        this.location = loc;
    }

    @ColumnInfo (name="User")
    public String user;

    @NonNull
    public String getUser(){
        return user;
    }

    public void setUser(String name){
        this.user = name;
    }

    @ColumnInfo (name="Rating")
    public int rating;

    @NonNull
    public int getRating(){
        return rating;
    }

    public void setRating(int rate){
        this.rating = rate;
    }

    @ColumnInfo (name="Description")
    public String description;

    @NonNull
    public String getDescription(){
        return description;
    }

    public void setDescription(String descr){
        this.description = descr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.location);
        dest.writeString(this.user);
        dest.writeInt(this.rating);
        dest.writeString(this.description);
    }

    public Experience(Parcel in) {
        this.type = in.readString();
        this.location = in.readString();
        this.user = in.readString();
        this.rating = in.readInt();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Experience> CREATOR = new Parcelable.Creator<Experience>() {
        @Override
        public Experience createFromParcel(Parcel source) {
            return new Experience(source);
        }

        @Override
        public Experience[] newArray(int size) {
            return new Experience[size];
        }
    };

}
