package com.banco.banco.bancoController;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banco.banco.bancoEntity.FiltroHistorialDTO;
import com.banco.banco.bancoEntity.MovimientoDTO;
import com.banco.banco.bancoEntity.TipoCuenta;
import com.banco.banco.bancoEntity.TransaccionDTO;
import com.banco.banco.bancoService.MovimientoService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST,RequestMethod.DELETE })
@RequestMapping("api")
public class MovimientoController {

	@Autowired
	private MovimientoService movimientoService;

	@PostMapping("/movimiento/crear")
	public String crear(@RequestBody TransaccionDTO nuevo) {
		try {
			var retorno = movimientoService.crearMovimiento(nuevo);
			if(retorno == 0) {
				throw new RuntimeException("Saldo no Dispoonible");
			}
		} catch (Exception e) {
			throw new RuntimeException("No se puede insertar el registro");
		}
		return "El regisrtro se creo correctamente!!";
	}

	@PostMapping("/movimiento/historial")
	public List<MovimientoDTO> historial(@RequestBody FiltroHistorialDTO nuevo){
		List<MovimientoDTO> listaRetorno = new ArrayList<MovimientoDTO>();
		try {
			DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
			var fecha_Inicio = fechaHora.parse(nuevo.getFecha_Desde());
			var fecha_Fin = fechaHora.parse(nuevo.getFecha_Hasta());
						
			listaRetorno = movimientoService.buscarMovimientoFechas(nuevo.getCedula(),fecha_Inicio,fecha_Fin);
		} catch (Exception e) {
			throw new RuntimeException("No se encuentran registros");
		}
		return listaRetorno;
	}

}
