package br.com.fiap.fiapdelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//TODO List Ingrediente, Blob imagem?
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @NotNull(message = "{produto.valorProduto.notnull}")
    private double valorProduto;

   

}