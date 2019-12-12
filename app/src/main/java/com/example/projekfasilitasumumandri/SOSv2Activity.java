package com.example.projekfasilitasumumandri;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.projekfasilitasumumandri.fragment.SOS1Fragment;
import com.example.projekfasilitasumumandri.fragment.SOS2Fragment;
import com.example.projekfasilitasumumandri.fragment.SOS3Fragment;
import com.example.projekfasilitasumumandri.fragment.SimAFragment;
import com.example.projekfasilitasumumandri.fragment.SimAKFragment;
import com.example.projekfasilitasumumandri.fragment.SimB2Fragment;
import com.example.projekfasilitasumumandri.fragment.SimBFragment;
import com.example.projekfasilitasumumandri.fragment.SimCFragment;
import com.example.projekfasilitasumumandri.fragment.SimDFragment;
import com.example.projekfasilitasumumandri.fragment.ViewPagerAdapter2;

public class SOSv2Activity extends AppCompatActivity {

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sosv2);

        appBarLayout = findViewById(R.id.appBarSOS);
        tabLayout = findViewById(R.id.tabLayoutSOS);
        viewPager = findViewById(R.id.viewpagerSOS);

        ViewPagerAdapter2 adapter = new ViewPagerAdapter2(getSupportFragmentManager());
        adapter.addFragment(new SOS1Fragment(), "BPK");
        adapter.addFragment(new SOS2Fragment(), "Kepolisian");
        adapter.addFragment(new SOS3Fragment(), "Rumah Sakit");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
