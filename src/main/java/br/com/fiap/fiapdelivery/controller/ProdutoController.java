package br.com.fiap.fiapdelivery.controller;
 
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;    
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
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
import org.springframework.web.server.ResponseStatusException;
 
import br.com.fiap.fiapdelivery.model.Produto;
import br.com.fiap.fiapdelivery.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
 
 
@RestController
@RequestMapping("produto")
@Slf4j
@CacheConfig
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
    @ResponseStatus(CREATED)
    @CacheEvict(allEntries = true)
    public Produto create(@RequestBody Produto produto){
        log.info("Produto Cadastrado {}", produto);
        return repository.save(produto);
    }
 
 
    // ========== GET(Detalhar Produto) ============
    @GetMapping("{id}")
    public ResponseEntity<Produto> show(@PathVariable Long id){
        log.info("buscando produto com id {}", id);
 
            return repository
                            .findById(id)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
 
        /*
         var produtoEncontrado = repository.findById(id);
 
        if (produtoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
       
        return ResponseEntity.ok(produtoEncontrado.get());
         */
    }
 
    // ========== DELETE (Excluir Produto) ============
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    @CacheEvict(allEntries = true)
    public void destroy(@PathVariable Long id){
        log.info("Produto apagado {}.", id);
 
        verificarSeProdutoExiste(id);
        repository.deleteById(id);
                   
    }
 
 
    // ========== PUT (Atualizar Produto) ============
    @PutMapping({"id"})
    @CacheEvict(allEntries = true)
    public Produto update(@PathVariable Long id, @RequestBody Produto produto){
        log.info("Atualizando produto {} para {}", id, produto);
 
        verificarSeProdutoExiste(id);
        produto.setId(id);
        return repository.save(produto);
 
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
 
  // ==== MÉTODO VERIFICAR SE CATEGORIA EXISTE ========
 private void verificarSeProdutoExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                            NOT_FOUND,
                                            "Não existe produto com o ID informado.")
                            );
    }
 
 
 
 
 
 
 
}
 