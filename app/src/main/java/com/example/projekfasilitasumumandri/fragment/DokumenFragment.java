package com.example.projekfasilitasumumandri.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.projekfasilitasumumandri.AktaKelahiranActivity;
import com.example.projekfasilitasumumandri.KKActivity;
import com.example.projekfasilitasumumandri.KTPActivity;
import com.example.projekfasilitasumumandri.R;
import com.example.projekfasilitasumumandri.SimActivity;

public class DokumenFragment extends Fragment {


    public DokumenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView cv_ak = view.findViewById(R.id.cv_ak);
        CardView cv_kk = view.findViewById(R.id.cv_kk);
        CardView cv_ktp = view.findViewById(R.id.cv_ktp);
        CardView cv_sim = view.findViewById(R.id.cv_sim);

        cvKlik(cv_ak, "ak");
        cvKlik(cv_kk, "kk");
        cvKlik(cv_ktp, "ktp");
        cvKlik(cv_sim, "sim");

    }

    private void cvKlik(CardView cv, String nama){
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nama.equals("ak")){

                    Intent i = new Intent(getContext(), AktaKelahiranActivity.class);
                    startActivity(i);

                }else if (nama.equals("kk")){

                    Intent i = new Intent(getContext(), KKActivity.class);
                    startActivity(i);

                }else if (nama.equals("ktp")){

                    Intent i = new Intent(getContext(), KTPActivity.class);
                    startActivity(i);

                }else{

                    Intent i = new Intent(getContext(), SimActivity.class);
                    startActivity(i);

                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dokumen, container, false);
    }
}
