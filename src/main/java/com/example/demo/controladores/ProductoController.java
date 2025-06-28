package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelos.Producto;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.ProductoRepository;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping("/productos")
	public String getProducts(Model model) {
		List<Producto> listProductos = 
				productoRepository.findAll();
		model.addAttribute("productos", listProductos);
		return "productos/productList";
	}
	
	
}
