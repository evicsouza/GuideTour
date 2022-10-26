package com.evavictoria.locus.guidetour.controller;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.evavictoria.locus.guidetour.databinding.ActivityRestaurantesBinding;

public class RestaurantesActivity extends AppCompatActivity {

    ActivityRestaurantesBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}
