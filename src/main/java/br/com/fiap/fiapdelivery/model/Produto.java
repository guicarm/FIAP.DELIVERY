package br.com.fiap.fiapdelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoria;
    private String nome;
    private Number preco;
    private Number porcentagem_desconto;
    private String ingredientes;
    private String imagem;
}
