package com.springboot.jogos.curso.services;

import com.springboot.jogos.curso.entities.Cliente;
import com.springboot.jogos.curso.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public String adicionarCliente(Cliente cliente) {
        if (cpfExistente(cliente.getCpf())) {
            return "CPF já está em uso por outro cliente. Não é possível adicionar.";
        }
        clienteRepository.save(cliente);
        return "Cliente adicionado com sucesso.";
    }

    public Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public String deletarCliente(Long id) {
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);

        if (clienteExistente != null) {
            clienteRepository.delete(clienteExistente);
            return "Cliente deletado com sucesso.";
        } else {
            return "Cliente não deletado. Cliente não encontrado.";
        }
    }

    private boolean cpfExistente(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }
}
