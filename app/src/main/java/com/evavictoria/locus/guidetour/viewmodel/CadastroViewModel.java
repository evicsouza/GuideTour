package com.evavictoria.locus.guidetour.viewmodel;

import androidx.lifecycle.ViewModel;

import com.evavictoria.locus.guidetour.model.Usuario;
import com.evavictoria.locus.guidetour.service.GuideTourRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroViewModel extends ViewModel {

    Usuario usuario;
    GuideTourRepository guideTourRepository = GuideTourRepository.getInstance();


    public boolean cadastrarUsuario(Usuario usuario){
        if(validarEmail(usuario.getEmail()) && usuario.getSenha() != null && usuario.getSenha().length() > 0 && validarNome(usuario.getNome())){
            guideTourRepository.salvarDadosCadastro(usuario);
            return true;
        }
        return false;
    }
    public boolean validarNome(String nome) {
        boolean valido = false;
        if (nome != null && nome.length() > 0) {
            if (nome.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)?$")) {
                valido = true;
            }
        }
        return valido;
    }
    public boolean validarEmail(String email) {
        boolean valido = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                valido = true;
            }
        }
        return valido;
    }
}