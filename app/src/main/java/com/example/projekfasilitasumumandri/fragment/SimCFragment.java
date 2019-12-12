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

public class SimCFragment extends Fragment {

    boolean simc1, simc2, simc3, simc4, simc5, simc6, simc7;
    public static int id1, id2, id3, id4, id5, id6, id7;

    public SimCFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheckBox cbsimc = view.findViewById(R.id.cbsimc);
        CheckBox cbsimc2 = view.findViewById(R.id.cbsimc2);
        CheckBox cbsimc3 = view.findViewById(R.id.cbsimc3);
        CheckBox cbsimc4 = view.findViewById(R.id.cbsimc4);
        CheckBox cbsimc5 = view.findViewById(R.id.cbsimc5);
        CheckBox cbsimc6 = view.findViewById(R.id.cbsimc6);
        CheckBox cbsimc7 = view.findViewById(R.id.cbsimc7);

        simc1 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simc1", false);

        simc2 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simc2", false);

        simc3 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simc3", false);

        simc4 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simc4", false);

        simc5 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simc5", false);

        simc6 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simc6", false);

        simc7 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simc7", false);

        cbsimc.setChecked(simc1);
        cbsimc2.setChecked(simc2);
        cbsimc3.setChecked(simc3);
        cbsimc4.setChecked(simc4);
        cbsimc5.setChecked(simc5);
        cbsimc6.setChecked(simc6);
        cbsimc7.setChecked(simc7);

        cbKlik(cbsimc);
        cbKlik(cbsimc2);
        cbKlik(cbsimc3);
        cbKlik(cbsimc4);
        cbKlik(cbsimc5);
        cbKlik(cbsimc6);
        cbKlik(cbsimc7);

    }

    private void cbKlik(CheckBox cb){
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.cbsimc: {
                        simc1 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simc1", simc1).apply();
                        break;
                    }
                    case R.id.cbsimc2: {
                        simc2 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simc2", simc2).apply();
                        break;
                    }
                    case R.id.cbsimc3: {
                        simc3 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simc3", simc3).apply();
                        break;
                    }
                    case R.id.cbsimc4: {
                        simc4 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simc4", simc4).apply();
                        break;
                    }
                    case R.id.cbsimc5: {
                        simc5 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simc5", simc5).apply();
                        break;
                    }
                    case R.id.cbsimc6: {
                        simc6 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simc6", simc6).apply();
                        break;
                    }
                    case R.id.cbsimc7: {
                        simc7 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simc7", simc7).apply();
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
        return inflater.inflate(R.layout.fragment_sim_c, container, false);
    }

}
