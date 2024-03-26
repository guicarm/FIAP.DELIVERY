package br.com.fiap.fiapdelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
//TODO List Ingrediente, Blob imagem?
@Entity
@Data
public class Produto{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{produto.titulo.notblank}")
    @Size(min = 3, max = 255, message = "{produto.titulo.size}")
    private String titulo;

    @NotBlank(message = "{produto.ingrediente.notblank}")
    private String ingrediente;

    private String imagem;

    @Positive(message = "{produto.valorProduto.positive")
    @NotBlank(message = "{produto.valorProduto.notblank}")
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
