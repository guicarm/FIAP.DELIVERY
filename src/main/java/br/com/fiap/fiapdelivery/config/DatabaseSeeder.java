package br.com.fiap.fiapdelivery.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.fiapdelivery.model.Produto;
import br.com.fiap.fiapdelivery.repository.ProdutoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{
    
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {
        produtoRepository.saveAll(List.of(
            Produto.builder().id(1L).titulo("x-fiapinho").ingrediente("tomate, carne e pão").imagem("foto do hamburguer").valorProduto(30).build()
        ));
    }
}
