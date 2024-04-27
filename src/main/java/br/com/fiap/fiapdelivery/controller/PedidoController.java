package br.com.fiap.fiapdelivery.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiapdelivery.model.Pedido;
import br.com.fiap.fiapdelivery.model.Produto;
import br.com.fiap.fiapdelivery.repository.PedidoRepository;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    PedidoRepository repository;

    @GetMapping
    public List<Pedido> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Pedido create(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }
}
