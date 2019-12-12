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

public class SimBFragment extends Fragment {
    boolean simbI1, simbI2, simbI3, simbI4, simbI5, simbI6, simbI7;
    public static int id1, id2, id3, id4, id5, id6, id7;

    public SimBFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheckBox cbsimbI = view.findViewById(R.id.cbsimbI);
        CheckBox cbsimbI2 = view.findViewById(R.id.cbsimbI2);
        CheckBox cbsimbI3 = view.findViewById(R.id.cbsimbI3);
        CheckBox cbsimbI4 = view.findViewById(R.id.cbsimbI4);
        CheckBox cbsimbI5 = view.findViewById(R.id.cbsimbI5);
        CheckBox cbsimbI6 = view.findViewById(R.id.cbsimbI6);
        CheckBox cbsimbI7 = view.findViewById(R.id.cbsimbI7);

        simbI1 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbI1", false);

        simbI2 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbI2", false);

        simbI3 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbI3", false);

        simbI4 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbI4", false);

        simbI5 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbI5", false);

        simbI6 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbI6", false);

        simbI7 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simbI7", false);

        cbsimbI.setChecked(simbI1);
        cbsimbI2.setChecked(simbI2);
        cbsimbI3.setChecked(simbI3);
        cbsimbI4.setChecked(simbI4);
        cbsimbI5.setChecked(simbI5);
        cbsimbI6.setChecked(simbI6);
        cbsimbI7.setChecked(simbI7);

        cbKlik(cbsimbI);
        cbKlik(cbsimbI2);
        cbKlik(cbsimbI3);
        cbKlik(cbsimbI4);
        cbKlik(cbsimbI5);
        cbKlik(cbsimbI6);
        cbKlik(cbsimbI7);

    }

    private void cbKlik(CheckBox cb){
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.cbsimbI: {
                        simbI1 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbI1", simbI1).apply();
                        break;
                    }
                    case R.id.cbsimbI2: {
                        simbI2 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbI2", simbI2).apply();
                        break;
                    }
                    case R.id.cbsimbI3: {
                        simbI3 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbI3", simbI3).apply();
                        break;
                    }
                    case R.id.cbsimbI4: {
                        simbI4 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbI4", simbI4).apply();
                        break;
                    }
                    case R.id.cbsimbI5: {
                        simbI5 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbI5", simbI5).apply();
                        break;
                    }
                    case R.id.cbsimbI6: {
                        simbI6 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbI6", simbI6).apply();
                        break;
                    }
                    case R.id.cbsimbI7: {
                        simbI7 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simbI7", simbI7).apply();
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
        return inflater.inflate(R.layout.fragment_sim_b, container, false);
    }

}
