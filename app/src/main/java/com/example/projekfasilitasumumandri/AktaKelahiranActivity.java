package com.example.projekfasilitasumumandri;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AktaKelahiranActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9;
    Button btnCapil, btnKelurahan;

    boolean ck1, ck2, ck3, ck4, ck5, ck6, ck7, ck8, ck9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akta_kelahiran);

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
        cb9.setChecked(ck9);

        btnCapil.setOnClickListener(this);
        btnKelurahan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_capil:{
                Intent i = new Intent(AktaKelahiranActivity.this, PemerintahanActivity.class);
                i.putExtra("aktekelahiran", "capil");
                startActivity(i);
                break;
            }
            case R.id.btn_kelurahan:{
                Intent i = new Intent(AktaKelahiranActivity.this, PemerintahanActivity.class);
                i.putExtra("aktekelahiran", "kelurahan");
                startActivity(i);
                break;
            }

        }
    }

    private void cekState() {

        ck1 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cb1", false);

        ck2 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cb2", false);

        ck3 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cb3", false);

        ck4 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cb4", false);

        ck5 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cb5", false);

        ck6 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cb6", false);

        ck7 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cb7", false);

        ck8 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cb8", false);

        ck9 = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("cb9", false);

    }

    private void initialisasi(){
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        cb5 = findViewById(R.id.checkBox5);
        cb6 = findViewById(R.id.checkBox6);
        cb7 = findViewById(R.id.checkBox7);
        cb8 = findViewById(R.id.checkBox8);
        cb9 = findViewById(R.id.checkBox9);
        btnCapil = findViewById(R.id.btn_capil);
        btnKelurahan = findViewById(R.id.btn_kelurahan);
    }

    public void onCheckboxClicked(View view) {
        switch (view.getId()){
            case R.id.checkBox:{
                ck1 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cb1", ck1).apply();
                break;
            }
            case R.id.checkBox2:{
                ck2 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cb2", ck2).apply();
                break;
            }
            case R.id.checkBox3:{
                ck3 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cb3", ck3).apply();
                break;
            }
            case R.id.checkBox4:{
                ck4 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cb4", ck4).apply();
                break;
            }
            case R.id.checkBox5:{
                ck5 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cb5", ck5).apply();
                break;
            }
            case R.id.checkBox6:{
                ck6 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cb6", ck6).apply();
                break;
            }
            case R.id.checkBox7:{
                ck7 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cb7", ck7).apply();
                break;
            }
            case R.id.checkBox8:{
                ck8 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cb8", ck8).apply();
                break;
            }
            case R.id.checkBox9:{
                ck9 = ((CheckBox) view).isChecked();
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean( "cb9", ck9).apply();
                break;
            }

        }
    }
}
