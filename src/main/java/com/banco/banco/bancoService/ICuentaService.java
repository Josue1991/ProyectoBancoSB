package com.banco.banco.bancoService;

import java.util.List;

import com.banco.banco.bancoEntity.Cuenta;
import com.banco.banco.bancoEntity.TransaccionDTO;

public interface ICuentaService {
	Cuenta buscarCuenta(String identificacionPersona);
	List<Cuenta> listarCuenta();
	Cuenta crearCuenta(Cuenta nueva) throws Exception;
	Cuenta editarCuenta(Cuenta editar, String identificacion) throws Exception;
	Boolean eliminarCuenta(int identificacionPersona) throws Exception;
	Cuenta buscarDatos(TransaccionDTO datos);
		
}
