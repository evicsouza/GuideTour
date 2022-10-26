package com.evavictoria.locus.guidetour.controller;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.evavictoria.locus.guidetour.databinding.ActivityRotasBinding;

public class RotasActivity extends AppCompatActivity {

    ActivityRotasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRotasBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }
}
