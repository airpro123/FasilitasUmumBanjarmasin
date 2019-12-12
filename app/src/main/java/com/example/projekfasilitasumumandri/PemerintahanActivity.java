package com.example.projekfasilitasumumandri;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projekfasilitasumumandri.database.AppDatabase;
import com.example.projekfasilitasumumandri.database.dbLokasi.Lokasi;
import com.example.projekfasilitasumumandri.database.dbLokasi.LokasiDAO;
import com.example.projekfasilitasumumandri.database.dbLokasi.LokasiViewModel;
import com.example.projekfasilitasumumandri.recycleradapter.AdapterAtmRecyclerView;
import com.example.projekfasilitasumumandri.recycleradapter.AdapterLokasiRecyclerView;

import java.util.List;

public class PemerintahanActivity extends AppCompatActivity implements TextWatcher {

    LokasiViewModel lokasiViewModel;
    AppDatabase database;
    LokasiDAO lokasiDAO;
    LiveData<List<Lokasi>> lokasiPemerintah;
    LiveData<List<String>> lokasiAtm;

    EditText etSearch;
    String kat, dokumen, sim;

    final AdapterLokasiRecyclerView adapter = new AdapterLokasiRecyclerView();
    final AdapterAtmRecyclerView adapterAtm = new AdapterAtmRecyclerView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemerintahan);

        Intent i = getIntent();
        kat = i.getStringExtra("kategori");
        dokumen = i.getStringExtra("aktekelahiran");
        sim = i.getStringExtra("sim");

        etSearch = findViewById(R.id.et_search);
        etSearch.addTextChangedListener(this);

        database = AppDatabase.getInstance(this);
        lokasiDAO = database.lokasiDAO();

        if (sim != null){
            recyclerAdapter("polisi");
            if (sim.equals("gedung_pelayanan_sim")){
                lokasiPemerintah = lokasiDAO.getLokasiKategori("polisi");

                lokasiPemerintah.observe(this, new Observer<List<Lokasi>>() {
                    @Override
                    public void onChanged(@Nullable List<Lokasi> lokasis) {
                        adapter.setLokasi(lokasis);
                        queryLokasiSim("Gedung Satpas SIM");
                    }
                });
            }
        }

        if (dokumen != null){
            recyclerAdapter("pemerintahan");
            if (dokumen.equals("capil")){
                lokasiPemerintah = lokasiDAO.getLokasiKategori("pemerintahan");

                lokasiPemerintah.observe(this, new Observer<List<Lokasi>>() {
                    @Override
                    public void onChanged(@Nullable List<Lokasi> lokasis) {
                        //adapter.setLokasi(lokasis);
                        queryLokasiDok("Kantor Dinas Kependudukan dan Pencatatan Sipil");
                    }
                });
            }else{
                lokasiPemerintah = lokasiDAO.getLokasiKategori("pemerintahan");

                lokasiPemerintah.observe(this, new Observer<List<Lokasi>>() {
                    @Override
                    public void onChanged(@Nullable List<Lokasi> lokasis) {
                        //adapter.setLokasi(lokasis);
                        queryLokasiDok("Kelurahan");
                    }
                });
            }

        }

        if (kat != null){
            recyclerAdapter(kat);

            if (kat.equals("atm")){

                lokasiAtm = lokasiDAO.getLokasiAtm();
                lokasiAtm.observe(this, new Observer<List<String>>() {
                    @Override
                    public void onChanged(@Nullable List<String> strings) {

                        //Toast.makeText(PemerintahanActivity.this, strings.get(1), Toast.LENGTH_SHORT).show();
                        adapterAtm.setLokasi(strings);

                    }
                });

            }else if (kat.equals("spbu")){
                Toast.makeText(this, "spbu", Toast.LENGTH_SHORT).show();
            }else{

                lokasiPemerintah = lokasiDAO.getLokasiKategori(kat);

                lokasiPemerintah.observe(this, new Observer<List<Lokasi>>() {
                    @Override
                    public void onChanged(@Nullable List<Lokasi> lokasis) {
                        adapter.setLokasi(lokasis);
                    }
                });

            }
        }

    }

    private void recyclerAdapter(String cek) {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        if (cek.equals("atm")){
            recyclerView.setAdapter(adapterAtm);
        }else{

            recyclerView.setAdapter(adapter);

        }
    }

    private void queryLokasi(String search){
        if (kat.equals("atm")){

            lokasiAtm = lokasiDAO.getCariAtm("%"+search+"%");
            lokasiAtm.observe(this, new Observer<List<String>>() {
                @Override
                public void onChanged(@Nullable List<String> strings) {
                    adapterAtm.setLokasi(strings);
                }
            });

        }else{

            lokasiPemerintah = lokasiDAO.getCariLokasi( kat,"%"+search+"%");
            lokasiPemerintah.observe(this, new Observer<List<Lokasi>>() {
                @Override
                public void onChanged(@Nullable List<Lokasi> lokasis) {
                    adapter.setLokasi(lokasis);
                }
            });

        }
    }

    private void queryLokasiDok(String search){
        lokasiPemerintah = lokasiDAO.getCariLokasi( "pemerintahan","%"+search+"%");
        lokasiPemerintah.observe(this, new Observer<List<Lokasi>>() {
            @Override
            public void onChanged(@Nullable List<Lokasi> lokasis) {
                adapter.setLokasi(lokasis);
            }
        });
    }

    private void queryLokasiSim(String search){
        lokasiPemerintah = lokasiDAO.getCariLokasi( "polisi","%"+search+"%");
        lokasiPemerintah.observe(this, new Observer<List<Lokasi>>() {
            @Override
            public void onChanged(@Nullable List<Lokasi> lokasis) {
                adapter.setLokasi(lokasis);
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (kat != null){
            queryLokasi(editable.toString());
        }else if (dokumen != null){
            queryLokasiDok(editable.toString());
        }else{
            queryLokasiSim(editable.toString());
        }
    }
}

