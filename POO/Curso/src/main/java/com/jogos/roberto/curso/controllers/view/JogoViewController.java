package com.jogos.roberto.curso.controllers.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jogos.roberto.curso.entities.Empresa;
import com.jogos.roberto.curso.entities.Jogo;
import com.jogos.roberto.curso.services.EmpresaService;
import com.jogos.roberto.curso.services.JogoService;

@Controller
@RequestMapping("/biblioteca")
public class JogoViewController {
	
	@Autowired
	private JogoService jogoService;
	 
	@Autowired
	private EmpresaService empresaService;

	@GetMapping("/listas")
	public String getAllGames(Model model) {
	    model.addAttribute("jogos", jogoService.listarJogos());
	    return "games"; // Retorna o nome do arquivo HTML (sem extensão)
	}
	 
	@GetMapping("/cadastrar-jogos")
	public String mostrarFormularioCadastrarJogoComEmpresas(Model model) {
	    List<Empresa> empresas = empresaService.listarEmpresas();
	    model.addAttribute("empresas", empresas);
	    model.addAttribute("jogo", new Jogo());
	    return "cadastrar-jogo";
	}
	    
	@PostMapping("/cadastrar-jogo")
	public String cadastrarJogo(@ModelAttribute Jogo jogo, @RequestParam("idEmpresa") Long id_empresa) {
	    Empresa empresa = empresaService.buscarPorId(id_empresa);
	    if (empresa != null) {
	        jogo.setEmpresa(empresa);
	        jogoService.adicionarJogo(jogo.getId_jogo(), jogo.getNome(), jogo.getQuantidade(), jogo.getAno(), jogo.getPreco(), jogo.getPlataforma(), jogo.getEmpresa());
	        return "redirect:/biblioteca/listas"; // Redirecionar para a página de listagem de jogos após o cadastro
	    } else {
	        // Se a empresa não for encontrada, trate o erro adequadamente
	        return "redirect:/biblioteca/cadastrar-jogo?error=Empresa não encontrada";
	    }
	}
}
