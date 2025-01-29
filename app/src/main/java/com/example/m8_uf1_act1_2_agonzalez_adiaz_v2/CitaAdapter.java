package com.example.m8_uf1_act1_2_agonzalez_adiaz_v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CitaAdapter extends RecyclerView.Adapter<CitaAdapter.ViewHolder> {
    private List<Cita> cites;

    public CitaAdapter(List<Cita> cites) {
        this.cites = cites;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cita, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cita cita = cites.get(position);
        holder.textViewNotari.setText("Notari: " + cita.getNotari());
        holder.textViewSala.setText("Sala: " + cita.getSala());
        holder.textViewDia.setText("Data: " + cita.getDia());
        holder.textViewHora.setText("Hora: " + cita.getHora());
    }

    @Override
    public int getItemCount() {
        return cites.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNotari, textViewSala, textViewDia, textViewHora;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNotari = itemView.findViewById(R.id.textViewNotari);
            textViewSala = itemView.findViewById(R.id.textViewSala);
            textViewDia = itemView.findViewById(R.id.textViewDia);
            textViewHora = itemView.findViewById(R.id.textViewHora);
        }
    }
}
