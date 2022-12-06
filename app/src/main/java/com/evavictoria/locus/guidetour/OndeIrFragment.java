package com.evavictoria.locus.guidetour;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evavictoria.locus.guidetour.databinding.FragmentOndeIrBinding;
import com.evavictoria.locus.guidetour.viewmodel.RotasViewModel;

public class OndeIrFragment extends Fragment {

    FragmentOndeIrBinding binding;
    RotasViewModel viewModel;

    public OndeIrFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentOndeIrBinding.bind(view);
       // viewModel.recuperarDados();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onde_ir, container, false);
    }

}