package com.evavictoria.locus.guidetour.viewmodel;

import androidx.lifecycle.ViewModel;

import com.evavictoria.locus.guidetour.model.Usuario;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;

public class CadastroViewModel extends ViewModel {

    Usuario usuario;
    GuideTourRepository guideTourRepository = GuideTourRepository.getInstance();


    public void cadastrarUsuario(Usuario usuario){
        guideTourRepository.salvarDadosCadastro(usuario);
    }
}
