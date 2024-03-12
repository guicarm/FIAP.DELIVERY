package br.com.fiap.fiapdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.fiapdelivery.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
