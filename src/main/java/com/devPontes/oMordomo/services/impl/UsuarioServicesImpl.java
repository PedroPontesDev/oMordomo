package com.devPontes.oMordomo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.GarcomDTO;
import com.devPontes.oMordomo.model.dtos.PermissaoDTO;
import com.devPontes.oMordomo.model.dtos.UsuarioDTO;
import com.devPontes.oMordomo.model.entities.Permissao;
import com.devPontes.oMordomo.model.entities.Usuario;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.PermissaoRepository;
import com.devPontes.oMordomo.repositories.UsuarioRepository;
import com.devPontes.oMordomo.services.UsuarioServices;

@Service
public class UsuarioServicesImpl implements UsuarioServices, UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Autowired
	private PermissaoRepository permissaoRepository;

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public List<UsuarioDTO> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO procurarPorId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO procurarPorCpf(Long cpf) throws Exception { 
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO registrarNovoUsuario(UsuarioDTO novo) throws Exception {
	    if (novo.getPassword() == null) {
	        throw new IllegalArgumentException("Password não pode ser nula!");
	    }

	    Usuario novoUsuario = MyMapper.parseObject(novo, Usuario.class);
	    String encodedPassword = passwordEncoder().encode(novo.getPassword());
	    novoUsuario.setPassword(encodedPassword);

	    var user = userRepository.findUsuarioByUsername(novo.getUsername());
	    if(!user.isPresent()) throw new UsernameNotFoundException("Usuário não encontrado!");
	    
	    // Aqui você precisa buscar as permissões pelo ID e associá-las ao novo usuário
	    List<Permissao> permissoes = new ArrayList<>();
	    for (PermissaoDTO permissaoDTO : novo.getPermissoes()) {
	        Permissao permissao = permissaoRepository.findById(permissaoDTO.getId())
	                              .orElseThrow(() -> new IllegalArgumentException("Permissão não encontrada"));
	        permissoes.add(permissao);
	    }
	    permissaoRepository.saveAll(permissoes);
	    novoUsuario.setPermissoes(permissoes);
	    novoUsuario = userRepository.save(novoUsuario);
	    var dto = MyMapper.parseObject(novoUsuario, UsuarioDTO.class);
	    return dto;
	}


	@Override
	public UsuarioDTO atualizaUsuarioxistente(Long garcomId, GarcomDTO update) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarUsuarioExistente(Long garcomId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = userRepository.findUsuarioByUsername(username);
		if (user.isPresent()) {
			return user.get();
		} throw new UsernameNotFoundException("Usuário não encontrado!" + username);
	}

}
