package com.springboot.jogos.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jogos.curso.entities.Empresa;
import com.springboot.jogos.curso.entities.Jogo;
import com.springboot.jogos.curso.entities.Plataforma;
import com.springboot.jogos.curso.repositories.JogoRepository;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public Jogo buscarPorId(Long id_jogo) {
        return jogoRepository.buscarPorId(id_jogo);
    }

    public Jogo buscarPorNome(String nome) {
        return jogoRepository.buscarPorNome(nome);
    }

    public String adicionarJogo(Long id_jogo, String nome, String ano, float preco, Plataforma plataforma, Empresa empresa) {
        Jogo jogoExistente = buscarPorNomeEPlataforma(nome, plataforma);

        if (jogoExistente == null) {
            Jogo novoJogo = new Jogo();
            novoJogo.setId_jogo(id_jogo);
            novoJogo.setNome(nome);
            novoJogo.setAno(ano);
            novoJogo.setPreco(preco);
            novoJogo.setPlataforma(plataforma);
            novoJogo.setEmpresa(empresa);
            jogoRepository.save(novoJogo);
            return "Jogo adicionado com sucesso.";
        } else {
            return "Erro: Jogo já cadastrado com esse nome e plataforma.";
        }
    }

    public String atualizarJogo(Long id_jogo, String nome, String ano, float preco, Plataforma plataforma, Empresa empresa) {
        Jogo jogoExistente = buscarPorId(id_jogo);

        if (jogoExistente != null) {
            jogoExistente.setNome(nome);
            jogoExistente.setAno(ano);
            jogoExistente.setPlataforma(plataforma);
            jogoExistente.setPreco(preco);
            jogoExistente.setEmpresa(empresa);
            jogoRepository.save(jogoExistente);
            return "Jogo atualizado com sucesso.";
        }
        return "Jogo não encontrado.";
    }

    public String deletarJogo(Long id_jogo) {
        Jogo jogoExistente = buscarPorId(id_jogo);

        if (jogoExistente != null) {
            jogoRepository.delete(jogoExistente);
            return "Jogo deletado com sucesso.";
        }

        return "Jogo não encontrado.";
    }

    public List<Jogo> listarJogos() {
        return jogoRepository.findAll();
    }

    private Jogo buscarPorNomeEPlataforma(String nome, Plataforma plataforma) {
        return jogoRepository.findByNomeAndPlataforma(nome, plataforma);
    }


    /*
    public Jogo buscarPorId(Long id_jogo) {
        return jogoRepository.findById(id_jogo).orElse(null);
    }

    public Jogo buscarPorNome(String nome) {
        return jogoRepository.findByNome(nome);
    } */
}
