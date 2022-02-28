package com.banco.banco.bancoService;

import java.util.List;

import com.banco.banco.bancoEntity.Cliente;
import com.banco.banco.bancoEntity.Persona;

public interface IClienteService {
	List<Cliente> listarClientes();
	Cliente crearCliente(Cliente nueva) throws Exception;
	Boolean editarCliente(Cliente editar, String identificaion) throws Exception;
	Cliente buscarCliente(String identificacionPersona);
	Boolean eliminarCliente(String identificacionPersona) throws Exception;
}
