package com.example.projekfasilitasumumandri.database.dbJarak;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.projekfasilitasumumandri.database.dbSOS.SOS;
import com.example.projekfasilitasumumandri.database.dbSOS.SOSRepository;

import java.util.List;

public class JarakViewModel extends AndroidViewModel {

    private JarakRepository repository;
    private LiveData<List<Jarak>> allJarak;
    private String filter = "";

    public JarakViewModel(@NonNull Application application) {
        super(application);
        repository = new JarakRepository(application);
        allJarak = repository.getAllJarak();
    }

    public void insert(Jarak jarak){
        repository.insert(jarak);
    }

    public void update(Jarak jarak){
        repository.update(jarak);
    }

    public void delete(Jarak jarak){
        repository.delete(jarak);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public LiveData<List<Jarak>> getAllJarak() {
        return allJarak;
    }

}
