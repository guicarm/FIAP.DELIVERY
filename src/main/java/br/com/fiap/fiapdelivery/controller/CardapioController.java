package br.com.fiap.fiapdelivery.controller;

// import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiapdelivery.model.Produto;
import br.com.fiap.fiapdelivery.repository.CardapioRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cardapio")
@Slf4j
public class CardapioController {
    @Autowired
    CardapioRepository repository;

    // ========== GET (Obter todos os produtos do cardápio) ============
    @GetMapping
    public List<Produto> index(){
        return repository.findAll();
    }

    // ========== GET (Obter produto do cardápio via ID) ============
    @GetMapping("/{id}")
    public ResponseEntity<Produto> show(@PathVariable Long id){
        return repository
            .findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
