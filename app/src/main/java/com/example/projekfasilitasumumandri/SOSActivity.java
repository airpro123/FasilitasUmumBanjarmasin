package com.example.projekfasilitasumumandri;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.projekfasilitasumumandri.database.AppDatabase;
import com.example.projekfasilitasumumandri.database.dbSOS.SOS;
import com.example.projekfasilitasumumandri.database.dbSOS.SOSDAO;
import com.example.projekfasilitasumumandri.recycleradapter.AdapterSOSRecyclerView;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.Point;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SOSActivity extends AppCompatActivity{

    AppDatabase database;
    SOSDAO sosDAO;
    LiveData<List<SOS>> lokasiSOS;
    List<SOS> listSOS;
    List<Double> isiDouble = new ArrayList<>();
    Double[] arrayJarak = new Double[100];

    final AdapterSOSRecyclerView adapter = new AdapterSOSRecyclerView();

    Point origin;
    private Double jarak = 0.0;
    DirectionsRoute directionsRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        try {

//            Intent i = getIntent();
//            String oriLat = i.getStringExtra("oriLat");
//            String oriLng = i.getStringExtra("oriLng");

//            origin = Point.fromLngLat(Double.valueOf(oriLng), Double.valueOf(oriLat));

            database = AppDatabase.getInstance(this);
            sosDAO = database.sosDAO();
            recyclerAdapter();
            lokasiSOS = sosDAO.getAllSOS();
            lokasiSOS.observe(this, new Observer<List<SOS>>() {
                @Override
                public void onChanged(@Nullable List<SOS> sos) {
                    listSOS = sos;
                    for (int i = 0; i < sos.size(); i++){
                        //Double lat = Double.valueOf(sos.get(i).lat);
                        //Double lng = Double.valueOf(sos.get(i).lng);
                        //Point destination = Point.fromLngLat(lng, lat);
                        //ambilrute(i, origin, destination);
                        if (i == (sos.size()-1)){
                            Toast.makeText(SOSActivity.this, "Perhitungan Selesai", Toast.LENGTH_SHORT).show();
                        }
                    }
                    adapter.setJarak(arrayJarak);
                    adapter.setLokasi(sos);
                }
            });
        }catch (Exception e){

        }

    }

    private void recyclerAdapter() {
        try {
            RecyclerView recyclerView = findViewById(R.id.recyclerSOS);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);

        }catch (Exception e){

        }
    }
    private void ambilrute(int index, Point origin, Point destination){
        try {
            NavigationRoute.builder(SOSActivity.this)
                    .accessToken(getString(R.string.accesToken))
                    .origin(origin)
                    .destination(destination)
                    .build()
                    .getRoute(new Callback<DirectionsResponse>() {
                        @Override
                        public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                            DirectionsRoute currentRoute = response.body().routes().get(0);
                            jarak = currentRoute.distance();
                            arrayJarak[index] = currentRoute.distance();
                           // Toast.makeText(SOSActivity.this, String.valueOf(arrayJarak[index]), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<DirectionsResponse> call, Throwable t) {

                        }
                    });
        }catch (Exception e){

        }
    }
}