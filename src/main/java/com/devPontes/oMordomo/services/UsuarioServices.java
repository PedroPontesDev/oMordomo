package com.devPontes.oMordomo.services;

import java.util.List;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.dtos.GarcomDTO;
import com.devPontes.oMordomo.model.dtos.UsuarioDTO;

public interface UsuarioServices {
	
	List<UsuarioDTO> listarTodos() throws Exception;
	UsuarioDTO procurarPorId(Long id) throws Exception;
	UsuarioDTO procurarPorCpf(Long cpf) throws Exception;
	UsuarioDTO registrarNovoUsuario(UsuarioDTO novoUsuario) throws Exception;
	UsuarioDTO atualizaUsuarioxistente(Long garcomId, GarcomDTO update) throws Exception;
	void deletarUsuarioExistente(Long garcomId) throws Exception;
	
}
