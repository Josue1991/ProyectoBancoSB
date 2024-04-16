package com.banco.banco.bancoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banco.banco.bancoEntity.TipoCuenta;

public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Long> {
	
	@Query(value = "Select * FROM TipoCuenta t "
			+ " WHERE t.descripcion_TipoCuenta LIKE ?1%",nativeQuery = true)
    TipoCuenta tipoCuentaDescripcion(String identificacion);		
}
