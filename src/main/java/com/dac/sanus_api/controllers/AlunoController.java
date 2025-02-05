package com.dac.sanus_api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dac.sanus_api.entidades.usuarios.Aluno;
import com.dac.sanus_api.services.AlunoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;


    @GetMapping("/novo")
    public String inserirAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "novo-aluno";
    }

    @PostMapping
    public String inserirAluno(@ModelAttribute Aluno aluno, Model model) {
        alunoService.salvarAluno(aluno);
        return "redirect:/alunos/list/page";
    }

    @GetMapping("/editar/{id}")
    public String obterAluno(@PathVariable Long id, Model model) {
        var aluno = alunoService.buscarAlunoPorId(id);
        if (aluno.isEmpty()) {
            return "erro";
        }
        model.addAttribute("aluno", aluno.get());
        return "novo-aluno";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable Long id, Model model) {
        alunoService.deletarConta(id);
        return "redirect:/alunos/list/page";
    }

    @GetMapping("/list/page")
    public String listarAlunosPage(
        @PageableDefault(page = 0, size = 3) Pageable page,
        Model model) {

            Page<Aluno> alunos = alunoService.buscarTodosAlunos(page);
            model.addAttribute("alunos", alunos);
            return "lista-alunos";
    }

}
