package com.example.projekfasilitasumumandri.database.dbLokasi;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.projekfasilitasumumandri.database.AppDatabase;

import java.util.List;

public class LokasiRepository {

    private LokasiDAO lokasiDAO;
    private LiveData<List<Lokasi>> allLokasi;
    private LiveData<List<Lokasi>> lokasiPemerintah;
    private String kategori;

    public LokasiRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        lokasiDAO = database.lokasiDAO();
        allLokasi = lokasiDAO.getAllLokasi();
        lokasiPemerintah = lokasiDAO.getLokasiKategori(kategori);
    }

    public void insert(Lokasi lokasi){
        new InsertLokasiAsyncTask(lokasiDAO).execute(lokasi);
    }

    public void update(Lokasi lokasi){
        new UpdateLokasiAsyncTask(lokasiDAO).execute(lokasi);
    }

    public void delete(Lokasi lokasi){
        new DeleteLokasiAsyncTask(lokasiDAO).execute(lokasi);
    }

    public void deleteAll(){
        new DeleteAllLokasiAsyncTask(lokasiDAO).execute();
    }

    public LiveData<List<Lokasi>> getAllLokasi() {
        return allLokasi;
    }

    public LiveData<List<Lokasi>> getLokasiPemerintah(String kategori) {
        this.kategori = kategori;
        return lokasiPemerintah;
    }

    private static class InsertLokasiAsyncTask extends AsyncTask<Lokasi, Void, Void>{

        private LokasiDAO lokasiDAO;

        private InsertLokasiAsyncTask(LokasiDAO lokasiDAO){
            this.lokasiDAO = lokasiDAO;
        }

        @Override
        protected Void doInBackground(Lokasi... lokasis) {
            lokasiDAO.insert(lokasis[0]);
            return null;
        }
    }

    private static class UpdateLokasiAsyncTask extends AsyncTask<Lokasi, Void, Void>{

        private LokasiDAO lokasiDAO;

        private UpdateLokasiAsyncTask(LokasiDAO lokasiDAO){
            this.lokasiDAO = lokasiDAO;
        }

        @Override
        protected Void doInBackground(Lokasi... lokasis) {
            lokasiDAO.update(lokasis[0]);
            return null;
        }
    }

    private static class DeleteLokasiAsyncTask extends AsyncTask<Lokasi, Void, Void>{

        private LokasiDAO lokasiDAO;

        private DeleteLokasiAsyncTask(LokasiDAO lokasiDAO){
            this.lokasiDAO = lokasiDAO;
        }

        @Override
        protected Void doInBackground(Lokasi... lokasis) {
            lokasiDAO.delete(lokasis[0]);
            return null;
        }
    }

    private static class DeleteAllLokasiAsyncTask extends AsyncTask<Lokasi, Void, Void>{

        private LokasiDAO lokasiDAO;

        private DeleteAllLokasiAsyncTask(LokasiDAO lokasiDAO){
            this.lokasiDAO = lokasiDAO;
        }

        @Override
        protected Void doInBackground(Lokasi... lokasis) {
            lokasiDAO.deletAll();
            return null;
        }
    }

}

