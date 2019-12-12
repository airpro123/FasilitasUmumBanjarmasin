package com.example.projekfasilitasumumandri.fragment;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.projekfasilitasumumandri.R;

public class SimB2Fragment extends Fragment {

    boolean simbII1, simbII2, simbII3, simbII4, simbII5, simbII6, simbII7;
    public static int id1, id2, id3, id4, id5, id6, id7;

    public SimB2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheckBox cbsimbII = view.findViewById(R.id.cbsimbII);
        CheckBox cbsimbII2 = view.findViewById(R.id.cbsimbII2);
        CheckBox cbsimbII3 = view.findViewById(R.id.cbsimbII3);
        CheckBox cbsimbII4 = view.findViewById(R.id.cbsimbII4);
        CheckBox cbsimbII5 = view.findViewById(R.id.cbsimbII5);
        CheckBox cbsimbII6 = view.findViewById(R.id.cbsimbII6);
        CheckBox cbsimbII7 = view.findViewById(R.id.cbsimbII7);

        simbII1 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbII1", false);

        simbII2 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbII2", false);

        simbII3 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbII3", false);

        simbII4 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbII4", false);

        simbII5 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbII5", false);

        simbII6 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbII6", false);

        simbII7 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbII7", false);

        cbsimbII.setChecked(simbII1);
        cbsimbII2.setChecked(simbII2);
        cbsimbII3.setChecked(simbII3);
        cbsimbII4.setChecked(simbII4);
        cbsimbII5.setChecked(simbII5);
        cbsimbII6.setChecked(simbII6);
        cbsimbII7.setChecked(simbII7);

        cbKlik(cbsimbII);
        cbKlik(cbsimbII2);
        cbKlik(cbsimbII3);
        cbKlik(cbsimbII4);
        cbKlik(cbsimbII5);
        cbKlik(cbsimbII6);
        cbKlik(cbsimbII7);

    }

    private void cbKlik(CheckBox cb){
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.cbsimbII: {
                        simbII1 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbII1", simbII1).apply();
                        break;
                    }
                    case R.id.cbsimbII2: {
                        simbII2 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbII2", simbII2).apply();
                        break;
                    }
                    case R.id.cbsimbII3: {
                        simbII3 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbII3", simbII3).apply();
                        break;
                    }
                    case R.id.cbsimbII4: {
                        simbII4 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbII4", simbII4).apply();
                        break;
                    }
                    case R.id.cbsimbII5: {
                        simbII5 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbII5", simbII5).apply();
                        break;
                    }
                    case R.id.cbsimbII6: {
                        simbII6 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbII6", simbII6).apply();
                        break;
                    }
                    case R.id.cbsimbII7: {
                        simbII7 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbII7", simbII7).apply();
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
        return inflater.inflate(R.layout.fragment_sim_b2, container, false);
    }

}
