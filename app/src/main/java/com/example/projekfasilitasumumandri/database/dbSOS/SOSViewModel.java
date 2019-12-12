package com.example.projekfasilitasumumandri.database.dbSOS;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class SOSViewModel extends AndroidViewModel {

    private SOSRepository repository;
    private LiveData<List<SOS>> allSOS;
    private LiveData<List<SOS>> sosPemadam;
    private String filter = "";

    String setKategori(){
        return filter;
    }

    public SOSViewModel(@NonNull Application application) {
        super(application);
        repository = new SOSRepository(application);
        allSOS = repository.getAllSOS();
        sosPemadam = repository.getSOSPemadam(setKategori());
    }

    public void insert(SOS sos){
        repository.insert(sos);
    }

    public void update(SOS sos){
        repository.update(sos);
    }

    public void delete(SOS sos){
        repository.delete(sos);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public LiveData<List<SOS>> getAllSOS() {
        return allSOS;
    }

    public LiveData<List<SOS>> getSosPemadam() {
        return sosPemadam;
    }

}
