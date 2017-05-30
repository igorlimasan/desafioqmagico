package desafio.qmagico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import desafio.qmagico.model.Usuario;
import desafio.qmagico.repository.UsuarioRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findByLogin(login);
		if(usuario == null) throw new UsernameNotFoundException("Usuario não encptrado, login: " + login );
		return usuario;
	}

}
