package com.banco.banco.bancoController;

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

import com.banco.banco.bancoEntity.Persona;
import com.banco.banco.bancoEntity.TipoCuenta;
import com.banco.banco.bancoService.TipoCuentaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("api")
public class TipoCuentaController {
	
	@Autowired
	private TipoCuentaService tipoCuentaService;
	
	@PostMapping("/tipoCuenta/crear")
    public String crear(@RequestBody TipoCuenta nuevo)
    {		
		try {
			tipoCuentaService.crearTipoCuenta(nuevo);			
		}catch (Exception e) {
			throw new RuntimeException("No se puede insertar el registro"+nuevo.getDescripcion_tipoCuenta());
		}
        return "El regisrtro se creo correctamente!!";
    }


    @GetMapping("/tipoCuenta/listaTipo")
    public List<TipoCuenta> listaPersonas()
    {
    	List<TipoCuenta> listaRetorno = new ArrayList<TipoCuenta>();
    	try {
    		listaRetorno = tipoCuentaService.listarTipoCuenta();
		} catch (Exception e) {
			throw new RuntimeException("No se encuentran registros");
		}
        return listaRetorno;
    }
 
    @PutMapping("/tipoCuenta/editar")
    public String editar(@RequestBody TipoCuenta tipo)
    {
    	try {
    		tipoCuentaService.editarTipoCuenta(tipo);
		} catch (Exception e) {
			throw new RuntimeException("No se puede editar el registro "+ tipo.getDescripcion_tipoCuenta());
		}
        return "El Registro se modifico satisfactoriamente!!";
    }
 
    @DeleteMapping("/tipoCuenta/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id)
    {
        try {
        	tipoCuentaService.eliminarTipoCuenta(id);
		} catch (Exception e) {
			throw new RuntimeException("No se puede eliminar el registro"+id);
		}
        return "Se borro Correctamente";
    }
	

}
