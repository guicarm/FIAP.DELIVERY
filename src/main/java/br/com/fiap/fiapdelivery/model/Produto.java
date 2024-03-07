package br.com.fiap.fiapdelivery.model;

import java.util.Random;

// RECORD - Gera objetos imutáveis
//TODO List Ingrediente, Blob imagem?
public record Produto(Long id, String titulo, String descricao, String ingrediente, String imagem, double valorProduto) {

    public Produto(Long id, String titulo, String descricao, String ingrediente, String imagem, double valorProduto){
        var key = (id == null) ?  Math.abs(new Random().nextLong()) : id;
        this.id = key;
        this.titulo = titulo;
        this.descricao = descricao;
        this.ingrediente = ingrediente;
        this.imagem = imagem;
        this.valorProduto = valorProduto;
    }
   
}
