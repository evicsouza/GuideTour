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

    public void recuperarDados(ColecaoFirebase documento) {
        DocumentReference docRef = db.collection(documento.getCaminho().toString()).document(documento.getCaminho().toString());
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                PontoTuristico pontoTuristico = documentSnapshot.toObject(PontoTuristico.class);
            }
        });
    }


    private GuideTourRepository() {
    }


}
