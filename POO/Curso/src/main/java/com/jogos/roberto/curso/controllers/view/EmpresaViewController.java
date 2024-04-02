package com.jogos.roberto.curso.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jogos.roberto.curso.entities.Empresa;
import com.jogos.roberto.curso.entities.Jogo;
import com.jogos.roberto.curso.services.EmpresaService;

import java.util.List;

@Controller
@RequestMapping("/empresas")
public class EmpresaViewController {
    
    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listar")
    public String listarEmpresas(Model model) {
        // Obter a lista de empresas do serviço
        List<Empresa> empresas = empresaService.listarEmpresas();

        // Adicionar a lista de empresas ao modelo
        model.addAttribute("empresas", empresas);

        // Retornar o nome do arquivo HTML (sem extensão)
        return "listar_empresas";
    }
    
    @GetMapping("/cadastrar-empresa")
    public String mostrarFormularioCadastrarEmpresa(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "cadastrar-empresa";
    }

    @PostMapping("/cadastrar-empresa")
    public String cadastrarEmpresa(@ModelAttribute("empresa") Empresa empresa) {
        empresaService.adicionarEmpresa(empresa.getNome_empresa());
        return "redirect:/empresas/listar";
    }
    
    @GetMapping("/cadastrar-jogos")
	 public String mostrarFormularioCadastrarJogoComEmpresas(Model model) {
	     List<Empresa> empresas = empresaService.listarEmpresas();
	     model.addAttribute("empresas", empresas);
	     model.addAttribute("jogo", new Jogo());
	     return "cadastrar-jogo";
	 }

}
