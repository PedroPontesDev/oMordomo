package com.devPontes.oMordomo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devPontes.oMordomo.model.entities.Garcom;

public interface GarcomRepository extends JpaRepository<Garcom, Long> {

	@Query("SELECT g FROM Garcom g WHERE g.id = :id" )
	Optional<Garcom> findById(Long id);

	@Query("SELECT u FROM Usuario u WHERE u.cpf = :cpf")
	Optional<Garcom> procurarPorCpf(@Param("cpf") Long cpf);
	
	@Modifying
	@Query("UPDATE Garcom g SET g.salario = :novoSalario WHERE g.id = :garcomId")
	void setReajusteSalario(@Param("novoSalario") Double novoSalario, @Param("garcomId") Long garcomId);
	
}
