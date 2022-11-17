package com.evavictoria.locus.guidetour.model;

import android.location.Geocoder;

public class Restaurante {

    String nome;
    CategoriaRestaurantes categoria;
    String endereco;
    Geocoder localizacao;

    public Restaurante(String nome, CategoriaRestaurantes categoria, String endereco, Geocoder localizacao) {
        this.nome = nome;
        this.categoria = categoria;
        this.endereco = endereco;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaRestaurantes getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaRestaurantes categoria) {
        this.categoria = categoria;
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
}
