package desafio.qmagico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import desafio.qmagico.model.Perguntas;
import desafio.qmagico.repository.PerguntasRepository;

@Service("perguntaService")
public class PerguntasServiceImpl implements PerguntasService{
	
	@Autowired
	private PerguntasRepository perguntasRepository;

	public List<Perguntas> buscarTodos() {
		// TODO Auto-generated method stub
		return perguntasRepository.findAll();
	}

	public List<Perguntas> buscarPorUsuario(Long id) {
		// TODO Auto-generated method stub
		return perguntasRepository.findByUsuario(id);
	}

	public Perguntas buscar(Long id) {
		// TODO Auto-generated method stub
		return perguntasRepository.findById(id);
	}

	@Transactional
	public Perguntas salvar(Perguntas perguntas) {
		// TODO Auto-generated method stub
		return perguntasRepository.save(perguntas);
	}

	public void deletar(Perguntas perguntas) {
		perguntasRepository.delete(perguntas);
		
	}

}
