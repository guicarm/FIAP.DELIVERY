package br.com.fiap.fiapdelivery.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.fiap.fiapdelivery.validation.TipoUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "{usuario.nome.notblank}")
    @Size(min = 3, max = 255, message = "{usuario.nome.size}")
    private String nome;

    @NotBlank(message = "{usuario.nome.notblank}")
    @Size(min = 3, max = 255, message = "{usuario.nome.size}")
    private String sobrenome;

    @NotBlank(message = "{usuario.email.notblank}")
    @Email(message = "{usuario.email.email}")
    private String email;

    @NotBlank(message = "{usuario.senha.notblank}")
    private String senha;

    @NotBlank(message = "{usuario.end_cep.notblank}")
    private String end_cep;

    @NotNull(message = "{usuario.end_numero.notnull}")
    private Integer end_numero;

    private String end_comp;

    @TipoUsuario
    private String tipo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("usuario")
    private List<Pedido> pedidos;
}
