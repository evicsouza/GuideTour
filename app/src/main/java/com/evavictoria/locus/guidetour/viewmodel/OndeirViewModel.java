package com.evavictoria.locus.guidetour.viewmodel;

import androidx.lifecycle.ViewModel;

import com.evavictoria.locus.guidetour.model.ColecaoFirebase;
import com.evavictoria.locus.guidetour.model.PontoTuristico;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;

public class OndeirViewModel extends ViewModel {

    PontoTuristico pontoTuristico;
    GuideTourRepository guideTourRepository;
    ColecaoFirebase documento;


    public void recuperarDados(){
        guideTourRepository.recuperarDados(documento);
    }
}
