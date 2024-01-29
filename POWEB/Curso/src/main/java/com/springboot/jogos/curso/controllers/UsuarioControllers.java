package com.springboot.jogos.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jogos.curso.entities.Usuario;
import com.springboot.jogos.curso.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControllers {

    private UsuarioService usuarioService;

    @Autowired
    public void UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/buscar/{id_usuario}")
    public Usuario buscarUsuario(@PathVariable Long id_usuario) {
        return usuarioService.buscarUsuario(id_usuario);
    }

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("/deletar/{id_usuario}")
    public String deletarUsuario(@PathVariable Long id_usuario) {
        return usuarioService.deletarUsuario(id_usuario);
    }
}
