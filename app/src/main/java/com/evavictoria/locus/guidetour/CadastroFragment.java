package com.evavictoria.locus.guidetour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.evavictoria.locus.guidetour.databinding.FragmentCadastroBinding;
import com.evavictoria.locus.guidetour.model.Usuario;
import com.evavictoria.locus.guidetour.viewmodel.CadastroViewModel;

public class CadastroFragment extends Fragment {

    FragmentCadastroBinding binding;
    CadastroViewModel viewModel;
    Usuario usuario;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CadastroViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentCadastroBinding.bind(view);
        binding.buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = new Usuario();
                usuario.setNome(binding.editTextNomeCadastro.getText().toString());
                usuario.setEmail(binding.editTextEmailCadastro.getText().toString());
                usuario.setSenha(binding.editTextSenhaCadastro.getText().toString());
                boolean saida = viewModel.cadastrarUsuario(usuario);
                if(saida == true) {
                    NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                    navController.navigate(R.id.mainFragment);
                }

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false);
    }
}