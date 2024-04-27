package br.com.fiap.fiapdelivery.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
// import org.slf4j.LoggerFactory;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.fiapdelivery.model.Produto;
import br.com.fiap.fiapdelivery.repository.CardapioRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    CardapioRepository repository;

    // ========== POST (Cadastrar produto) ============
    @PostMapping("/produto")
    @ResponseStatus(CREATED)
    public Produto create(@RequestBody Produto produto){
        return repository.save(produto);
    }

    // ========== PUT (Atualizar produto via ID) ============
    @PutMapping("/produto/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto){
        verificarSeCategoriaExiste(id);

        var produtoNovo = new Produto();
        produtoNovo.setId(id);
        produtoNovo.setCategoria(produto.getCategoria());
        produtoNovo.setNome(produto.getNome());
        produtoNovo.setPreco(produto.getPreco());
        produtoNovo.setPorcentagem_desconto(produto.getPorcentagem_desconto());
        produtoNovo.setIngredientes(produto.getIngredientes());
        produtoNovo.setImagem(produto.getImagem());

        return repository.save(produtoNovo);
    }

    // ========== DELETE (Excluir produto) ============
    @DeleteMapping("/produto/{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        verificarSeCategoriaExiste(id);

        repository.deleteById(id);
    }

    // ========== PRIVATE METHOD ========
    private void verificarSeCategoriaExiste(Long id) {
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Produto referente ao id não encontrado."));
    }
}
