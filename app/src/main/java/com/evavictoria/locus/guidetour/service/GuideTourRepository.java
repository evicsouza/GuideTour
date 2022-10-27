package com.evavictoria.locus.guidetour.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuideTourRepository {

    private static GuideTourRepository guideTourRepository;

    public synchronized static GuideTourRepository getInstance() {
        if (guideTourRepository == null) {
            if (guideTourRepository == null) {
                guideTourRepository = new GuideTourRepository();
            }
        }
        return guideTourRepository;
    }
    private GuideTourRepository() {

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl()
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

    }
}
