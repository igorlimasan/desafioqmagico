package desafio.qmagico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import desafio.qmagico.model.Perguntas;

public interface PerguntasRepository extends CrudRepository<Perguntas, Long>  {
	
	public List<Perguntas> findAll();
	public Perguntas findById(Long id);
	@Query("from Perguntas p where p.usuario.id=?1")
	public List<Perguntas> findByUsuario(Long id);

}
