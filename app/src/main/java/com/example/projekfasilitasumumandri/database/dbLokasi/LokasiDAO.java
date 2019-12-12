package com.example.projekfasilitasumumandri.database.dbLokasi;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.projekfasilitasumumandri.database.dbLokasi.Lokasi;

import java.util.List;

@Dao
public interface LokasiDAO {

    @Insert
    void insert(Lokasi lokasi);

    @Update
    void update(Lokasi lokasi);

    @Delete
    void delete(Lokasi lokasi);

    @Query("DELETE FROM tbLokasi")
    void deletAll();

    @Query("SELECT * FROM tbLokasi")
    LiveData<List<Lokasi>> getAllLokasi();

    @Query("SELECT * FROM tblokasi where tbLokasi.kategori = :kat ")
    LiveData<List<Lokasi>> getLokasiKategori(String kat);

    @Query("SELECT * FROM tblokasi where tbLokasi.kategori = :kat and tbLokasi.nama_lokasi like :cari ")
    LiveData<List<Lokasi>> getCariLokasi(String kat, String cari);

    @Query("SELECT DISTINCT tbLokasi.nama_lokasi FROM tbLokasi where tbLokasi.kategori = 'atm'")
    LiveData<List<String>> getLokasiAtm();

    @Query("SELECT DISTINCT tbLokasi.nama_lokasi FROM tbLokasi where tbLokasi.kategori = 'atm' and tbLokasi.nama_lokasi like :cari")
    LiveData<List<String>> getCariAtm(String cari);

    @Query("SELECT * FROM tbLokasi where tbLokasi.kategori = 'spbu'")
    LiveData<List<Lokasi>> getLokasiSPBU();
}

