package com.isidro.ejercicio4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isidro.ejercicio4.entity.ClienteEntity;
import com.isidro.ejercicio4.service.ClienteServiceImpl;

@SpringBootApplication
public class Application implements CommandLineRunner {

	// @Autowired
	// ClienteServiceImpl clienteServicio;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		this.crearClientes();
		
		// Buscar cliente con X dni
		Optional<ClienteEntity> clienteDni = clienteServicio.buscarPorDni("987654321");
		// Mostrar en consola
		System.out.println( "Resultado por DNI: ");
		System.out.println( clienteDni.get().toString() );

		// Buscar clientes
		List<ClienteEntity> listaClientes = clienteServicio.mostrarTodo();
		// List<ClienteEntity> listaClientesNombre =
		// clienteServicio.buscarPorNombre("Isidro");
		// List<ClienteEntity> listaClientesApellidos =
		// clienteServicio.buscarPorApellidos("Linares");
		// List<ClienteEntity> listaClientesNombreApellidos =
		// clienteServicio.buscarPorNombreApellidos("Isidro", "Linares");

		// Mostrar por consola
		System.out.println("Bucle 1: ");
		for (ClienteEntity client : listaClientes) {
			System.out.println(client.toString());
		}

		System.out.println("Bucle 2: ");
		// Alternativa de bucle
		listaClientes.stream().forEach(client -> System.out.println(client.toString()));
	
		*/
	}

	/*private void crearClientes() {
		// Crear cliente
		ClienteEntity cliente = new ClienteEntity();
		cliente.setNombre("Isidro");
		cliente.setApellidos("Linares");
		cliente.setDni("123456789");
		// cliente.setFechaNacimiento(new Date(1990,12,30));
		// cliente.setFechaNacimiento(LocalDate.of(1990, 1, 15));

		// Crear cliente 2
		ClienteEntity cliente2 = new ClienteEntity();
		cliente2.setNombre("Isidro");
		cliente2.setApellidos("Camarena");
		cliente2.setDni("987654321");

		// Insertar clientes
		
		clienteServicio.insertarGuardar(cliente);
		clienteServicio.insertarGuardar(cliente2);
	}*/

}
