package com.banco.banco.bancoRepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banco.banco.bancoEntity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
	
	@Query(value = "Select * FROM Movimiento m "
	+ "inner join Cuenta c on c.id_cuenta = m.id_cuenta "
	+ "inner join Cliente cl on cl.id_cliente = c.id_cliente "
	+ "inner join Persona p on p.id_persona = cl.id_persona ",nativeQuery = true)
	List<Movimiento> historialMovimientosxCliente(Long id_Cuenta);
	
	@Query(value = "Select * FROM Movimiento m "
			+ "WHERE m.id_cuenta=?1",nativeQuery = true)
    List<Movimiento> historialMovimientos(Long id_Cuenta);
}
