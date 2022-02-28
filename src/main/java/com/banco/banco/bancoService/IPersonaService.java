package com.banco.banco.bancoService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.banco.banco.bancoEntity.Persona;

public interface IPersonaService {
	
	Persona buscarPersona(String identificacionPersona);
	List<Persona> listarPersonas();
	Persona crearPersona(Persona nueva) throws Exception;
	Boolean editarPersona(Persona editar, String identificacion) throws Exception;
	Boolean eliminarPersona(String identificacionPersona) throws Exception;
	
}
