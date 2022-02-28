package com.banco.banco.bancoService;

import java.util.List;

import com.banco.banco.bancoEntity.TipoCuenta;

public interface ITipoCuentaService {
	List<TipoCuenta> listarTipoCuenta();
	TipoCuenta crearTipoCuenta(TipoCuenta nueva) throws Exception;
	Boolean editarTipoCuenta(TipoCuenta editar) throws Exception;
	TipoCuenta buscarTipoCuenta(String descripcion);
	Boolean eliminarTipoCuenta(String identificacionPersona) throws Exception;
}
