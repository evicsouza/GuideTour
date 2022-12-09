package com.evavictoria.locus.guidetour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.evavictoria.locus.guidetour.databinding.FragmentRotasBinding;
import com.evavictoria.locus.guidetour.viewmodel.RotasViewModel;


public class RotasFragment extends Fragment {

    FragmentRotasBinding binding;
    RotasViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentRotasBinding.bind(view);
        // viewModel.recuperarDados();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RotasViewModel.class);
        viewModel.recuperarDados().observe(this, pontoTuristicos -> {
            binding.nomePontoTuristicoRotas.setText(viewModel.retornaNome());
            binding.descricaoPontoTuristicoRotas.setText(viewModel.retornaDescricao());
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rotas, container, false);
    }
}