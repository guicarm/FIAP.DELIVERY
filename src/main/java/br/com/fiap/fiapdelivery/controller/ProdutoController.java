package br.com.fiap.fiapdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProdutoController {
    
    
    @RequestMapping(
        method = RequestMethod.GET,
        path = "/produto",
        produces = "application/json"
    )
    @ResponseBody   
    public String index(){
        return """
        [
            {
                "id": 1,
                "nome": "Burguer",
                "icone": "burguer.jpg"
            }
    
        ]
        """;
    }
}
