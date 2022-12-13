package com.evavictoria.locus.guidetour.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.evavictoria.locus.guidetour.model.PontoTuristico;
import com.evavictoria.locus.guidetour.model.Usuario;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;

import java.util.List;

public class LoginViewModel extends ViewModel {

    static Usuario usuarioLogado;
    GuideTourRepository guideTourRepository = GuideTourRepository.getInstance();

    public boolean realizarLogin(Usuario u){
        List<Usuario> dados = recuperarDados();
        for(Usuario p: dados){
            if(p.getEmail().equals(u.getEmail()) && p.getSenha().equals(u.getSenha())){
                usuarioLogado = p;
                return true;
            }
        }
        return false;
    }
    public List<Usuario> recuperarDados(){
        //guideTourRepository.recuperarDados(pontoTuristico, PontoTuristico.class);
        return guideTourRepository.recuperarDadosUsuarios();
    }
    public Usuario getUsuario(){
        return this.usuarioLogado;
    }
}
