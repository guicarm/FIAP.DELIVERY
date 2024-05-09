package br.com.fiap.fiapdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.fiapdelivery.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}

