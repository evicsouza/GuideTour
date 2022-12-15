package com.evavictoria.locus.guidetour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.evavictoria.locus.guidetour.databinding.FragmentRotasBinding;
import com.evavictoria.locus.guidetour.model.PontoTuristico;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;
import com.evavictoria.locus.guidetour.views.PontoTuristicoAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class RotasFragment extends Fragment {

    FragmentRotasBinding binding;
    ArrayList<PontoTuristico> pontosTuristicosList;
    PontoTuristicoAdapter pontoTuristicoAdapter;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRotasBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // guideTourRepository = new GuideTourRepository();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("pontosTuristicos");
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        pontosTuristicosList = new ArrayList<>();
        pontoTuristicoAdapter = new PontoTuristicoAdapter(getActivity(), guideTourRepository.listarDados());
//        Toast.makeText(getActivity(), "msg1", Toast.LENGTH_LONG).show();
        binding.recyclerView.setAdapter(pontoTuristicoAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                   // String s = dataSnapshot.getValue(String.class);
                    PontoTuristico p = dataSnapshot.getValue(PontoTuristico.class);
//                    PontoTuristico p = new PontoTuristico();
//                    p.setNome(s);
//                    p.setDescricao(s);
                    PontoTuristico p =  dataSnapshot.getValue(PontoTuristico.class);
    //                String n = "oi";
                    pontosTuristicosList.add(p);
                    Toast.makeText(getActivity(), "pegou", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}