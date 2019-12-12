package com.example.projekfasilitasumumandri.fragment;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projekfasilitasumumandri.MapActivity;
import com.example.projekfasilitasumumandri.PemerintahanActivity;
import com.example.projekfasilitasumumandri.R;

public class LokasiFragment extends Fragment implements View.OnClickListener {
    Context context;
    private CardView cvPemerintah, cv_polisi, cv_rumahsakit, cv_pariwisata, cv_spbu, cv_atm;

    public LokasiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lokasi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cvPemerintah = view.findViewById(R.id.cv_pemerintahan);
        cv_polisi = view.findViewById(R.id.cv_polisi);
        cv_rumahsakit = view.findViewById(R.id.cv_rumahsakit);
        cv_pariwisata = view.findViewById(R.id.cv_pariwisata);
        cv_spbu = view.findViewById(R.id.cv_spbu);
        cv_atm = view.findViewById(R.id.cv_atm);

        cvPemerintah.setOnClickListener(this);
        cv_polisi.setOnClickListener(this);
        cv_rumahsakit.setOnClickListener(this);
        cv_pariwisata.setOnClickListener(this);
        cv_spbu.setOnClickListener(this);
        cv_atm.setOnClickListener(this);

    }

    private void lokasiPilihan(String jdl){
        Intent i = new Intent(getActivity(), PemerintahanActivity.class);
        i.putExtra("kategori", jdl);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(getActivity(),
                R.anim.slide_in_right, R.anim.slide_out_right);
        startActivity(i, options.toBundle());
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.cv_pemerintahan){
            lokasiPilihan("pemerintahan");
        }else if (view.getId()==R.id.cv_polisi){
            lokasiPilihan("polisi");
        }else if (view.getId()==R.id.cv_rumahsakit){
            lokasiPilihan("rumahsakit");
        }else if (view.getId()==R.id.cv_pariwisata){
            lokasiPilihan("wisata");
        }else if (view.getId()==R.id.cv_spbu){
            //lokasiPilihan("spbu");
            Intent i = new Intent(getActivity(), MapActivity.class);
            i.putExtra("kategori", "spbu");
            startActivity(i);
        }else {
            lokasiPilihan("atm");
        }
    }
}
