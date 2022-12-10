package com.evavictoria.locus.guidetour.viewmodel;

import androidx.lifecycle.ViewModel;

import com.evavictoria.locus.guidetour.model.ColecaoFirebase;
import com.evavictoria.locus.guidetour.model.Usuario;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;

public class LoginViewModel extends ViewModel {
        Usuario usuario;
        GuideTourRepository guideTourRepository = GuideTourRepository.getInstance();
        ColecaoFirebase documento;

    public void recuperarDados(){
        //guideTourRepository.recuperarDados(pontoTuristico, PontoTuristico.class);
        //guideTourRepository.recuperarDadosPontosTuristicos();
    }
    public void registrar(String nome,String email, String senha){
        Usuario novo = new Usuario(nome, email, senha);
        DatabaseReference usersRef = ref.child("users");

        Map<String, User> users = new HashMap<>();
        users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));
        users.put("gracehop", new User("December 9, 1906", "Grace Hopper"));

        usersRef.setValueAsync(users);
    }
}
