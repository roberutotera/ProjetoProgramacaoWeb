package com.jogos.roberto.curso.controllers.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogos.roberto.curso.entities.Jogo;
import com.jogos.roberto.curso.services.EmpresaService;
import com.jogos.roberto.curso.services.JogoService;


@RestController
@RequestMapping("/api/v1/jogos")
public class JogoRestController {

    @Autowired
    private JogoService jogoService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listar")
    public List<Jogo> getAllJogos() {
        return jogoService.listarJogos();
    }

    @GetMapping("/buscar/{id_jogo}")
    public Jogo getJogoById(@PathVariable Long id_jogo) {
        return jogoService.buscarPorId(id_jogo);
    }

    
    @PostMapping("/adicionar")
    public String adicionarJogo(@RequestBody Jogo jogo) {
        return jogoService.adicionarJogo(jogo.getId_jogo(), jogo.getNome(), jogo.getQuantidade(), jogo.getAno(), jogo.getPreco(),
                jogo.getPlataforma(), jogo.getEmpresa());
    }
    
    @PutMapping("/atualizar/{id_jogo}")
    public String atualizarJogo(@PathVariable Long id_jogo, @RequestBody Jogo jogo) {
        return jogoService.atualizarJogo(id_jogo, jogo.getNome(), jogo.getQuantidade(), jogo.getAno(), jogo.getPreco(),
                jogo.getPlataforma(), jogo.getEmpresa());
    }

    @DeleteMapping("/deletar/{id_jogo}")
    public String deleteJogo(@PathVariable Long id_jogo) {
        return jogoService.deletarJogo(id_jogo);
    }
}