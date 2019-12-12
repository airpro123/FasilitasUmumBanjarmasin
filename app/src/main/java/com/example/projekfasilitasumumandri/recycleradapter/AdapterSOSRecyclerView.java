package com.example.projekfasilitasumumandri.recycleradapter;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projekfasilitasumumandri.MapActivity;
import com.example.projekfasilitasumumandri.R;
import com.example.projekfasilitasumumandri.SOSActivity;
import com.example.projekfasilitasumumandri.SimActivity;
import com.example.projekfasilitasumumandri.database.AppDatabase;
import com.example.projekfasilitasumumandri.database.dbJarak.Jarak;
import com.example.projekfasilitasumumandri.database.dbJarak.JarakDAO;
import com.example.projekfasilitasumumandri.database.dbLokasi.Lokasi;
import com.example.projekfasilitasumumandri.database.dbLokasi.LokasiDAO;
import com.example.projekfasilitasumumandri.database.dbSOS.SOS;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterSOSRecyclerView extends RecyclerView.Adapter<AdapterSOSRecyclerView.LokasiHolder> {
    private List<SOS> sos = new ArrayList<>();
    private List<Double> listJarak = new ArrayList<>();
    private Double[] arrayJarak = new Double[100];
    private Context mContext;

    Double jarak;

    public AdapterSOSRecyclerView(Context ctx, Double jarak){
        this.mContext = ctx;
        this.jarak = jarak;
    }

    public AdapterSOSRecyclerView() {

    }

    @NonNull
    @Override
    public LokasiHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sos, parent, false);

        return new LokasiHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LokasiHolder holder, int position) {
        SOS currentLokasi = sos.get(position);
        String alamat = currentLokasi.namaLokasi;
        String[] pisah = alamat.split("-");
        if (pisah.length>1){
            holder.tvnama.setText(pisah[0]);
            holder.tvalamat.setText(pisah[1]);
        }else{
            holder.tvnama.setText(pisah[0]);
        }
       // holder.tvjarak.setText(String.valueOf(arrayJarak[position]));
        holder.telepon = currentLokasi.telepon;
    }

    public void setLokasi(List<SOS> sos){
        this.sos = sos;
        notifyDataSetChanged();
    }

    public void setListJarak(List<Double> listJarak){
        this.listJarak = listJarak;
        notifyDataSetChanged();
    }

    public void setJarak(Double[] arrayJarak){
        this.arrayJarak = arrayJarak;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return sos.size();
    }

    class LokasiHolder extends RecyclerView.ViewHolder{
        private TextView tvnama;
        private TextView tvalamat;
        private TextView tvjarak;
        private ImageView iv;
        private String lat;
        private String lng;
        private String telepon;
        private String kategori;

        public LokasiHolder(View itemview){
            super(itemview);
            tvnama = itemview.findViewById(R.id.txt_nama_lokasi);
            tvalamat = itemview.findViewById(R.id.txt_alamat_lokasi);
            tvjarak = itemview.findViewById(R.id.txt_jarak_lokasi);
            iv = itemview.findViewById(R.id.iv_panggil);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context ctx = v.getContext();
                    Intent callIntent =new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:"+telepon));
                    ctx.startActivity(callIntent);
                }
            });
        }
    }
}
