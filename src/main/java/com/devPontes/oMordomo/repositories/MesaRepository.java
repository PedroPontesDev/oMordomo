package com.devPontes.oMordomo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devPontes.oMordomo.model.entities.Mesa;
import com.devPontes.oMordomo.model.enums.StatusMesa;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
	
	
}
