//package com.evavictoria.locus.guidetour;
//
//import static org.junit.Assert.*;
//
//import com.evavictoria.locus.guidetour.model.Usuario;
//import com.evavictoria.locus.guidetour.service.GuideTourRepository;
//import com.evavictoria.locus.guidetour.viewmodel.CadastroViewModel;
//
//import org.junit.Before;
//import org.junit.Test;
//
//
//
//public class CadastroViewModelTest {
//
//    CadastroViewModel viewModel;
//    GuideTourRepository guideTourRepository = GuideTourRepository.getInstance();
//
//    @Before
//    public void init(){
//        viewModel = new CadastroViewModel();
//    }
//
//    @Test
//    public void verificaValidacaoStringNula(){
//        Usuario usuario = new Usuario();
//        usuario.setSenha("");
//        usuario.setEmail("");
//        usuario.setNome("");
//
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            viewModel.cadastrarUsuario(usuario);
//        });
//    }
//
//}
