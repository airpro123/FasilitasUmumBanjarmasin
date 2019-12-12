package com.example.projekfasilitasumumandri;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projekfasilitasumumandri.fragment.DokumenFragment;
import com.example.projekfasilitasumumandri.fragment.LokasiFragment;
import com.example.projekfasilitasumumandri.fragment.SimAFragment;
import com.example.projekfasilitasumumandri.fragment.SimAKFragment;
import com.example.projekfasilitasumumandri.fragment.SimB2Fragment;
import com.example.projekfasilitasumumandri.fragment.SimBFragment;
import com.example.projekfasilitasumumandri.fragment.SimCFragment;
import com.example.projekfasilitasumumandri.fragment.SimDFragment;
import com.example.projekfasilitasumumandri.fragment.ViewPagerAdapter;
import com.example.projekfasilitasumumandri.fragment.ViewPagerAdapter2;

public class SimActivity extends AppCompatActivity {

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);

        appBarLayout = findViewById(R.id.appBarSIM);
        tabLayout = findViewById(R.id.tabLayoutSIM);
        viewPager = findViewById(R.id.viewpagerSIM);

        Button btnLokasi = findViewById(R.id.btn_sim);

        ViewPagerAdapter2 adapter = new ViewPagerAdapter2(getSupportFragmentManager());
        adapter.addFragment(new SimAFragment(), "SIM A");
        adapter.addFragment(new SimAKFragment(), "SIM A K");
        adapter.addFragment(new SimBFragment(), "SIM B1");
        adapter.addFragment(new SimB2Fragment(), "SIM B2");
        adapter.addFragment(new SimCFragment(), "SIM C");
        adapter.addFragment(new SimDFragment(), "SIM D");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SimActivity.this, PemerintahanActivity.class);
                i.putExtra("sim", "gedung_pelayanan_sim");
                startActivity(i);
            }
        });

    }
}
