package com.jogos.roberto.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jogos.roberto.curso.entities.Cliente;
import com.jogos.roberto.curso.repositories.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

    public String adicionarCliente(String login, String senha, String nome, String cpf, String endereco) {
    	Cliente clienteExistente = buscarPorCPF(cpf);
    	
    	if (clienteExistente == null) {
    		
    		Cliente novoCliente = new Cliente();

    		novoCliente.setLogin(login);
    		novoCliente.setSenha(senha);
    		novoCliente.setNome(nome);
    		novoCliente.setCpf(cpf);
    		novoCliente.setEndereco(endereco);
    		clienteRepository.save(novoCliente);
    		return "Cliente adicionado com sucesso.";
    	} else {
    		return "Cliente já cadastrado com esse CPF";
    	}
    }
    
    public String atualizarCliente (Long id_cliente, String login, String senha, String nome, String cpf, String endereco) {
    	Cliente clienteExistente = buscarPorID (id_cliente);
    	
    	if (clienteExistente != null) {
    		clienteExistente.setLogin(login);
    		clienteExistente.setSenha(senha);
    		clienteExistente.setNome(nome);
    		clienteExistente.setCpf(cpf);
    		clienteExistente.setEndereco(endereco);
    		clienteRepository.save(clienteExistente);
    		return "Cliente atualizado com sucesso!";
    	} else {
    		return "ID do Cliente não existe ou não foi encontrado!";
    	}
    }

    public String deletarCliente(Long id_cliente) {
        Cliente clienteExistente = clienteRepository.findById(id_cliente).orElse(null);

        if (clienteExistente != null) {
            clienteRepository.delete(clienteExistente);
            return "Cliente deletado com sucesso.";
        } else {
            return "Cliente não deletado. Cliente não encontrado.";
        }
    }
    
    public List<Cliente> listarClientes() {
    	return clienteRepository.listarClientes();
    }
    
    public Cliente buscarPorID(Long id_cliente) {
        return clienteRepository.buscarPorID(id_cliente);
    }
    
    public Cliente buscarPorCPF (String cpf) {
    	return clienteRepository.buscarPorCPF(cpf);
    }
    
}