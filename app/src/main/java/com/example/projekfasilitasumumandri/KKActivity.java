package com.example.projekfasilitasumumandri;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class KKActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9;
    Button btnCapil, btnKelurahan;

    boolean ck1, ck2, ck3, ck4, ck5, ck6, ck7, ck8, ck9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kk);

        initialisasi();

        cekState();

        cb1.setChecked(ck1);
        cb2.setChecked(ck2);
        cb3.setChecked(ck3);
        cb4.setChecked(ck4);
        cb5.setChecked(ck5);
        cb6.setChecked(ck6);
        cb7.setChecked(ck7);
        cb8.setChecked(ck8);

        btnCapil.setOnClickListener(this);
        btnKelurahan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_capil:{
                Intent i = new Intent(KKActivity.this, PemerintahanActivity.class);
                i.putExtra("aktekelahiran", "capil");
                startActivity(i);
                break;
            }
            case R.id.btn_kelurahan:{
                Intent i = new Intent(KKActivity.this, PemerintahanActivity.class);
                i.putExtra("aktekelahiran", "kelurahan");
                startActivity(i);
                break;
            }

        }
    }

    private void cekState() {

        ck1 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbkk1", false);

        ck2 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbkk2", false);

        ck3 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbkk3", false);

        ck4 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbkk4", false);

        ck5 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbkk5", false);

        ck6 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbkk6", false);

        ck7 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbkk7", false);

        ck8 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cbkk8", false);

    }

    private void initialisasi(){
        cb1 = findViewById(R.id.cbkk);
        cb2 = findViewById(R.id.cbkk2);
        cb3 = findViewById(R.id.cbkk3);
        cb4 = findViewById(R.id.cbkk4);
        cb5 = findViewById(R.id.cbkk5);
        cb6 = findViewById(R.id.cbkk6);
        cb7 = findViewById(R.id.cbkk7);
        cb8 = findViewById(R.id.cbkk8);
        btnCapil = findViewById(R.id.btn_capil);
        btnKelurahan = findViewById(R.id.btn_kelurahan);
    }

    public void onCheckboxClicked(View view) {
        switch (view.getId()){
            case R.id.cbkk:{
                ck1 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbkk1", ck1).apply();
                break;
            }
            case R.id.cbkk2:{
                ck2 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbkk2", ck2).apply();
                break;
            }
            case R.id.cbkk3:{
                ck3 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbkk3", ck3).apply();
                break;
            }
            case R.id.cbkk4:{
                ck4 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbkk4", ck4).apply();
                break;
            }
            case R.id.cbkk5:{
                ck5 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbkk5", ck5).apply();
                break;
            }
            case R.id.cbkk6:{
                ck6 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbkk6", ck6).apply();
                break;
            }
            case R.id.cbkk7:{
                ck7 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbkk7", ck7).apply();
                break;
            }
            case R.id.cbkk8:{
                ck8 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cbkk8", ck8).apply();
                break;
            }

        }
    }
}
