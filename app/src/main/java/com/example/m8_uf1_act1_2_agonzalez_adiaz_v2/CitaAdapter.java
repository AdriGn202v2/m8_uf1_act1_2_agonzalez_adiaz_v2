package com.example.m8_uf1_act1_2_agonzalez_adiaz_v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitaAdapter extends RecyclerView.Adapter<CitaAdapter.ViewHolder> {
    private List<Cita> citas;
    private ApiService apiService;

    public CitaAdapter(List<Cita> citas, ApiService apiService) {
        this.citas = citas;
        this.apiService = apiService;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cita, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cita cita = citas.get(position);
        holder.textNotari.setText("Notari: " + cita.getNotari());
        holder.textSala.setText("Sala: " + cita.getSala());
        holder.textDia.setText("Data: " + cita.getDia() + " - " + cita.getHora());

        // Passar 'holder' com a paràmetre
        holder.btnEliminar.setOnClickListener(v -> eliminarCita(holder, holder.getAdapterPosition()));
    }

    private void eliminarCita(ViewHolder holder, int position) {
        int citaId = citas.get(position).getId();
        apiService.deleteCita(citaId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    citas.remove(position);
                    notifyItemRemoved(position);
                    Toast.makeText(holder.itemView.getContext(), "Cita eliminada", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(holder.itemView.getContext(), "Error al eliminar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(holder.itemView.getContext(), "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return citas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNotari, textSala, textDia;
        Button btnEliminar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNotari = itemView.findViewById(R.id.textNotari);
            textSala = itemView.findViewById(R.id.textSala);
            textDia = itemView.findViewById(R.id.textDia);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);
        }
    }
}
