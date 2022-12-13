package com.evavictoria.locus.guidetour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.evavictoria.locus.guidetour.model.PontoTuristico;
import com.evavictoria.locus.guidetour.service.ConfiguracaoFirebase;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;
import com.evavictoria.locus.guidetour.viewmodel.RotasViewModel;
import com.evavictoria.locus.guidetour.views.PontoTuristicoAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class RotasFragment extends Fragment {

   // FragmentRotasBinding binding;
    List<PontoTuristico> pontosTuristicosList;
    RecyclerView recyclerView;
    PontoTuristicoAdapter pontoTuristicoAdapter;
    DatabaseReference databaseReference;
    ConfiguracaoFirebase configuracaoFirebase = new ConfiguracaoFirebase();
    RotasViewModel viewModel;
    GuideTourRepository guideTourRepository = new GuideTourRepository().getInstance();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    //    binding = FragmentRotasBinding.bind(view);
        // viewModel.recuperarDados();

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        pontosTuristicosList = new ArrayList<>();
//        databaseReference.child("pontosTuristicos").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot dn:snapshot.getChildren()){
//                    PontoTuristico p = dn.getValue(PontoTuristico.class);
//                    pontosTuristicosList.add(p);
//                }
//                pontoTuristicoAdapter = new PontoTuristicoAdapter(pontosTuristicosList);
//                recyclerView.setAdapter(pontoTuristicoAdapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        viewModel = new ViewModelProvider(this).get(RotasViewModel.class);
//        viewModel.recuperarDados().observe(this, pontoTuristicos -> {
//            binding.nomePontoTuristicoRotas.setText(viewModel.retornaNome());
//            binding.descricaoPontoTuristicoRotas.setText(viewModel.retornaDescricao());
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rotas, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pontosTuristicosList = new ArrayList<>();
        configuracaoFirebase.getFirebaseDatabase().child("pontosTuristicos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dn:snapshot.getChildren()){
                    PontoTuristico p = dn.getValue(PontoTuristico.class);
                    pontosTuristicosList.add(p);
                }
                pontoTuristicoAdapter = new PontoTuristicoAdapter(pontosTuristicosList);
                recyclerView.setAdapter(pontoTuristicoAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}