package com.springboot.jogos.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jogos.curso.entities.Jogo;
import com.springboot.jogos.curso.services.JogoService;

@RestController
@RequestMapping("/api/jogos")
public class JogosControllers {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public List<Jogo> getAllJogos() {
        return jogoService.listarJogos();
    }

    @GetMapping("/{id_jogo}")
    public Jogo getJogoById(@PathVariable Long id_jogo) {
        return jogoService.buscarPorId(id_jogo);
    }

    @PostMapping
    public String createJogo(@RequestBody Jogo jogo) {
        return jogoService.adicionarJogo(jogo.getId_jogo(), jogo.getNome(), jogo.getAno(), jogo.getPreco(),
                jogo.getPlataforma(), jogo.getEmpresa());
    }

    @PutMapping("/{id_jogo}")
    public String updateJogo(@PathVariable Long id_jogo, @RequestBody Jogo jogo) {
        return jogoService.atualizarJogo(Long id_jogo, jogo.getNome(), jogo.getAno(), jogo.getPreco(),
                jogo.getPlataforma(), jogo.getEmpresa());
    }

    @DeleteMapping("/{id_jogo}")
    public String deleteJogo(@PathVariable Long id_jogo) {
        return jogoService.deletarJogo(id_jogo);
    }
}
