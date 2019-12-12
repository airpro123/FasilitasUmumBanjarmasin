package com.example.projekfasilitasumumandri.database.dbJarak;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.projekfasilitasumumandri.database.AppDatabase;

import java.util.List;

public class JarakRepository {

    private JarakDAO jarakDAO;
    private LiveData<List<Jarak>> allJarak;

    public JarakRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        jarakDAO = database.jarakDAO();
        allJarak = jarakDAO.getAllJarak();
    }

    public void insert(Jarak jarak){
        new JarakRepository.InsertLokasiAsyncTask(jarakDAO).execute(jarak);
    }

    public void update(Jarak jarak){
        new JarakRepository.UpdateLokasiAsyncTask(jarakDAO).execute(jarak);
    }

    public void delete(Jarak jarak){
        new JarakRepository.DeleteLokasiAsyncTask(jarakDAO).execute(jarak);
    }

    public void deleteAll(){
        new JarakRepository.DeleteAllLokasiAsyncTask(jarakDAO).execute();
    }

    public LiveData<List<Jarak>> getAllJarak() {
        return allJarak;
    }

    private static class InsertLokasiAsyncTask extends AsyncTask<Jarak, Void, Void> {

        private JarakDAO jarakDAO;

        private InsertLokasiAsyncTask(JarakDAO jarakDAO){
            this.jarakDAO = jarakDAO;
        }

        @Override
        protected Void doInBackground(Jarak... jaraks) {
            jarakDAO.insert(jaraks[0]);
            return null;
        }
    }

    private static class UpdateLokasiAsyncTask extends AsyncTask<Jarak, Void, Void>{

        private JarakDAO jarakDAO;

        private UpdateLokasiAsyncTask(JarakDAO jarakDAO){
            this.jarakDAO = jarakDAO;
        }

        @Override
        protected Void doInBackground(Jarak... jaraks) {
            jarakDAO.update(jaraks[0]);
            return null;
        }
    }

    private static class DeleteLokasiAsyncTask extends AsyncTask<Jarak, Void, Void>{

        private JarakDAO jarakDAO;

        private DeleteLokasiAsyncTask(JarakDAO jarakDAO){
            this.jarakDAO = jarakDAO;
        }

        @Override
        protected Void doInBackground(Jarak... jaraks) {
            jarakDAO.delete(jaraks[0]);
            return null;
        }
    }

    private static class DeleteAllLokasiAsyncTask extends AsyncTask<Jarak, Void, Void>{

        private JarakDAO jarakDAO;

        private DeleteAllLokasiAsyncTask(JarakDAO jarakDAO){
            this.jarakDAO = jarakDAO;
        }

        @Override
        protected Void doInBackground(Jarak... jaraks) {
            jarakDAO.deletAll();
            return null;
        }
    }

}
