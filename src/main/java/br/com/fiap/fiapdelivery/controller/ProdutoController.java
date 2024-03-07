package br.com.fiap.fiapdelivery.controller;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

       /*  for(Produto produto : repository){
            if(produto.id().equals(id))
                return ResponseEntity.ok(produto);
        }
       */
        var produtoEncontrado = getProdutoById(id);

        if (produtoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
       
        return ResponseEntity.ok(produtoEncontrado.get());
    }


    // ========== DELETE (Excluir Produto) ============
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("Produto apagado {}.", id);

        var produtoEncontrado = getProdutoById(id);
        
        if(produtoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
                            
                            
        repository.remove(produtoEncontrado.get());
        return ResponseEntity.noContent().build();
    }


    // ========== PUT (Atualizar Produto) ============
    @PutMapping({"id"})
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        log.info("Atualizando produto {} para {}", id, produto);

        var produtoEncontrado = getProdutoById(id);

        if(produtoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        var produtoAntigo = produtoEncontrado.get();

        var produtoNovo = new Produto(id, produto.titulo(), produto.descricao(), produto.ingrediente(), produto.imagem(), produto.valorProduto());

        repository.remove(produtoAntigo);
        repository.add(produtoNovo);

        return ResponseEntity.ok().build();
    }

    
    // ==== PRIVATE METHOD ========
    private Optional<Produto> getProdutoById(Long id) {
        var produtoEncontrado = repository
                                    .stream()
                                    .filter(p -> !p.id().equals(id))
                                    .findFirst();
        return produtoEncontrado;
    }









}
