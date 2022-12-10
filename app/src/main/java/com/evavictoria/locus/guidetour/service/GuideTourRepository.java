package com.evavictoria.locus.guidetour.service;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.evavictoria.locus.guidetour.model.PontoTuristico;
import com.evavictoria.locus.guidetour.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuideTourRepository {

    private static GuideTourRepository guideTourRepository;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static Task<QuerySnapshot> docRef;
    public static List<QueryDocumentSnapshot> docs;
    public PontoTuristico pontoTuristico;
    List<Usuario> usuarios = new ArrayList<>();


    public synchronized static GuideTourRepository getInstance() {
        if (guideTourRepository == null) {
            if (guideTourRepository == null) {
                guideTourRepository = new GuideTourRepository();
            }
        }
        return guideTourRepository;
    }

//    public void recuperarDados(ColecaoFirebase documento, Class classe) {
//       db.collection(documento.getCaminho().toString())
//               .get()
//               .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @SuppressLint("RestrictedApi")
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        ColecaoFirebase c = (ColecaoFirebase) document.toObject(classe);
//                    }
//                } else {
//                    Log.d(TAG, "Error getting documents: ", task.getException());
//                }
//            }
//        });
//    }
    public MutableLiveData<List<PontoTuristico>> recuperarDadosPontosTuristicos(){
        MutableLiveData<List<PontoTuristico>> dados = new MutableLiveData<List<PontoTuristico>>();
        List<PontoTuristico> pontosTuristicos = new ArrayList<>();
        docRef =
            db.collection("pontosTuristicos")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @SuppressLint("RestrictedApi")
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    PontoTuristico pt = new PontoTuristico();
                                    pt.setNome(document.getString("nome"));
                                    pt.setDescricao(document.getString("descricao"));
                                    pontoTuristico = pt;
                                   // pt.setCategoria((CategoriaPontoTuristico) document.get("categoria"));
                                    pontosTuristicos.add(pt);
                                    Log.d(TAG, document.getId() + " => " + document.getData());
                                }
                               dados.setValue(pontosTuristicos);
                            } else {
                                Log.d(TAG, "Error getting documents: ", task.getException());
                            }
                        }
                    });
        return dados;
    }


    public List<Usuario> recuperarDadosUsuarios(){
        MutableLiveData<List<Usuario>> dados = new MutableLiveData<List<Usuario>>();
        docRef =
                db.collection("usuarios")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @SuppressLint("RestrictedApi")
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Usuario u = new Usuario();
                                        u.setNome(document.getString("nome"));
                                        u.setEmail(document.getString("email"));
                                        u.setSenha(document.getString("senha"));

                                        usuarios.add(u);
                                        Log.d(TAG, document.getId() + " => " + document.getData());
                                    }
                                    dados.setValue(usuarios);
                                } else {
                                    Log.d(TAG, "Error getting documents: ", task.getException());
                                }
                            }
                        });
        return usuarios;
    }


    public void salvarDadosCadastro(Usuario usuario){
        db.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        usuarios.add(usuario);
                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

    }
    private GuideTourRepository() {
    }


}
