package br.com.fiap.fiapdelivery.controller;
 
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;    
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
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
 
import br.com.fiap.fiapdelivery.model.Usuario;
import br.com.fiap.fiapdelivery.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
 
 
@RestController
@RequestMapping("usuario")
@Slf4j
@Tag(name = "Usuários")
public class UsuarioController {
   
 
    @Autowired // Injeção de Dependência
    UsuarioRepository repository;


    // ========== GET(Listar Usuarios) ============
    @GetMapping
    public List<Usuario> index(){
        return repository.findAll();
    }
 
 
    // ========== POST(Cadastrar Usuario) ============
    @PostMapping
    @ResponseStatus(CREATED)
    public Usuario create(@RequestBody @Valid Usuario usuario){
        log.info("Usuario Cadastrado {}", usuario);
        return repository.save(usuario);
    }
 
 
    // ========== GET(Detalhar Usuario) ============
    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        log.info("buscando usuario com id {}", id);
 
            return repository
                            .findById(id)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }
 
    // ========== DELETE (Excluir Usuario) ============
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Usuario apagado {}.", id);
 
        verificarSeUsuarioExiste(id);
        repository.deleteById(id);
                   
    }
 
 
    // ========== PUT (Atualizar Usuario) ============
    @PutMapping({"id"})
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario){
        log.info("Atualizando usuario {} para {}", id, usuario);
 
        verificarSeUsuarioExiste(id);
        usuario.setId(id);
        return repository.save(usuario);
 
    }
 



  // ==== MÉTODO VERIFICAR SE USUARIO EXISTE ========
 private void verificarSeUsuarioExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                            NOT_FOUND,
                                            "Não existe usuario com o ID informado.")
                            );
    }
}