package com.isidro.ejercicio4.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.isidro.ejercicio4.entity.ClienteEntity;
import com.isidro.ejercicio4.service.IClienteService;

@Controller
// @RequestMapping("/*")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public String mostrarTodos(Model modelAndView) {
		
		//ClienteEntity cliente = new ClienteEntity((long) 1, "Isidro", "Linares", new Date(), "123456789");
		//clienteService.insertarGuardar(cliente);
		
		// Obtener listado de clientes
		List<ClienteEntity> listaClientes = clienteService.mostrarTodo();
		
		// Añadir a la vista la "variable" clientes con el listado obtenido arriba
		modelAndView.addAttribute("listaClientes", listaClientes);
		
		// Vista mostrarListaClientesView.html
		return "mostrarListaClientesView";
	}
	
	// Formulario de nuevo cliente
	@GetMapping("/nuevo")
	public String nuevoCliente(Model modelAndView) {
				
		// Vista nuevoClienteView.html
		return "nuevoClienteView";
	}
	
	// Formulario crearCliente
	@PostMapping("/crearCliente")
	public String crearCliente(@Valid @ModelAttribute("cliente") ClienteEntity nuevoCliente, Model model, BindingResult br) {

		clienteService.insertarGuardar(nuevoCliente);

		return "redirect:/clientes";
	}
	
	@GetMapping(value = "/eliminar/{id}")
	public String deletePost(@PathVariable Long id) throws Exception {

		clienteService.eliminar(id);

		return "redirect:/clientes";
	}
	
}
