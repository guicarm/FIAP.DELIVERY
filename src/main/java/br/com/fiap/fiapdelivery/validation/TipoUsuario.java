package br.com.fiap.fiapdelivery.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TipoUsuarioValidator.class)
public @interface TipoUsuario {
    String message() default "Tipo do usuário não pode ser nulo.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
