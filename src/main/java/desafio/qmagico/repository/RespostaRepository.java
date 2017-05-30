package desafio.qmagico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import desafio.qmagico.model.Resposta;

public interface RespostaRepository extends CrudRepository<Resposta, Long> {
	
	public List<Resposta> findAll();
	
	@Query("from Resposta r where r.usuario.id=?1")
	public List<Resposta> findByUsuario(Long usuario);
	
	public Resposta findById(Long id);
}
