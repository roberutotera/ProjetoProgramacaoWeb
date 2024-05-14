package com.jogos.roberto.curso.controllers.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jogos.roberto.curso.services.FuncionarioService;


@Controller
public class FuncionarioViewController {
    
	@Autowired
	private FuncionarioService funcionarioService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/funclog")
    public String processLogin(@RequestParam("login") String login,
                               @RequestParam("senha") String senha,
                               RedirectAttributes redirectAttributes) {
        if (funcionarioService.autenticar(login, senha)) {
            // Credenciais válidas, redirecionar para a página inicial
            return "redirect:/menu";
        } else {
            // Credenciais inválidas, redirecionar de volta para o formulário de login com uma mensagem de erro
            redirectAttributes.addFlashAttribute("error", "Credenciais inválidas");
            return "redirect:/login";
        }
    }
    
    @GetMapping("/menu")
    public String showMenu() {
        return "menu";
    }
}
