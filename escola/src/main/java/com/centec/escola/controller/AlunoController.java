package com.centec.escola.controller;

import com.centec.escola.model.Aluno;
import com.centec.escola.repository.AlunoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", alunoRepository.findAll());
        return "alunos-lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos-form";
    }

    @PostMapping
    public String salvar(@ModelAttribute("aluno") Aluno aluno) {
        alunoRepository.save(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado: " + id));
        model.addAttribute("aluno", aluno);
        return "alunos-form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return "redirect:/alunos";
    }
}
