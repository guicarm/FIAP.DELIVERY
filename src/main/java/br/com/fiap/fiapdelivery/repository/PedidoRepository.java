package br.com.fiap.fiapdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.fiapdelivery.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
