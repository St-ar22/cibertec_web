package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.TipoDocumentoRepository;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("estudiantes", estudianteRepository.findAll());
		return "estudiante/lista";
	}
	
}









