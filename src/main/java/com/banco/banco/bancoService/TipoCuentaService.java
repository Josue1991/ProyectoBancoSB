package com.banco.banco.bancoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.banco.bancoEntity.Persona;
import com.banco.banco.bancoEntity.TipoCuenta;
import com.banco.banco.bancoRepository.TipoCuentaRepository;

@Service
public class TipoCuentaService implements ITipoCuentaService {
	@Autowired
	private TipoCuentaRepository tipoCuentaRepository;

	@Override
	public TipoCuenta buscarTipoCuenta(String descripcion) {
		TipoCuenta tipo =  tipoCuentaRepository.tipoCuentaDescripcion(descripcion);
		return tipo;
	}

	@Override
	public List<TipoCuenta> listarTipoCuenta() {
		List<TipoCuenta> lista = new ArrayList<TipoCuenta>();
		lista = tipoCuentaRepository.findAll();
		return lista;
	}

	@Override
	public TipoCuenta crearTipoCuenta(TipoCuenta nueva) throws Exception {
		TipoCuenta elemento = new TipoCuenta();
		elemento = tipoCuentaRepository.save(nueva);
		return elemento;
	}

	@Override
	public Boolean editarTipoCuenta(TipoCuenta editar) throws Exception {
		boolean retorno = false;
		try {
			TipoCuenta depDB = tipoCuentaRepository.tipoCuentaDescripcion(editar.getDescripcion_tipoCuenta());
			if (Objects.nonNull(depDB)) {				
				if (Objects.nonNull(editar.getDescripcion_tipoCuenta()) && !"".equalsIgnoreCase(editar.getDescripcion_tipoCuenta())) {
					depDB.setDescripcion_tipoCuenta(editar.getDescripcion_tipoCuenta());
				}
				if (Objects.nonNull(editar.getEstado_tipoCuenta()) && editar.getEstado_tipoCuenta() > 0) {
					depDB.setEstado_tipoCuenta(editar.getEstado_tipoCuenta());
				}				
				tipoCuentaRepository.save(depDB);
				retorno = true;
			}
			else {
				throw new Exception("Existe mas de un registro con ese numero de cedula");
			}
		} catch (Exception e) {
			throw new Exception("No se pudo actualizar el Registro!!");
		}
		return retorno;		
	}

	@Override
	public Boolean eliminarTipoCuenta(String identificacionPersona) throws Exception {
		boolean retorno = false;
		try {
			TipoCuenta depDB = tipoCuentaRepository.tipoCuentaDescripcion(identificacionPersona);
			if (Objects.nonNull(depDB)) {
				depDB.setEstado_tipoCuenta(2);
				tipoCuentaRepository.save(depDB);
				retorno = true;
			}
			else {
				throw new Exception("Existe mas de un registro con ese numero de cedula");
			}
		} catch (Exception e) {
			throw new Exception("No se pudo eliminar el Registro!!");
		}
		return retorno;
	}
	

}
