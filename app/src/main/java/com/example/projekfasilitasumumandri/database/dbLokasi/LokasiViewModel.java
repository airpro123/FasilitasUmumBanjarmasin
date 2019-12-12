package com.example.projekfasilitasumumandri.database.dbLokasi;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class LokasiViewModel extends AndroidViewModel {
    private LokasiRepository repository;
    private LiveData<List<Lokasi>> allLokasi;
    private LiveData<List<Lokasi>> lokasiPemerintah;
    private String filter = "";

    public LokasiViewModel(@NonNull Application application) {
        super(application);
        repository = new LokasiRepository(application);
        allLokasi = repository.getAllLokasi();
        lokasiPemerintah = repository.getLokasiPemerintah(setKategori());
    }

    public void insert(Lokasi lokasi){
        repository.insert(lokasi);
    }

    public void update(Lokasi lokasi){
        repository.update(lokasi);
    }

    public void delete(Lokasi lokasi){
        repository.delete(lokasi);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public LiveData<List<Lokasi>> getAllLokasi() {
        return allLokasi;
    }

    public LiveData<List<Lokasi>> getLokasiPemerintah() {
        return lokasiPemerintah;
    }

    String setKategori(){
        return filter;
    }

}

