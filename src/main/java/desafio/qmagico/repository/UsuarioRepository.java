package desafio.qmagico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import desafio.qmagico.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public List<Usuario> findAll();
	
	@Query("from Usuario u where u.login=?1")
	public Usuario findByLogin(String login);

}
