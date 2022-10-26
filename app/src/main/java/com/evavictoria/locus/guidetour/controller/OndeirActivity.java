package com.evavictoria.locus.guidetour.controller;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.evavictoria.locus.guidetour.databinding.ActivityOndeirBinding;

public class OndeirActivity extends AppCompatActivity {

    ActivityOndeirBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOndeirBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}
