package com.evavictoria.locus.guidetour.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.evavictoria.locus.guidetour.model.ColecaoFirebase;
import com.evavictoria.locus.guidetour.model.PontoTuristico;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;
import com.google.firebase.firestore.auth.User;

import java.util.List;

public class RotasViewModel extends ViewModel {

    PontoTuristico pontoTuristico;
    GuideTourRepository guideTourRepository = GuideTourRepository.getInstance();
    ColecaoFirebase documento;

    private MutableLiveData<List<User>> users;
    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<List<User>>();
            loadUsers();
        }
        return users;
    }

    // Handle business logic
    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
        guideTourRepository.recuperarDadosPontosTuristicos();
    }


    public void recuperarDados(){

        //guideTourRepository.recuperarDados(pontoTuristico, PontoTuristico.class);
        guideTourRepository.recuperarDadosPontosTuristicos();
    }
}
