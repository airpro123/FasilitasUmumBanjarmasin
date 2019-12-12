package com.example.projekfasilitasumumandri.recycleradapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projekfasilitasumumandri.MapActivity;
import com.example.projekfasilitasumumandri.R;
import com.example.projekfasilitasumumandri.database.dbLokasi.Lokasi;

import java.util.ArrayList;
import java.util.List;

public class AdapterLokasiRecyclerView extends RecyclerView.Adapter<AdapterLokasiRecyclerView.LokasiHolder> {
    private List<Lokasi> lokasi = new ArrayList<>();
    private Activity mContext;

    @NonNull
    @Override
    public LokasiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lokasi, parent, false);

        return new LokasiHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LokasiHolder holder, int position) {
        Lokasi currentLokasi = lokasi.get(position);
        holder.namaAlamat.setText(currentLokasi.getNamaLokasi());
        holder.lat      = currentLokasi.getLat();
        holder.lng      = currentLokasi.getLng();
        holder.kategori = currentLokasi.getKategori();

    }

    public void setLokasi(List<Lokasi> lokasi){
        this.lokasi = lokasi;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lokasi.size();
    }

    class LokasiHolder extends RecyclerView.ViewHolder{
        private TextView namaAlamat;
        private String lat;
        private String lng;
        private String kategori;

        public LokasiHolder(View itemview){
            super(itemview);
            namaAlamat = itemview.findViewById(R.id.txt_lokasi);
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context ctx = view.getContext();
                    Intent i = new Intent(ctx, MapActivity.class);
                    i.putExtra("alamat", namaAlamat.getText());
                    i.putExtra("lat", lat);
                    i.putExtra("lng", lng);
                    i.putExtra("kategori", kategori);
                    ctx.startActivity(i);

                }
            });
        }
    }


}

