package br.com.fiap.fiapdelivery.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiapdelivery.model.Pedido;
import br.com.fiap.fiapdelivery.model.Produto;
import br.com.fiap.fiapdelivery.model.Usuario;
import br.com.fiap.fiapdelivery.repository.PedidoRepository;
import br.com.fiap.fiapdelivery.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pedidos")
@Tag(name = "Pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    // ========== GET (Obter todos os pedidos do usuário) ============
    @GetMapping
    @Operation(
        summary = "API para listar todos pedidos realizados"
    )
    public List<Pedido> index(){
        return pedidoRepository.findAll();
    }

    /// ========== POST (Obter todos os pedidos do usuário) ============
    @PostMapping
    @Operation(
        summary = "API para cadastrar um pedido"
    )
    public Pedido create(@RequestBody Pedido pedido){
        return pedidoRepository.save(pedido);
    }
}