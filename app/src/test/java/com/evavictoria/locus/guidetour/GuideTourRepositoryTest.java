package com.evavictoria.locus.guidetour;

import com.evavictoria.locus.guidetour.service.GuideTourRepository;

import org.junit.Before;
import org.junit.Test;

public class GuideTourRepositoryTest {

    GuideTourRepository guideTourRepository;

    @Before
    public void init(){
        guideTourRepository = new GuideTourRepository().getInstance();
    }

    @Test
    public void testaConexaoBanco(){

    }


}
