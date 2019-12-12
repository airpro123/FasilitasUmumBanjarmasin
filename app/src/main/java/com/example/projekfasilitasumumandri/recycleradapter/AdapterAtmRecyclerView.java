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

import java.util.ArrayList;
import java.util.List;

public class AdapterAtmRecyclerView extends RecyclerView.Adapter<AdapterAtmRecyclerView.AtmHolder> {

    private List<String> lokasi = new ArrayList<>();
    private Activity mContext;

    @NonNull
    @Override
    public AtmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lokasi, parent, false);

        return new AtmHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AtmHolder holder, int position) {
        String currentLokasi = lokasi.get(position);
        holder.namaAlamat.setText(currentLokasi);
    }

    public void setLokasi(List<String> lokasi){
        this.lokasi = lokasi;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lokasi.size();
    }

    class AtmHolder extends RecyclerView.ViewHolder {
        private TextView namaAlamat;
        private String lat;
        private String lng;
        private String kategori;

        public AtmHolder(@NonNull View itemView) {
            super(itemView);
            namaAlamat = itemView.findViewById(R.id.txt_lokasi);
            namaAlamat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context ctx = view.getContext();
                    String nama = namaAlamat.getText().toString();
                    Intent i = new Intent(ctx, MapActivity.class);
                    i.putExtra("kategori", "atm");
                    i.putExtra("bank", nama);
                    ctx.startActivity(i);
                }
            });
        }
    }
}

