package com.isidro.ejercicio4.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.isidro.ejercicio4.entity.ClienteEntity;
import com.isidro.ejercicio4.service.IClienteService;

@Controller
// @RequestMapping("/*")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	// Página principal
	@GetMapping("/")
	public String home() {
		return "redirect:/clientes";
	}

	@GetMapping("/clientes")
	public String mostrarTodos(Model modelAndView) {

		// ClienteEntity cliente = new ClienteEntity((long) 1, "Isidro", "Linares", new
		// Date(), "123456789");
		// clienteService.insertarGuardar(cliente);

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

	// Inserción de cliente
	@PostMapping("/crearCliente")
	public String crearCliente(@Valid @ModelAttribute("cliente") ClienteEntity nuevoCliente, Model model,
			BindingResult br) {

		// Insertar cliente
		clienteService.insertarGuardar(nuevoCliente);

		// Redirigir a listado
		return "redirect:/clientes";
	}

	// Eliminar por GET
	// ¿Habría que cambiarlo por POST? ¿Controlar CSRF? Pues ni idea.
	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable Long id) throws Exception {

		// ¿Control csrf?

		// Eliminar
		clienteService.eliminar(id);

		// Redirigir a listado
		return "redirect:/clientes";
	}

	// Buscar cliente
	@PostMapping("/buscarCliente")
	public String buscarCliente(Model model, @Param("keyword") String keyword) {

		// Mostrar por consola lo que está buscando
		System.out.println("Buscando: " + keyword);

		// Insertar cliente
		List<ClienteEntity> listaClientes = clienteService.buscarPorNombre(keyword);

		// Añadir a la vista el listado obtenido arriba
		model.addAttribute("listaClientes", listaClientes);

		// Redirigir a listado
		return "mostrarListaClientesView";
	}

}
