package com.evavictoria.locus.guidetour.viewmodel;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.evavictoria.locus.guidetour.model.Usuario;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;

public class CadastroViewModel extends ViewModel {

    Usuario usuario;
    GuideTourRepository guideTourRepository = GuideTourRepository.getInstance();


    @SuppressLint("RestrictedApi")
    public void cadastrarUsuario(Usuario usuario){
        try {
            if(usuario.getNome() != "" || usuario.getSenha() != " "|| usuario.getEmail() != " ") {
                guideTourRepository.salvarDadosCadastro(usuario);
            }
        }catch (Exception IllegalArgumentException){
            Log.w(TAG, "Usuário inválido", IllegalArgumentException);
        }
    }
}
