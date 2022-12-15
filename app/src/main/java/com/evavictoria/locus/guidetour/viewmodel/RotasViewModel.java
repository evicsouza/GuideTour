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
/*
    private MutableLiveData<List<User>> users;
    public LiveData<List<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<List<User>>();
            loadUsers();
        }
        return users;
    }
*/
    // Handle business logic
    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
        //guideTourRepository.recuperarDadosPontosTuristicos();
    }

/*
    public MutableLiveData<List<PontoTuristico>> recuperarDados(){
        //guideTourRepository.recuperarDados(pontoTuristico, PontoTuristico.class);
        return guideTourRepository.recuperarDadosPontosTuristicos();
    }

    public String retornaNome(){
        return guideTourRepository.pontoTuristico.getNome();
    }
    public String retornaDescricao(){
        return guideTourRepository.pontoTuristico.getDescricao();
    }
*/
//    public void ler() {
//        Task<QuerySnapshot> docRef =
//                db.collection("pontosTuristicos")
//                        .get()
//                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                            @SuppressLint("RestrictedApi")
//                            @Override
//                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                                if (task.isSuccessful()) {
//                                    for (QueryDocumentSnapshot document : task.getResult()) {
//                                        Log.d(TAG, document.getId() + " => " + document.getData());
//                                    }
//                                } else {
//                                    Log.d(TAG, "Error getting documents: ", task.getException());
//                                }
//                            }
//                        });
//    }
}
