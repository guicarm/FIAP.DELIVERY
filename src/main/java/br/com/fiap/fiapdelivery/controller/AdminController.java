package br.com.fiap.fiapdelivery.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/admin")
@Tag(name = "Admin")
@CacheConfig(cacheNames = "cardapio")
public class AdminController {
    @Autowired
    CardapioRepository repository;

    // ========== POST (Cadastrar produto) ============
    @PostMapping("/produto")
    @ResponseStatus(CREATED)
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "API para cadastrar um produto no cardápio"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public Produto create(@RequestBody Produto produto){
        return repository.save(produto);
    }

    // ========== PUT (Atualizar produto via ID) ============
    @PutMapping("/produto/{id}")
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "API para atualizar um produto no cardápio"
    )
    public Produto update(@PathVariable Long id, @RequestBody Produto produto){
        verificarSeCategoriaExiste(id);
        produto.setId(id);

        return repository.save(produto);
    }

    // ========== DELETE (Excluir produto) ============
    @DeleteMapping("/produto/{id}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    @Operation(
        summary = "API para deletar um produto no cardápio"
    )
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
