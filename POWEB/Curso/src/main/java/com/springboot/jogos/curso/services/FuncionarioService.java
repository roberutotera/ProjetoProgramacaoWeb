package com.springboot.jogos.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jogos.curso.entities.Funcionario;
import com.springboot.jogos.curso.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
	private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public String adicionarFuncionario(Funcionario funcionario) {
        if (cpfExistente(funcionario.getCpf())) {
            return "CPF já está em uso por outro funcionário. Não é possível adicionar.";
        }
        funcionarioRepository.save(funcionario);
        return "Funcionário adicionado com sucesso.";
    }

    public Funcionario buscarFuncionario(Long id_usuario) {
        return funcionarioRepository.findById(id_usuario).orElse(null);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public String deletarFuncionario(Long id_usuario) {
        Funcionario funcionarioExistente = funcionarioRepository.findById(id_usuario).orElse(null);

        if (funcionarioExistente != null) {
            funcionarioRepository.delete(funcionarioExistente);
            return "Funcionário deletado com sucesso.";
        } else {
            return "Funcionário não deletado. Funcionário não encontrado.";
        }
    }

    private boolean cpfExistente(String cpf) {
        return funcionarioRepository.existsByCpf(cpf);
    }
}
