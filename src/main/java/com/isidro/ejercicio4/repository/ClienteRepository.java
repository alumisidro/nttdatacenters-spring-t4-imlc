package com.isidro.ejercicio4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isidro.ejercicio4.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	// Ejemplo de búsquedas: findBy{propiedad} => findByNombre

	// Buscar por nombre
	public List<ClienteEntity> findByNombre(String nombre);
	// Buscar por apellidos
	public List<ClienteEntity> findByApellidos(String apellidos);
	// Buscar por nombre y apellidos
	public List<ClienteEntity> findByNombreAndApellidos(String nombre, String apellidos);
	// Obtener el primer cliente con X dni
	public Optional<ClienteEntity> findFirstByDni(String dni);
}
