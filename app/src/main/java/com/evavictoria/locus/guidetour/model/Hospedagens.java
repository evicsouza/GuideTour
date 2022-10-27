package com.evavictoria.locus.guidetour.model;

import android.location.Geocoder;

public class Hospedagens {

    String nome;
    String contato;
    String endereco;
    Geocoder localizacao;
    CategoriaHospedagens categoria;

    public Hospedagens(String nome, String contato, String endereco, Geocoder localizacao, CategoriaHospedagens categoria) {
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
        this.localizacao = localizacao;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Geocoder getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Geocoder localizacao) {
        this.localizacao = localizacao;
    }

    public CategoriaHospedagens getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaHospedagens categoria) {
        this.categoria = categoria;
    }
}
