package com.evavictoria.locus.guidetour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.evavictoria.locus.guidetour.controller.OndeirActivity;
import com.evavictoria.locus.guidetour.controller.RestaurantesActivity;
import com.evavictoria.locus.guidetour.controller.RotasActivity;
import com.evavictoria.locus.guidetour.controller.ServmedicosActivity;
import com.evavictoria.locus.guidetour.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.imageViewRotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botaoRotas(view);
            }
        });
        binding.imageViewOndeIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botaoOndeIr(view);
            }
        });
        binding.imageViewRestaurantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botaoRestaurantes(view);
            }
        });
        binding.imageViewServ2Medicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botaoServMedicos(view);
            }
        });
    }

    public void botaoRotas(View view) {
        Intent intent = new Intent(MainActivity.this, RotasActivity.class);
        startActivity(intent);
    }

    public void botaoRestaurantes(View view) {
        Intent intent = new Intent(MainActivity.this, RestaurantesActivity.class);
        startActivity(intent);
    }

    public void botaoOndeIr(View view) {
        Intent intent = new Intent(MainActivity.this, OndeirActivity.class);
        startActivity(intent);
    }

    public void botaoServMedicos(View view) {
        Intent intent = new Intent(MainActivity.this, ServmedicosActivity.class);
        startActivity(intent);
    }
}
