package com.evavictoria.locus.guidetour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.evavictoria.locus.guidetour.databinding.FragmentRestaurantesBinding;
import com.evavictoria.locus.guidetour.model.Restaurante;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;
import com.evavictoria.locus.guidetour.views.RestauranteAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class RestaurantesFragment extends Fragment {

    FragmentRestaurantesBinding binding;
    ArrayList<Restaurante> restaurantes;
    RestauranteAdapter restauranteAdapter;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    GuideTourRepository guideTourRepository;


    public static RestaurantesFragment newInstance(String param1, String param2) {
        RestaurantesFragment fragment = new RestaurantesFragment();
        Bundle args = new Bundle();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurantes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        guideTourRepository = new GuideTourRepository();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("restaurantes");
        binding.recyclerViewRestaurante.setLayoutManager(new LinearLayoutManager(getActivity()));
        restaurantes = new ArrayList<>();

        restauranteAdapter = new RestauranteAdapter(getActivity(), guideTourRepository.listarDadosRestaurantes());
//        Toast.makeText(getActivity(), "msg1", Toast.LENGTH_LONG).show();
        binding.recyclerViewRestaurante.setAdapter(restauranteAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    //String s = dataSnapshot.getValue(String.class);

                    Restaurante r = dataSnapshot.getValue(Restaurante.class);
//
                    restaurantes.add(r);
                    restauranteAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

}