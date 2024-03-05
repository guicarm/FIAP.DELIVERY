package br.com.fiap.fiapdelivery.controller;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiapdelivery.model.Produto;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    List<Produto> repository = new ArrayList<>();
    
    // ========== GET(Listar Produtos) ============
    @GetMapping
    public List<Produto> index(){
        return repository;
    }


    // ========== POST(Cadastrar Produto) ============
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto create(@RequestBody Produto produto){
        log.info("Produto Cadastrado {}", produto);
        repository.add(produto);
        return produto;
    }


    // ========== GET(Detalhar Produto) ============
    @GetMapping("{id}")
    public ResponseEntity<Produto> show(@PathVariable Long id){
        log.info("buscando produto com id {}", id);

        for(Produto produto : repository){
            if(produto.id().equals(id))
                return ResponseEntity.ok(produto);
        }
        
        return ResponseEntity.notFound().build(); 
    }


    // ========== GET(Detalhar Produto) ============










}
