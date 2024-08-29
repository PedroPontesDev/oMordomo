package com.devPontes.oMordomo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.GarcomDTO;
import com.devPontes.oMordomo.model.dtos.UsuarioDTO;
import com.devPontes.oMordomo.model.entities.Permissao;
import com.devPontes.oMordomo.model.entities.Usuario;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.PermissaoRepository;
import com.devPontes.oMordomo.repositories.UsuarioRepository;
import com.devPontes.oMordomo.security.dto.LoginRequest;
import com.devPontes.oMordomo.security.services.jwt.JwtTokenProvider;
import com.devPontes.oMordomo.services.UsuarioServices;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServicesImpl implements UsuarioServices, UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
    private JwtTokenProvider jwtTokenProvider;
	
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
	@Transactional
	public UsuarioDTO registrarNovoUsuario(UsuarioDTO novo) throws Exception {
		   if (novo.getPassword() == null || novo.getUsername() == null || novo.getEmail() == null) {
		        throw new IllegalArgumentException("Senha, nome de usuário e email não podem ser nulos!");
		    }

		    var existingUser = userRepository.findUsuarioByUsername(novo.getUsername());

		    if (existingUser.isPresent()) {
		        throw new Exception("Usuário já existe, tente outro!");
		    }

		    Usuario novoUsuario = MyMapper.parseObject(novo, Usuario.class);
		    String encodedPassword = passwordEncoder().encode(novo.getPassword());
		    novoUsuario.setPassword(encodedPassword);

		    List<Permissao> permissoes = novo.getPermissoes().stream()
		        .map(permissaoDTO -> permissaoRepository.findById(permissaoDTO.getId())
		        .orElseThrow(() -> new IllegalArgumentException("Permissão com ID " + permissaoDTO.getId() + " não encontrada")))
		        .collect(Collectors.toList());

		    novoUsuario.setPermissoes(permissoes);

		    Usuario savedUser = userRepository.save(novoUsuario);
		    return MyMapper.parseObject(savedUser, UsuarioDTO.class);
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
