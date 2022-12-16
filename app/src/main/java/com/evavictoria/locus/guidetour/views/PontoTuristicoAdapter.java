package com.evavictoria.locus.guidetour.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.evavictoria.locus.guidetour.MainActivity;
import com.evavictoria.locus.guidetour.R;
import com.evavictoria.locus.guidetour.model.PontoTuristico;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class PontoTuristicoAdapter extends RecyclerView.Adapter {

    private Context context;
    ArrayList<PontoTuristico> pontosTuristicos;

    private Activity activity;

    public PontoTuristicoAdapter(Context context, ArrayList<PontoTuristico> pontosTuristicos, Activity activity) {
        this.context = context;
        this.pontosTuristicos = pontosTuristicos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pontosturisticos, parent, false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass = (ViewHolderClass) holder;
        PontoTuristico pontoTuristico = pontosTuristicos.get(position);
        viewHolderClass.tvNome.setText(pontoTuristico.getNome());
        viewHolderClass.tvDescricao.setText(pontoTuristico.getDescricao());
        viewHolderClass.tvRota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTicket = new Intent(context, MainActivity.class);
                GuideTourRepository gui = new GuideTourRepository();
                gui.destino = new LatLng(Double.parseDouble(pontoTuristico.getLatitude()), Double.parseDouble(pontoTuristico.getLongitude()));
                NavController navController = Navigation.findNavController(activity,R.id.nav_host_fragment);
                navController.navigate(R.id.localizacaoFragment);

            }
        });
    }

    @Override
    public int getItemCount() {
        return pontosTuristicos.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView tvNome;
        TextView tvDescricao;
        Button tvRota;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            this.tvNome = itemView.findViewById(R.id.nomePontoTuristicoRotas);
            this.tvDescricao = itemView.findViewById(R.id.descricaoPontoTuristicoRotas);
            this.tvRota = itemView.findViewById(R.id.buttongerandoRota);
        }
    }
}