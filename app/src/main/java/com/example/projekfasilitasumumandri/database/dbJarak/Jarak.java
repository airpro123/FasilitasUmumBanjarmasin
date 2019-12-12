package com.example.projekfasilitasumumandri.database.dbJarak;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbJarak")
public class Jarak implements Serializable {

    //id
    //jarak
    //lat
    //lng

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "jarak")
    public double jarak;

    @ColumnInfo(name = "lat")
    public String lat;

    @ColumnInfo(name = "lng")
    public String lng;

    public Jarak(){

    }

    public Jarak(double jarak, String lat, String lng) {
        this.jarak = jarak;
        this.lat = lat;
        this.lng = lng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getJarak() {
        return jarak;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
