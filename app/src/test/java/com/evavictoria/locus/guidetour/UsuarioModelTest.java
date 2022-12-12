package com.evavictoria.locus.guidetour;

import static org.junit.Assert.assertEquals;

import com.evavictoria.locus.guidetour.model.Usuario;

import org.junit.Before;
import org.junit.Test;

public class UsuarioModelTest {

    Usuario usuario;

    @Before
    public void init(){
        usuario = new Usuario();
    }

    @Test
    public void setName(){
        usuario.setNome("Eva");
        assertEquals(usuario.getNome(), "Eva");
    }
}
