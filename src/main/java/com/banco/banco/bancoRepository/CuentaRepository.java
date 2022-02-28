package com.banco.banco.bancoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.banco.banco.bancoEntity.Cliente;
import com.banco.banco.bancoEntity.Cuenta;

import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
	
	@Query(value = "Select * FROM Cuenta c "
			+ " inner join Cliente cl on cl.id_cliente = c.id_cliente"
			+ " inner join Persona p on cl.id_persona = p.id_persona"
			+ " WHERE p.identificacion_persona = ?1",nativeQuery = true)
    Cuenta cuentaIdPersona(String identificacion);	
	
	@Query(value = "Select * FROM Cuenta c "
			+ " WHERE c.numero_cuenta = ?1",nativeQuery = true)
    Cuenta cuentaxNumeroCuenta(Integer numeroCuenta);	
		
}
