package com.isidro.ejercicio4.service;

import java.util.List;
import java.util.Optional;

import com.isidro.ejercicio4.entity.ClienteEntity;

public interface IClienteService {

	List<ClienteEntity> buscarPorNombre(String nombre);
	List<ClienteEntity> buscarPorApellidos(String apellidos);
	List<ClienteEntity> buscarPorNombreApellidos(String nombre, String apellidos);
	List<ClienteEntity> mostrarTodo();
	Optional<ClienteEntity> buscarPorDni(String dni);
	void insertarGuardar(ClienteEntity cliente);
	void eliminar(Long idCliente);
}
