package com.isidro.ejercicio4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isidro.ejercicio4.entity.ClienteEntity;
import com.isidro.ejercicio4.repository.ClienteRepository;

/**
 * Indicar que es un servicio
 *
 * Ejemplo: Indicar que es un destornillador para que se meta en la caja de
 * herramientas
 */
@Service
public class ClienteServiceImpl implements IClienteService {

	/**
	 * Se podría usar aquí el @Autowired para indicar que se va a usar ese
	 * destornillador, pero por buenas prácticas se ha hecho en el constructor.
	 * 
	 * Se puede omitir el constructor si se usa el @Autowired.
	 */
	ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	// Buscar por nombre
	@Override
	public List<ClienteEntity> buscarPorNombre(String nombre) {
		return this.clienteRepository.findByNombre(nombre);
	}

	// Buscar por apellidos
	@Override
	public List<ClienteEntity> buscarPorApellidos(String apellidos) {
		return this.clienteRepository.findByApellidos(apellidos);
	}

	// Buscar por nombre y apellidos
	@Override
	public List<ClienteEntity> buscarPorNombreApellidos(String nombre, String apellidos) {
		return this.clienteRepository.findByNombreAndApellidos(nombre, apellidos);
	}

	// Insertar
	@Override
	public void insertarGuardar(ClienteEntity cliente) {

		this.clienteRepository.save(cliente);

	}

	// Eliminar
	@Override
	public void eliminar(Long id) {

		this.clienteRepository.deleteById(id);

	}

	// Obtener todos los clientes
	@Override
	public List<ClienteEntity> mostrarTodo() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Optional<ClienteEntity> buscarPorDni(String dni) {
		return this.clienteRepository.findFirstByDni(dni);
	}

}
