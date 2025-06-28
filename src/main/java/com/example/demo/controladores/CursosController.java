package com.example.demo.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.Curso;
import com.example.demo.repository.CursoRepository;

@Controller
@RequestMapping("/cursos")
public class CursosController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping("/listar")
	public String list(Model model) {
		List<Curso> list = cursoRepository.findAll();
		model.addAttribute("cursos", list);
		return "cursos";
	}
	
	@GetMapping("/formulario")
	public String showRegister(Model model) {
		model.addAttribute("curso", new Curso());
		return "formulario";
	}
	
	@PostMapping("/registrar")
	public String register(Model model, Curso curso) {
		cursoRepository.save(curso);
		return "redirect:/cursos/listar";
	}
	
}
