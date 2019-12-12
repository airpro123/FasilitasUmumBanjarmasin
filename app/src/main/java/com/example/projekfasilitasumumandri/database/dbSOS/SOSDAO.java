package com.example.projekfasilitasumumandri.database.dbSOS;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface SOSDAO {

    @Insert
    void insert(SOS sos);

    @Update
    void update(SOS sos);

    @Delete
    void delete(SOS sos);

    @Query("DELETE FROM tbSOS")
    void deletAll();

    @Query("SELECT * FROM tbSOS")
    LiveData<List<SOS>> getAllSOS();

    @Query("SELECT * FROM tbSOS where kategori = :kat ")
    LiveData<List<SOS>> getSOSKategori(String kat);

    @Query("SELECT DISTINCT tbSOS.kategori FROM tbSOS")
    LiveData<List<String>> getMenu();

}
