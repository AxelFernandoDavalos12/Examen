package com.cibertec.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.InterfaceService.IpersonaService;
import com.cibertec.modelo.Persona;



@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona>personas=service.listar();
		model.addAttribute("personas",personas);
		return "index";
	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona",new Persona());
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@Validated Persona p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{idEmpleado}")
	public String editar(@PathVariable int idEmpleado,  Model model) {
		Optional<Persona>persona=service.listarId(idEmpleado);
		model.addAttribute("persona",persona);
		return "form";
	}
	
	@GetMapping("/eliminar/{idEmpleado}")
	public String delete(@PathVariable int idEmpleado,  Model model) {
		service.delete(idEmpleado);
		return "redirect:/listar";
	}
}
