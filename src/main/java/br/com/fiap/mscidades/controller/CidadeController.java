package br.com.fiap.mscidades.controller;

import br.com.fiap.mscidades.model.Cidade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;

@RestController
public class CidadeController {


    private List<Cidade> cidade = Arrays.asList(
            new Cidade(1, "Campinas", "Brasil", "Campinas é próximo de SP."),
            new Cidade(2, "Florianópolis", "Brasil", "Floripa tem lindas praias"),
            new Cidade(3, "Porto Alegre", "Brasil", "Porto Alegre é muito fria no inverno")
    );

    @GetMapping("/cidades")
    private List<Cidade>listarCidades(){
        return cidade;
    }

    @GetMapping("/cidade/{id}")
    public Cidade getCidade(@PathVariable int id) {
        return cidade.stream()
                .filter(cidade -> cidade.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
