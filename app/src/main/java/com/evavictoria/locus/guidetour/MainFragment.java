package com.evavictoria.locus.guidetour;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.evavictoria.locus.guidetour.databinding.FragmentMainBinding;
import com.evavictoria.locus.guidetour.viewmodel.LoginViewModel;

public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    LoginViewModel loginViewModel = new LoginViewModel();

   @Override
    public void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding = FragmentMainBinding.bind(view);

        binding.imageButtonRotas.setOnClickListener(Navigation
                .createNavigateOnClickListener(R.id.rotasFragment, null));
        binding.imageButtonRestaurantes2.setOnClickListener(Navigation
                .createNavigateOnClickListener(R.id.descricaopontoFragment, null));
        binding.imageButtonServMedicos.setOnClickListener(Navigation
                .createNavigateOnClickListener(R.id.servMedicosFragment, null));
        binding.imageButtonHospedagem.setOnClickListener(Navigation
                .createNavigateOnClickListener(R.id.loginFragment, null));
        if(loginViewModel.getUsuario() != null) {
            binding.textView8.setText(loginViewModel.getUsuario().getNome());
        }
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//    public void botaoRotas(View view) {
//        binding.imageButtonRotas.setOnClickListener(Navigation
//                .createNavigateOnClickListener(R.id.FragmentRotas, null));
//    }
}