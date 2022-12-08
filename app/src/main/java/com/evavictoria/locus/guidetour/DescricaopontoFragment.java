package com.evavictoria.locus.guidetour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.evavictoria.locus.guidetour.databinding.FragmentDescricaopontoBinding;
import com.evavictoria.locus.guidetour.model.PontoTuristico;
import com.evavictoria.locus.guidetour.viewmodel.DescricaoPontoTuristicoViewModel;
import com.evavictoria.locus.guidetour.views.GuideTourAdapter;

import java.util.List;

public class DescricaopontoFragment extends Fragment {

    FragmentDescricaopontoBinding binding;
    DescricaoPontoTuristicoViewModel viewModel;
    private RecyclerView recyclerview;
    private List<PontoTuristico> mTelfoneFixo;
    private GuideTourAdapter guideTourAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DescricaoPontoTuristicoViewModel.class);
        viewModel.recuperarDados().observe(this, pontoTuristicos -> {
            recyclerview.setAdapter(guideTourAdapter);
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentDescricaopontoBinding.bind(view);
        //recyclerview = (TextView) view.findViewById(R.id.descricaoPontoTuristico);
        binding.nomePontoTuristico.setText("Teste");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descricaoponto, container, false);
    }

//    private void carregarPontoTuristico() {
//        GuideTourAdapter<PontoTuristico, GuideTourViewHolder> adapter =
//                new FirebaseRecyclerAdapter<PontoTuristico, GuideTourViewHolder>(
//                PontoTuristico.class,
//                R.layout.fragment_descricaoponto,
//                GuideTourViewHolder.class, categoria) {
//            protected void populateViewHolder(GuideTourViewHolder itenViewHolder, PontoTuristico model, int position) {
//                itenViewHolder.categoria.setText(model.getCategoria());
//                itenViewHolder.nome.setText(model.getNome());
//                itenViewHolder.descricao.setText(model.getDescricao());
//            }
//        };
//        recyclerview.setAdapter(guideTourAdapter);

}