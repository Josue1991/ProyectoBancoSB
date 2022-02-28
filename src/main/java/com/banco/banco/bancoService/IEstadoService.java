package com.banco.banco.bancoService;

import java.util.List;

import com.banco.banco.bancoEntity.Estado;

public interface IEstadoService {
	Estado buscarEstado(String descripcion);
	List<Estado> listarEstados();
	Estado crearEstado(Estado nueva) throws Exception;
	Boolean editarEstado(Estado editar) throws Exception;
	Boolean eliminarEstado(String descripcion) throws Exception;
}
