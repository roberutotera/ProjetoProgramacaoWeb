package com.springboot.jogos.curso.services;

import com.springboot.jogos.curso.entities.Empresa;
import com.springboot.jogos.curso.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public String adicionarEmpresa(Empresa empresa) {
        if (nomeEmpresaExistente(empresa.getNome_empresa())) {
            return "Nome da empresa já está em uso. Não é possível adicionar.";
        }
        empresaRepository.save(empresa);
        return "Empresa adicionada com sucesso.";
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

    private boolean nomeEmpresaExistente(String nomeEmpresa) {
        return empresaRepository.existsByNomeEmpresa(nomeEmpresa);
    }
}
