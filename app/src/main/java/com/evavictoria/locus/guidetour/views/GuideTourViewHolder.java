package com.evavictoria.locus.guidetour.views;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evavictoria.locus.guidetour.R;
import com.evavictoria.locus.guidetour.model.PontoTuristico;

public class GuideTourViewHolder extends RecyclerView.ViewHolder {

    public static TextView categoria;
    public static TextView nome;
    public static TextView descricao;

    public GuideTourViewHolder(@NonNull View itemView) {
        super(itemView);
        categoria = (TextView)
                itemView.findViewById(R.id.categoriaPontoTuristico);
        nome = (TextView)
                itemView.findViewById(R.id.nomePontoTuristico);
        descricao = (TextView) itemView.findViewById(R.id.descricaoPontoTuristico);
    }

    public static void bind(PontoTuristico pontoTuristico) {
        //categoria.setText(pontoTuristico.getCategoria());
        nome.setText(pontoTuristico.getNome());
        descricao.setText(pontoTuristico.getDescricao());

    }
}
