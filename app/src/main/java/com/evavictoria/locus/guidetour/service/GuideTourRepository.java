package com.evavictoria.locus.guidetour.service;

import static android.icu.text.DisplayContext.LENGTH_SHORT;
import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.evavictoria.locus.guidetour.MainActivity;
import com.evavictoria.locus.guidetour.model.ColecaoFirebase;
import com.evavictoria.locus.guidetour.model.PontoTuristico;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuideTourRepository {

    private static GuideTourRepository guideTourRepository;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

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
    public void recuperarDados(){
        db.collection("pontosTuristicos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }


    private GuideTourRepository() {
    }


}
