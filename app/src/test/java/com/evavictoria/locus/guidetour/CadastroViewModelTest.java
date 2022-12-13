package com.evavictoria.locus.guidetour;

import com.evavictoria.locus.guidetour.model.Usuario;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;
import com.evavictoria.locus.guidetour.viewmodel.CadastroViewModel;

import org.junit.Before;
import org.junit.Test;



public class CadastroViewModelTest {

    CadastroViewModel viewModel;
    GuideTourRepository guideTourRepository = GuideTourRepository.getInstance();

    @Before
    public void init(){
        viewModel = new CadastroViewModel();
    }

    @Test
    public void verificaValidacaoStringNula(){
        Usuario usuario = new Usuario();
        usuario.setSenha("OI123");
        usuario.setEmail("evavic.ifpe@gmail.com");
        usuario.setNome("Eva");

    }

}
