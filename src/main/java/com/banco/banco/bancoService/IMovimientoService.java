package com.banco.banco.bancoService;

import java.util.Date;
import java.util.List;

import com.banco.banco.bancoEntity.MovimientoDTO;
import com.banco.banco.bancoEntity.TransaccionDTO;

public interface IMovimientoService {
	int crearMovimiento(TransaccionDTO nuevo) throws Exception;
	List<MovimientoDTO> buscarMovimientoFechas(Long identificacionPersona, Date FechaDesde, Date FechaHasta);
}
