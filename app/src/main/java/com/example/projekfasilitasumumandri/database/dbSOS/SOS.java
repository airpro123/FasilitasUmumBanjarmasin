package com.example.projekfasilitasumumandri.database.dbSOS;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbSOS")
public class SOS implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nama_lokasi")
    public String namaLokasi;

    @ColumnInfo(name = "lat")
    public String lat;

    @ColumnInfo(name = "lng")
    public String lng;

    @ColumnInfo(name = "telepon")
    public String telepon;

    @ColumnInfo(name = "kategori")
    public String kategori;

    public SOS(String namaLokasi, String lat, String lng, String telepon, String kategori) {
        this.namaLokasi = namaLokasi;
        this.lat = lat;
        this.lng = lng;
        this.telepon = telepon;
        this.kategori = kategori;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getKategori() {
        return kategori;
    }
}
