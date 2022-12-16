package com.evavictoria.locus.guidetour.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evavictoria.locus.guidetour.R;
import com.evavictoria.locus.guidetour.model.Restaurante;

import java.util.ArrayList;

public class RestauranteAdapter extends RecyclerView.Adapter {

    private Context context;
    ArrayList<Restaurante> restaurantes;

    private Activity activity;

    public RestauranteAdapter(Context context, ArrayList<Restaurante> restaurantes) {
        this.context = context;
        this.restaurantes = restaurantes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_restaurantes, parent, false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass = (ViewHolderClass) holder;
        Restaurante restaurante = restaurantes.get(position);
        viewHolderClass.tvNome.setText(restaurante.getNome());
        viewHolderClass.tvEndereco.setText(restaurante.getEndereco());
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView tvNome;
        TextView tvEndereco;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            this.tvNome = itemView.findViewById(R.id.nomeRestaurante);
            this.tvEndereco = itemView.findViewById(R.id.enderecoRestaurante);
        }
    }
}