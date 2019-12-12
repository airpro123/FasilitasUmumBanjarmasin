package com.example.projekfasilitasumumandri.database.dbSOS;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.projekfasilitasumumandri.database.AppDatabase;

import java.util.List;

public class SOSRepository {
    private SOSDAO SOSDAO;
    private LiveData<List<SOS>> allSOS;
    private LiveData<List<SOS>> SOSPemadam;
    private String kategori;

    public SOSRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        SOSDAO = database.sosDAO();
        allSOS = SOSDAO.getAllSOS();
        SOSPemadam = SOSDAO.getSOSKategori(kategori);
    }

    public LiveData<List<SOS>> getAllSOS() {
        return allSOS;
    }

    public LiveData<List<SOS>> getSOSPemadam(String kategori) {
        this.kategori = kategori;
        return SOSPemadam;
    }

    private static class InsertSOSAsyncTask extends AsyncTask<SOS, Void, Void> {

        private SOSDAO sosDAO;

        private InsertSOSAsyncTask(SOSDAO sosDAO){
            this.sosDAO = sosDAO;
        }

        @Override
        protected Void doInBackground(SOS... sos) {
            sosDAO.insert(sos[0]);
            return null;
        }
    }

    private static class UpdateSOSAsyncTask extends AsyncTask<SOS, Void, Void>{

        private SOSDAO sosDAO;

        private UpdateSOSAsyncTask(SOSDAO sosDAO){
            this.sosDAO = sosDAO;
        }

        @Override
        protected Void doInBackground(SOS... sos) {
            sosDAO.update(sos[0]);
            return null;
        }
    }

    private static class DeleteSOSAsyncTask extends AsyncTask<SOS, Void, Void>{

        private SOSDAO sosdao;

        private DeleteSOSAsyncTask(SOSDAO sosdao){
            this.sosdao = sosdao;
        }

        @Override
        protected Void doInBackground(SOS... sos) {
            sosdao.delete(sos[0]);
            return null;
        }
    }

    private static class DeleteAllSOSAsyncTask extends AsyncTask<SOS, Void, Void>{

        private SOSDAO sosdao;

        private DeleteAllSOSAsyncTask(SOSDAO sosdao){
            this.sosdao = sosdao;
        }

        @Override
        protected Void doInBackground(SOS... sos) {
            sosdao.deletAll();
            return null;
        }
    }

    public void insert(SOS sos){
        new SOSRepository.InsertSOSAsyncTask(SOSDAO).execute(sos);
    }

    public void update(SOS sos){
        new SOSRepository.UpdateSOSAsyncTask(SOSDAO).execute(sos);
    }

    public void delete(SOS sos){
        new SOSRepository.DeleteSOSAsyncTask(SOSDAO).execute(sos);
    }

    public void deleteAll(){
        new SOSRepository.DeleteAllSOSAsyncTask(SOSDAO).execute();
    }

}
