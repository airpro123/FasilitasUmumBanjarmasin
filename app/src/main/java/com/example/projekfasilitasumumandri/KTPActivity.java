package com.example.projekfasilitasumumandri;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class KTPActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9;
    Button btnCapil, btnKelurahan;

    boolean ck1, ck2, ck3, ck4, ck5, ck6, ck7, ck8, ck9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ktp);

        initialisasi();

        cekState();

        cb1.setChecked(ck1);
        cb2.setChecked(ck2);
        cb3.setChecked(ck3);
        cb4.setChecked(ck4);
        cb5.setChecked(ck5);
        cb6.setChecked(ck6);

        btnCapil.setOnClickListener(this);
        btnKelurahan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_capil:{
                Intent i = new Intent(KTPActivity.this, PemerintahanActivity.class);
                i.putExtra("aktekelahiran", "capil");
                startActivity(i);
                break;
            }
            case R.id.btn_kelurahan:{
                Intent i = new Intent(KTPActivity.this, PemerintahanActivity.class);
                i.putExtra("aktekelahiran", "kelurahan");
                startActivity(i);
                break;
            }

        }
    }

    private void cekState() {

        ck1 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbktp1", false);

        ck2 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbktp2", false);

        ck3 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbktp3", false);

        ck4 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbktp4", false);

        ck5 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbktp5", false);

        ck6 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbktp6", false);

    }

    private void initialisasi(){
        cb1 = findViewById(R.id.cbktp);
        cb2 = findViewById(R.id.cbktp2);
        cb3 = findViewById(R.id.cbktp3);
        cb4 = findViewById(R.id.cbktp4);
        cb5 = findViewById(R.id.cbktp5);
        cb6 = findViewById(R.id.cbktp6);

        btnCapil = findViewById(R.id.btn_capil);
        btnKelurahan = findViewById(R.id.btn_kelurahan);
    }

    public void onCheckboxClicked(View view) {
        switch (view.getId()){
            case R.id.cbktp:{
                ck1 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbktp1", ck1).apply();
                break;
            }
            case R.id.cbktp2:{
                ck2 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbktp2", ck2).apply();
                break;
            }
            case R.id.cbktp3:{
                ck3 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbktp3", ck3).apply();
                break;
            }
            case R.id.cbktp4:{
                ck4 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbktp4", ck4).apply();
                break;
            }
            case R.id.cbktp5:{
                ck5 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbktp5", ck5).apply();
                break;
            }
            case R.id.cbktp6:{
                ck6 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbktp6", ck6).apply();
                break;
            }

        }
    }
}