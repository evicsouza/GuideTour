package com.evavictoria.locus.guidetour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.evavictoria.locus.guidetour.databinding.FragmentDescricaopontoBinding;
import com.evavictoria.locus.guidetour.model.PontoTuristico;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;
import com.evavictoria.locus.guidetour.viewmodel.DescricaoPontoTuristicoViewModel;
import com.evavictoria.locus.guidetour.views.GuideTourAdapter;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class DescricaopontoFragment extends Fragment {

    FragmentDescricaopontoBinding binding;
    DescricaoPontoTuristicoViewModel viewModel;
    private RecyclerView recyclerview;
    private List<PontoTuristico> mTelfoneFixo;
    private GuideTourAdapter guideTourAdapter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentDescricaopontoBinding.bind(view);
        buttonGerarRota();
    }

    public void buttonGerarRota(){
        binding.gerarRota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GuideTourRepository gui = new GuideTourRepository();
                gui.destino = new LatLng(-8.884173,-36.484673);
                NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                navController.navigate(R.id.localizacaoFragment);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descricaoponto, container, false);
    }


}