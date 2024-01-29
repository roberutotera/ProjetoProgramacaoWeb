package com.springboot.jogos.curso.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jogos.curso.entities.Empresa;
import com.springboot.jogos.curso.entities.Plataforma;

@RestController
@RequestMapping("/api/jogos")
public class JogosControllers {

    @GetMapping
    public String ListarJogos(){
        return "Lista de jogos";
    }

    @GetMapping("/{id_jogo}")
    public String buscarJogoById(){
        return "Jogo : ";
    }

    @PostMapping
    public String adicionarLivro(Long id_jogo, String nome, Plataforma plataforma, Empresa empresa, float preco, int quantidade) {
		return "Jogo adicionado.";
    }

    @PutMapping("/{id_jogo}")
    public String atualizarLivro(Long id_jogo, String nome, Plataforma plataforma, Empresa empresa, float preco, int quantidade) {
		return "Jogo atualizado.";
    }

    @DeleteMapping("/{id_jogo}")
    public String deletarJogo(@PathVariable("id_jogo") Long id_jogo) {
		return "Jogo deletado.";
    }
}
