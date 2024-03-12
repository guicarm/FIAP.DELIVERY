package br.com.fiap.fiapdelivery.controller;

// import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiapdelivery.model.Produto;
import br.com.fiap.fiapdelivery.repository.CardapioRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CardapioController {
    @Autowired
    CardapioRepository repository;

    // ========== GET (Obter todos os produtos do cardápio) ============
    @GetMapping("/cardapio")
    public List<Produto> index(){
        return repository.findAll();
    }

    // ========== GET (Obter s produto do cardápio via ID) ============
    @GetMapping("/cardapio/{id}")
    public ResponseEntity<Produto> show(@PathVariable Long id){
        var produtoEncontrado = repository.findById(id);

        if (produtoEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(produtoEncontrado.get());
    }

    // ========== POST (Cadastrar produto) ============
    @PostMapping("/admin/produto")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto create(@RequestBody Produto produto){
        repository.save(produto);

        return produto;
    }

    // ========== PUT (Atualizar produto via ID) ============
    @PutMapping("/admin/produto/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        var produtoEncontrado = repository.findById(id);

        if(produtoEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        var produtoNovo = new Produto();
        produtoNovo.setId(id);
        produtoNovo.setCategoria(produto.getCategoria());
        produtoNovo.setNome(produto.getNome());
        produtoNovo.setPreco(produto.getPreco());
        produtoNovo.setPorcentagem_desconto(produto.getPorcentagem_desconto());
        produtoNovo.setIngredientes(produto.getIngredientes());
        produtoNovo.setImagem(produto.getImagem());

        repository.save(produtoNovo);

        return ResponseEntity.ok().build();
    }

    // ========== DELETE (Excluir produto) ============
    @DeleteMapping("/admin/produto/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        var produtoEncontrado = repository.findById(id);

        if(produtoEncontrado.isEmpty()) return ResponseEntity.notFound().build();

        repository.delete(produtoEncontrado.get());

        return ResponseEntity.noContent().build();
    }

    // // ==== PRIVATE METHOD ========
    // private Optional<Produto> getProdutoById(Long id) {
    //     var produtoEncontrado =
    //         repository
    //             .stream()
    //             .filter(p -> p.id().equals(id))
    //             .findFirst();

    //     return produtoEncontrado;
    // }
}
