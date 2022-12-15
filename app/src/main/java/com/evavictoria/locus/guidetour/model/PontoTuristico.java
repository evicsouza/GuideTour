package com.evavictoria.locus.guidetour.model;

//implements ColecaoFirebase
public class PontoTuristico {

   // CategoriaPontoTuristico categoria;
   public String descricao;
   public String nome;

    // Image foto;
   // Geocoder localizacao;
   // String caminho = "pontosTuristicos";


    public PontoTuristico() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

//    public Image getFoto() {
//        return foto;
//    }
//
//    public void setFoto(Image foto) {
//        this.foto = foto;
//    }
//
//    public Geocoder getLocalizacao() { return localizacao; }
//
//    public void setLocalizacao(Geocoder localizacao) {
//        this.localizacao = localizacao;
//    }

//    public CategoriaPontoTuristico getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(CategoriaPontoTuristico categoria) {
//        this.categoria = categoria;
//    }


//    @Override
//    public String getCaminho() {
//        return caminho;
//    }
}
