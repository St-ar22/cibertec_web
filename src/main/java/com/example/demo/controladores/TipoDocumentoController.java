package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelos.TipoDocumento;
import com.example.demo.repository.TipoDocumentoRepository;

@Controller
@RequestMapping("/tipodocumento")
public class TipoDocumentoController {
	
	@Autowired
	private TipoDocumentoRepository tipoRepository;
	
	@GetMapping
	public String listarTipoDocumento(Model model) {
		List<TipoDocumento> documentList = tipoRepository.findAll();
		model.addAttribute("tiposDocumento", documentList);
		return "tipodocumento/listar";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("tipoDocumento", new TipoDocumento());
		return "tipodocumento/formulario";
	}
	
	@PostMapping("/guardar")
	public String guardarDocumento(@ModelAttribute TipoDocumento tipoDocumento) {
		tipoRepository.save(tipoDocumento);
		return "redirect:/tipodocumento";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarEditar(@PathVariable int id, Model model) {
		TipoDocumento documento = tipoRepository.findById(id).orElseThrow();
		model.addAttribute("tipoDocumento", documento);
		return "tipodocumento/formulario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String guardarDocumento(@PathVariable int id) {
		tipoRepository.deleteById(id);
		return "redirect:/tipodocumento";
	}
	
	
}









