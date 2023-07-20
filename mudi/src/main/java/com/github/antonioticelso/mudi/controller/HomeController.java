package com.github.antonioticelso.mudi.controller;

import com.github.antonioticelso.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Xiome 8+");
        pedido.setUrlProduto("Xiome 8+ url");
        pedido.setUrlImagem("Xiome 8+ imagem");
        pedido.setDescricao("Xiome 8+ top");

        Arrays.asList(pedido);
//        module.addAttribute("nome", "Mundo");
        return "home";
    }

}
