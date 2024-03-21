package br.com.fiap.fiapdelivery.model;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
// TODO Atributo Endereco endereco;
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUsuario;
    private String nome;
    private String email;
    private String senha;

}
