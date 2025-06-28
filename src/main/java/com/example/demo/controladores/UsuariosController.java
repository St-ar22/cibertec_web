package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelos.Usuario;

@Controller
public class UsuariosController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/registro")
	public String showRegister(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}
	
	@PostMapping("/registro")
	public String validarDatos(@ModelAttribute Usuario usuario, 
			Model model) {
		String nombre = usuario.getNombre();
		String correo = usuario.getEmail();
		String clave = usuario.getPassword();
		
		if(correo.equals("jorge@gmail.com") && clave.equals("123456")) {
			model.addAttribute("nombre", nombre);
			model.addAttribute("usuario", usuario);
			return "redirect:/cursos?nombre="+nombre;
		} else {
			model.addAttribute("mensaje", "Verifique sus datos");
			return "registro";
		}
		
	}
	
	
	
}
