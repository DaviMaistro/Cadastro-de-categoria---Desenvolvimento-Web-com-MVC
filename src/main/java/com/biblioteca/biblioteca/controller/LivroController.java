package com.biblioteca.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.biblioteca.model.Livro;

@Controller
public class LivroController {

    private List<Livro> livros = new ArrayList<>();
    @GetMapping("/livros/novo")
    public String novo(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }
    @GetMapping("/livros/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        livros.remove(indice);
        return "redirect:/livros";
    }
    @PostMapping("/livros")
    public String cadastrar(@ModelAttribute Livro livro) {
        livros.add(livro);
        return "redirect:/livros";
    }

    @GetMapping("/livros")
    public String listar(Model model) {
        model.addAttribute("livros", livros);
        return "livros/lista";
    }
}