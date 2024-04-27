package br.com.fiap.fiapdelivery.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
@NotNull
public class Pedido {
    @Id
    private Long id;

    private String produtos;

    @Positive(message = "O total deve ser positivo")
    private Number total;

    private LocalDate data;
}
