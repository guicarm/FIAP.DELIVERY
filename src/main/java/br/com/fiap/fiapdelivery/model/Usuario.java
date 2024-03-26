package br.com.fiap.fiapdelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
// TODO Atributo Endereco endereco;
public class Usuario {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "{usuario.nome.notblank}")
    @Size(min = 3, max = 255, message = "{usuario.nome.size}")
    private String nome;

    @NotBlank(message = "{usuario.email.notblank}")
    @Email(message = "{usuario.email.email}")
    private String email;

    @NotBlank(message = "{usuario.senha.notblank}")
    private String senha;

}
