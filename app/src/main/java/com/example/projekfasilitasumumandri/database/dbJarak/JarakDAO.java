package com.example.projekfasilitasumumandri.database.dbJarak;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.projekfasilitasumumandri.database.dbLokasi.Lokasi;

import java.util.List;

@Dao
public interface JarakDAO {

    @Insert
    void insert(Jarak jarak);

    @Update
    void update(Jarak jarak);

    @Delete
    void delete(Jarak jarak);

    @Query("DELETE FROM tbJarak")
    void deletAll();

    @Query("SELECT * FROM tbJarak")
    LiveData<List<Jarak>> getAllJarak();

    @Query("SELECT * FROM tbJarak ORDER BY tbJarak.jarak ASC LIMIT 1")
    LiveData<List<Jarak>> getJarakTerdekat();

}
