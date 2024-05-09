package br.com.fiap.fiapdelivery.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.fiapdelivery.model.Produto;
import br.com.fiap.fiapdelivery.repository.CardapioRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    CardapioRepository cardapioRepository;

    @Override
    public void run(String... args) throws Exception {
        cardapioRepository.saveAll(
        List.of(
            Produto.builder()
                .categoria("hamburguer")
                .nome("X-Fiapinho")
                .preco(40)
                .porcentagem_desconto(15)
                .ingredientes("Entre dois pães macios, com um suculento hambúrguer de carne, queijo derretido, alface fresca, tomate e maionese caseira.")
                .imagem("https://images.unsplash.com/photo-1550317138-10000687a72b?q=80&w=2120&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .build(),
            Produto.builder()
                .categoria("hamburguer")
                .nome("X-Ads")
                .preco(30)
                .porcentagem_desconto(5)
                .ingredientes("Entre dois pães macios, com um suculento hambúrguer de carne, queijo derretido, presunto, ovo estrelado, alface fresca, tomate e maionese caseira.")
                .imagem("https://images.unsplash.com/photo-1572802419224-296b0aeee0d9?q=80&w=2015&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .build(),
            Produto.builder()
                .categoria("pizza")
                .nome("Portuguesa")
                .preco(40)
                .porcentagem_desconto(0)
                .ingredientes("Coberta com molho de tomate, queijo mussarela, presunto, cebola, pimentão verde, ovos cozidos e azeitonas pretas, é uma explosão de sabor que agrada a todos os paladares.")
                .imagem("https://images.unsplash.com/photo-1613564834361-9436948817d1?q=80&w=1943&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .build()
        )
    );
    }
}