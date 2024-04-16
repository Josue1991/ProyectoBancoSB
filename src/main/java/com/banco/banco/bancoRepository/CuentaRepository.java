package com.banco.banco.bancoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.banco.banco.bancoEntity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
	
	@Query(value = "Select * FROM Cuenta c "
			+ " inner join Cliente cl on cl.id_cliente = c.id_cliente"
			+ " inner join Persona p on cl.id_persona = p.id_persona"
			+ " WHERE p.identificacion_persona = ?1",nativeQuery = true)
    Cuenta cuentaIdPersona(String identificacion);	
	
	@Query(value = "Select * FROM Cuenta c "
			+ " WHERE c.NUMERO_CUENTA = ?1",nativeQuery = true)
    Cuenta cuentaxNumeroCuenta(Integer numeroCuenta);	
		
}
