package com.jogos.roberto.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jogos.roberto.curso.entities.Empresa;
import com.jogos.roberto.curso.entities.Jogo;
import com.jogos.roberto.curso.entities.Plataforma;
import com.jogos.roberto.curso.repositories.JogoRepository;

@Service
public class JogoService {
	
	@Autowired
    private EmpresaService empresaService;

    @Autowired
    private JogoRepository jogoRepository;

    public Jogo buscarPorId(Long id_jogo) {
        return jogoRepository.buscarPorId(id_jogo);
    }

    public Jogo buscarPorNome(String nome) {
        return jogoRepository.buscarPorNome(nome);
    }
    
    public String adicionarJogo(Long id_jogo, String nome, int quantidade, String ano, float preco, Plataforma plataforma, Empresa empresa) {
        Jogo jogoExistente = buscarPorNomeEPlataforma(nome, plataforma);

        if (jogoExistente == null) {
            Empresa empresaExistente = empresaService.buscarPorNome(empresa.getNome_empresa());

            if (empresaExistente != null) {
                Jogo novoJogo = new Jogo();
                novoJogo.setId_jogo(id_jogo);
                novoJogo.setNome(nome);
                novoJogo.setQuantidade(quantidade);
                novoJogo.setAno(ano);
                novoJogo.setPreco(preco);
                novoJogo.setPlataforma(plataforma);
                novoJogo.setEmpresa(empresaExistente);
                jogoRepository.save(novoJogo);

                return "Jogo adicionado com sucesso.";
            } else {
                return "Erro: Empresa não encontrada.";
            }
        } else {
            return "Erro: Jogo já cadastrado com esse nome e plataforma.";
        }
    }
    
    public String atualizarJogo(Long id_jogo, String nome, int quantidade, String ano, float preco, Plataforma plataforma, Empresa empresa) {
        Jogo jogoExistente = buscarPorId(id_jogo);

        if (jogoExistente != null) {
            jogoExistente.setNome(nome);
            jogoExistente.setQuantidade(quantidade);
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

    public Jogo buscarPorNomeEPlataforma(String nome, Plataforma plataforma) {
        return jogoRepository.findByNomeAndPlataforma(nome, plataforma);
    }
    
    @Autowired
    public void setEmpresaService(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @Autowired
    public void setJogoRepository(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }
}