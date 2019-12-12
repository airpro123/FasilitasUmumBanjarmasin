package com.example.projekfasilitasumumandri.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.projekfasilitasumumandri.AktaKelahiranActivity;
import com.example.projekfasilitasumumandri.R;

public class SimAFragment extends Fragment {

    boolean sima1, sima2, sima3, sima4, sima5, sima6, sima7;
    public static int id1, id2, id3, id4, id5, id6, id7;

    public SimAFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheckBox cbSimA = view.findViewById(R.id.cbsima);
        CheckBox cbSimA2 = view.findViewById(R.id.cbsima2);
        CheckBox cbSimA3 = view.findViewById(R.id.cbsima3);
        CheckBox cbSimA4 = view.findViewById(R.id.cbsima4);
        CheckBox cbSimA5 = view.findViewById(R.id.cbsima5);
        CheckBox cbSimA6 = view.findViewById(R.id.cbsima6);
        CheckBox cbSimA7 = view.findViewById(R.id.cbsima7);

        sima1 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("sima1", false);

        sima2 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("sima2", false);

        sima3 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("sima3", false);

        sima4 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("sima4", false);

        sima5 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("sima5", false);

        sima6 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("sima6", false);

        sima7 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("sima7", false);

        cbSimA.setChecked(sima1);
        cbSimA2.setChecked(sima2);
        cbSimA3.setChecked(sima3);
        cbSimA4.setChecked(sima4);
        cbSimA5.setChecked(sima5);
        cbSimA6.setChecked(sima6);
        cbSimA7.setChecked(sima7);

        cbKlik(cbSimA);
        cbKlik(cbSimA2);
        cbKlik(cbSimA3);
        cbKlik(cbSimA4);
        cbKlik(cbSimA5);
        cbKlik(cbSimA6);
        cbKlik(cbSimA7);

    }

    private void cbKlik(CheckBox cb){
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.cbsima: {
                        sima1 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "sima1", sima1).apply();
                        break;
                    }
                    case R.id.cbsima2: {
                        sima2 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "sima2", sima2).apply();
                        break;
                    }
                    case R.id.cbsima3: {
                        sima3 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "sima3", sima3).apply();
                        break;
                    }
                    case R.id.cbsima4: {
                        sima4 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "sima4", sima4).apply();
                        break;
                    }
                    case R.id.cbsima5: {
                        sima5 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "sima5", sima5).apply();
                        break;
                    }
                    case R.id.cbsima6: {
                        sima6 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "sima6", sima6).apply();
                        break;
                    }
                    case R.id.cbsima7: {
                        sima7 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "sima7", sima7).apply();
                        break;
                    }
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sim_a, container, false);
    }


}
