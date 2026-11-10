package com.biblioteca.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.biblioteca.model.Categoria;

@Controller
public class CategoriaController {

    private List<Categoria> categorias = new ArrayList<>();
    @GetMapping("/categorias/novo")
    public String novo(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }
    @PostMapping("/categorias")
    public String cadastrar(@ModelAttribute Categoria categoria) {
        categorias.add(categoria);
        return "redirect:/categorias";
    }
    @GetMapping("/categorias")
    public String listar(Model model) {
        model.addAttribute("categorias", categorias);
        return "categorias/lista";
    }
    @GetMapping("/categorias/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        categorias.remove(indice);
        return "redirect:/categorias";
    }
}