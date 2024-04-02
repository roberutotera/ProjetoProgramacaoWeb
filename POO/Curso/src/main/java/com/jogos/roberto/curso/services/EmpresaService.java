package com.jogos.roberto.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jogos.roberto.curso.entities.Empresa;
import com.jogos.roberto.curso.repositories.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    public EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
    
    public String adicionarEmpresa(String nome_empresa) {
		Empresa nomeEmpresaExistente = empresaRepository.buscarPorNome(nome_empresa);

		if (nomeEmpresaExistente == null) {
			Empresa novoEmpresa = new Empresa(nome_empresa);
			empresaRepository.save(novoEmpresa);
			return "Empresa adicionada com sucesso.";
		} else {
			return "Empresa já cadastrada com esse nome.";
		}
	}

    public Empresa buscarEmpresa(Long id_empresa) {
        return empresaRepository.findById(id_empresa).orElse(null);
    }

    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    public String deletarEmpresa(Long id_empresa) {
        Empresa empresaExistente = empresaRepository.findById(id_empresa).orElse(null);

        if (empresaExistente != null) {
            empresaRepository.delete(empresaExistente);
            return "Empresa deletada com sucesso.";
        } else {
            return "Empresa não deletada. Empresa não encontrada.";
        }
    }
    
    public Empresa buscarPorNome(String nome_empresa) {
		return empresaRepository.buscarPorNome(nome_empresa);
	}
    
    public Empresa buscarPorId(Long id_empresa) {
    	return empresaRepository.findById(id_empresa).orElse(null);
	}
    
    @Autowired
    public void setEmpresaRepository(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
/*
    private boolean nomeEmpresaExistente(String nomeEmpresa) {
        return empresaRepository.existsByNomeEmpresa(nomeEmpresa);
    }*/
}
