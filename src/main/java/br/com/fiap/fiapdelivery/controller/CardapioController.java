package br.com.fiap.fiapdelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiapdelivery.model.Produto;
import br.com.fiap.fiapdelivery.repository.CardapioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cardapio")
@Tag(name = "Cardápio")
public class CardapioController {
    @Autowired
    CardapioRepository repository;

    // ========== GET (Obter todos os produtos do cardápio) ============
    @GetMapping
    @Cacheable("cardapio")
    @Operation(
        summary = "API para listar todos os produtos"
    )
    public List<Produto> index(){
        return repository.findAll();
    }

    // ========== GET (Obter produto do cardápio via ID) ============
    @GetMapping("/{id}")
    @Operation(
        summary = "API para listar um produto via id"
    )
    public ResponseEntity<Produto> show(@PathVariable Long id){
        return repository
            .findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
