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

public class SimAKFragment extends Fragment {

    boolean simak1, simak2, simak3, simak4, simak5, simak6, simak7;
    public static int id1, id2, id3, id4, id5, id6, id7;

    public SimAKFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheckBox cbsimak = view.findViewById(R.id.cbsimak);
        CheckBox cbsimak2 = view.findViewById(R.id.cbsimak2);
        CheckBox cbsimak3 = view.findViewById(R.id.cbsimak3);
        CheckBox cbsimak4 = view.findViewById(R.id.cbsimak4);
        CheckBox cbsimak5 = view.findViewById(R.id.cbsimak5);
        CheckBox cbsimak6 = view.findViewById(R.id.cbsimak6);
        CheckBox cbsimak7 = view.findViewById(R.id.cbsimak7);

        simak1 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simak1", false);

        simak2 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simak2", false);

        simak3 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simak3", false);

        simak4 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simak4", false);

        simak5 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simak5", false);

        simak6 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simak6", false);

        simak7 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simak7", false);

        cbsimak.setChecked(simak1);
        cbsimak2.setChecked(simak2);
        cbsimak3.setChecked(simak3);
        cbsimak4.setChecked(simak4);
        cbsimak5.setChecked(simak5);
        cbsimak6.setChecked(simak6);
        cbsimak7.setChecked(simak7);

        cbKlik(cbsimak);
        cbKlik(cbsimak2);
        cbKlik(cbsimak3);
        cbKlik(cbsimak4);
        cbKlik(cbsimak5);
        cbKlik(cbsimak6);
        cbKlik(cbsimak7);

    }

    private void cbKlik(CheckBox cb){
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.cbsimak: {
                        simak1 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simak1", simak1).apply();
                        break;
                    }
                    case R.id.cbsimak2: {
                        simak2 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simak2", simak2).apply();
                        break;
                    }
                    case R.id.cbsimak3: {
                        simak3 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simak3", simak3).apply();
                        break;
                    }
                    case R.id.cbsimak4: {
                        simak4 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simak4", simak4).apply();
                        break;
                    }
                    case R.id.cbsimak5: {
                        simak5 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simak5", simak5).apply();
                        break;
                    }
                    case R.id.cbsimak6: {
                        simak6 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simak6", simak6).apply();
                        break;
                    }
                    case R.id.cbsimak7: {
                        simak7 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simak7", simak7).apply();
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
        return inflater.inflate(R.layout.fragment_sim_a_khusus, container, false);
    }

}
