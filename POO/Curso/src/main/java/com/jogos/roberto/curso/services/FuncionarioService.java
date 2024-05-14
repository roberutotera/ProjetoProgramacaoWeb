package com.jogos.roberto.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jogos.roberto.curso.entities.Funcionario;
import com.jogos.roberto.curso.repositories.FuncionarioRepository;

import java.util.List;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

    public String adicionarFuncionario(String login, String senha, String nome, String cpf, String endereco) {
    	Funcionario funcionarioExistente = buscarPorCPF(cpf);
    	
    	if (funcionarioExistente == null) {
    		
    		Funcionario novoFuncionario = new Funcionario();

    		novoFuncionario.setLogin(login);
    		novoFuncionario.setSenha(senha);
    		novoFuncionario.setNome(nome);
    		novoFuncionario.setCpf(cpf);
    		novoFuncionario.setEndereco(endereco);
    		funcionarioRepository.save(novoFuncionario);
    		return "Funcionário adicionado com sucesso.";
    	} else {
    		return "Funcionário já cadastrado com esse CPF";
    	}
    }
     
    public String atualizarFuncionario (Long id_funcionario, String login, String senha, String nome, String cpf, String endereco) {
    	Funcionario funcionarioExistente = buscarPorID (id_funcionario);
    	
    	if (funcionarioExistente != null) {
    		funcionarioExistente.setLogin(login);
    		funcionarioExistente.setSenha(senha);
    		funcionarioExistente.setNome(nome);
    		funcionarioExistente.setCpf(cpf);
    		funcionarioExistente.setEndereco(endereco);
    		funcionarioRepository.save(funcionarioExistente);
    		return "Funcionario atualizado com sucesso!";
    	} else {
    		return "ID do Funcionario não existe ou não foi encontrado!";
    	}
    }
    
    public List<Funcionario> listarFuncionario() {
        return funcionarioRepository.findAll();
    }

    
    public String deletarFuncionario(Long id_funcionario) {
        Funcionario funcionarioExistente = funcionarioRepository.findById(id_funcionario).orElse(null);

        if (funcionarioExistente != null) {
            funcionarioRepository.delete(funcionarioExistente);
            return "Funcionário deletado com sucesso.";
        } else {
            return "Funcionário não deletado. Funcionário não encontrado.";
        }
    }
    
    public boolean autenticar(String login, String senha) {
        Funcionario funcionario = funcionarioRepository.buscarPorLogin(login);
        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            return true; // Credenciais válidas
        } else {
            return false; // Credenciais inválidas
        }
    }
    
    public Funcionario buscarPorID(Long id_funcionario) {
        return funcionarioRepository.buscarPorID(id_funcionario);
    }
    
    public Funcionario buscarPorCPF (String cpf) {
    	return funcionarioRepository.buscarPorCPF(cpf);
    }
    
    public Funcionario buscarPorLogin (String login) {
    	return funcionarioRepository.buscarPorLogin(login);
    }
    
    public Funcionario buscarPorSenha (String senha) {
    	return funcionarioRepository.buscarPorSenha(senha);
    }
    
}