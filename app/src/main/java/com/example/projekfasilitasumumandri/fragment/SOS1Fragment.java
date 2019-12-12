package com.example.projekfasilitasumumandri.fragment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projekfasilitasumumandri.R;
import com.example.projekfasilitasumumandri.SOSActivity;
import com.example.projekfasilitasumumandri.database.AppDatabase;
import com.example.projekfasilitasumumandri.database.dbSOS.SOS;
import com.example.projekfasilitasumumandri.database.dbSOS.SOSDAO;
import com.example.projekfasilitasumumandri.recycleradapter.AdapterSOSRecyclerView;

import java.util.List;

public class SOS1Fragment extends Fragment {

    AppDatabase database;
    SOSDAO sosDAO;
    LiveData<List<SOS>> lokasiSOS;
    List<SOS> listSOS;

    final AdapterSOSRecyclerView adapter = new AdapterSOSRecyclerView();

    public SOS1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sos_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            database = AppDatabase.getInstance(view.getContext());
            sosDAO = database.sosDAO();
            recyclerAdapter(view);

            lokasiSOS = sosDAO.getSOSKategori("bpk");
            lokasiSOS.observe(this, new Observer<List<SOS>>() {
                @Override
                public void onChanged(@Nullable List<SOS> sos) {
                    listSOS = sos;
                    adapter.setLokasi(sos);
                }
            });
        }catch (Exception e){

        }

    }

    private void recyclerAdapter(View view) {
        try {
            RecyclerView recyclerView = view.findViewById(R.id.recycler_sos1);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);

        }catch (Exception e){

        }
    }
}
