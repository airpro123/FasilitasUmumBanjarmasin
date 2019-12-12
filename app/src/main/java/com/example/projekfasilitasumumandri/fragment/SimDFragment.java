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

public class SimDFragment extends Fragment {

    boolean simd1, simd2, simd3, simd4, simd5, simd6, simd7;
    public static int id1, id2, id3, id4, id5, id6, id7;

    public SimDFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CheckBox cbsimd = view.findViewById(R.id.cbsimd);
        CheckBox cbsimd2 = view.findViewById(R.id.cbsimd2);
        CheckBox cbsimd3 = view.findViewById(R.id.cbsimd3);
        CheckBox cbsimd4 = view.findViewById(R.id.cbsimd4);
        CheckBox cbsimd5 = view.findViewById(R.id.cbsimd5);
        CheckBox cbsimd6 = view.findViewById(R.id.cbsimd6);
        CheckBox cbsimd7 = view.findViewById(R.id.cbsimd7);

        simd1 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simd1", false);

        simd2 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simd2", false);

        simd3 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simd3", false);

        simd4 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simd4", false);

        simd5 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simd5", false);

        simd6 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simd6", false);

        simd7 = PreferenceManager.getDefaultSharedPreferences(getContext())
                .getBoolean("simd7", false);

        cbsimd.setChecked(simd1);
        cbsimd2.setChecked(simd2);
        cbsimd3.setChecked(simd3);
        cbsimd4.setChecked(simd4);
        cbsimd5.setChecked(simd5);
        cbsimd6.setChecked(simd6);
        cbsimd7.setChecked(simd7);

        cbKlik(cbsimd);
        cbKlik(cbsimd2);
        cbKlik(cbsimd3);
        cbKlik(cbsimd4);
        cbKlik(cbsimd5);
        cbKlik(cbsimd6);
        cbKlik(cbsimd7);

    }

    private void cbKlik(CheckBox cb){
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.cbsimd: {
                        simd1 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simd1", simd1).apply();
                        break;
                    }
                    case R.id.cbsimd2: {
                        simd2 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simd2", simd2).apply();
                        break;
                    }
                    case R.id.cbsimd3: {
                        simd3 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simd3", simd3).apply();
                        break;
                    }
                    case R.id.cbsimd4: {
                        simd4 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simd4", simd4).apply();
                        break;
                    }
                    case R.id.cbsimd5: {
                        simd5 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simd5", simd5).apply();
                        break;
                    }
                    case R.id.cbsimd6: {
                        simd6 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simd6", simd6).apply();
                        break;
                    }
                    case R.id.cbsimd7: {
                        simd7 = ((CheckBox) v).isChecked();
                        PreferenceManager.getDefaultSharedPreferences(getContext()).edit()
                                .putBoolean( "simd7", simd7).apply();
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
        return inflater.inflate(R.layout.fragment_sim_d, container, false);
    }

}
