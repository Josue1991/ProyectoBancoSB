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

import com.banco.banco.bancoEntity.Cuenta;
import com.banco.banco.bancoService.CuentaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("api")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;
	
	@PostMapping("/cuenta/crear")
    public String crear(@RequestBody Cuenta elemento)
    {		
		try {
			cuentaService.crearCuenta(elemento);			
		}catch (Exception e) {
			throw new RuntimeException("No se puede insertar el registro: "+elemento.getNumero_cuenta());
		}
        return "El regisrtro se creo correctamente!!";
    }


    @GetMapping("/cuenta/listaCuentas")
    public List<Cuenta> listaCuentas()
    {
    	List<Cuenta> listaRetorno = new ArrayList<Cuenta>();
    	try {
    		listaRetorno = cuentaService.listarCuenta();
		} catch (Exception e) {
			throw new RuntimeException("No se encuentran registros");
		}
        return listaRetorno;
    }
 
    @PutMapping("/cuenta/editar/{id}")
    public String editar(@RequestBody Cuenta cuentaEdit,@PathVariable("id") String id)
    {
    	try {
    		cuentaService.editarCuenta(cuentaEdit,id);
		} catch (Exception e) {
			throw new RuntimeException("No se puede editar el registro "+ cuentaEdit.getNumero_cuenta());
		}
        return "El Registro se modifico satisfactoriamente!!";
    }
 
    @DeleteMapping("/cuenta/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id)
    {
        try {
			cuentaService.eliminarCuenta(id);
		} catch (Exception e) {
			throw new RuntimeException("No se puede eliminar el registro"+id);
		}
        return "Eliminado Correctamente";
    }
}
