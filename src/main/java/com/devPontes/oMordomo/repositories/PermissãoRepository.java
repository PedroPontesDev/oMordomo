package com.devPontes.oMordomo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devPontes.oMordomo.model.entities.BatedorDePonto;
import com.devPontes.oMordomo.model.entities.Permissão;

public interface PermissãoRepository extends JpaRepository<Permissão, Long> {

	
}
