package br.com.fiap.fiapdelivery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiapdelivery.model.Produto;
import br.com.fiap.fiapdelivery.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("produto")
@Slf4j
public class ProdutoController {
    

    @Autowired // Injeção de Dependência
    ProdutoRepository repository;
    
    // ========== GET(Listar Produtos) ============
    @GetMapping
    public List<Produto> index(){
        return repository.findAll();
    }


    // ========== POST(Cadastrar Produto) ============
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto create(@RequestBody Produto produto){
        log.info("Produto Cadastrado {}", produto);
        repository.save(produto);
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
         var produtoEncontrado = repository.findById(id);

        if (produtoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
       
        return ResponseEntity.ok(produtoEncontrado.get());
    }

    // ========== DELETE (Excluir Produto) ============
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("Produto apagado {}.", id);

        var produtoEncontrado = repository.findById(id);
        
        if(produtoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
                            
                            
        repository.delete(produtoEncontrado.get());
        return ResponseEntity.noContent().build();
    }

 
    // ========== PUT (Atualizar Produto) ============
    @PutMapping({"id"})
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        log.info("Atualizando produto {} para {}", id, produto);

        var produtoEncontrado = repository.findById(id);

        if(produtoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        var produtoNovo = new Produto();
        produtoNovo.setId(id);
        produtoNovo.setTitulo(produto.getTitulo());
        produtoNovo.setDescricao(produto.getDescricao());
        produtoNovo.setIngrediente(produto.getIngrediente());
        produtoNovo.setImagem(produto.getImagem());
        produtoNovo.setValorProduto(produto.getValorProduto());

        repository.save(produtoNovo);

        return ResponseEntity.ok().build();
    }

    
  /*   // ==== PRIVATE METHOD ========
    private Optional<Produto> getProdutoById(Long id) {
        var produtoEncontrado = repository
                                    .stream()
                                    .filter(p -> !p.id().equals(id))
                                    .findFirst();
        return produtoEncontrado;
    }
 */









}
