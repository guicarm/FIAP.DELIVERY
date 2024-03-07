package br.com.fiap.fiapdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class FiapdeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiapdeliveryApplication.class, args);
	}
	
	@RequestMapping
	@ResponseBody
	public String home(){
		return "FIAP Delivery";
	}
}
