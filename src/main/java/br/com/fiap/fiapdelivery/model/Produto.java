package br.com.fiap.fiapdelivery.model;

import java.util.Random;

// RECORD - Gera objetos imutáveis
//TODO List Ingrediente, Blob imagem?
public record Produto(Long id, String titulo, String descricao, String ingrediente, String imagem, double valorProduto) {

    public Produto(Long id, String titulo, String descricao, String ingrediente, String imagem, double valorProduto){
        this.id = Math.abs(new Random().nextLong());
        this.titulo = titulo;
        this.descricao = descricao;
        this.ingrediente = ingrediente;
        this.imagem = imagem;
        this.valorProduto = valorProduto;
    }
   
}
