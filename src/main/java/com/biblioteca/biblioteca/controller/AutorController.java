package com.biblioteca.biblioteca.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.biblioteca.biblioteca.model.Autor;

@Controller
public class AutorController {

    private List<Autor> autores = new ArrayList<>();
    @GetMapping("/autores/novo")
    public String novo(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }
    @PostMapping("/autores")
    public String cadastrar(@ModelAttribute Autor autor) {
        autores.add(autor);
        return "redirect:/autores";
    }
    @GetMapping("/autores")
    public String listar(Model model) {
        model.addAttribute("autores", autores);
        return "autores/lista";
    }
}