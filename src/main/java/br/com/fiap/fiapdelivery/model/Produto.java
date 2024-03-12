package br.com.fiap.fiapdelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
//TODO List Ingrediente, Blob imagem?
@Entity
@Data
public class Produto{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private String ingrediente;
    private String imagem;
    private double valorProduto;

   

}





/*Long id, String titulo, String descricao, String ingrediente, String imagem, double valorProduto) {

    public Produto(Long id, String titulo, String descricao, String ingrediente, String imagem, double valorProduto){
        var key = (id == null) ?  Math.abs(new Random().nextLong()) : id;
        this.id = key;
        this.titulo = titulo;
        this.descricao = descricao;
        this.ingrediente = ingrediente;
        this.imagem = imagem;
        this.valorProduto = valorProduto;
    }
   */
