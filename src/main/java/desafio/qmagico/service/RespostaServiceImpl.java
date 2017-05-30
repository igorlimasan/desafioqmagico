package desafio.qmagico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.qmagico.model.Resposta;
import desafio.qmagico.repository.RespostaRepository;

@Service("respostaService")
public class RespostaServiceImpl implements RespostaService{
	
	@Autowired
	private RespostaRepository respostaRepository;

	public List<Resposta> buscarTodos() {
		// TODO Auto-generated method stub
		return respostaRepository.findAll();
	}

	public List<Resposta> buscarPorUsuario(Long usuario) {
		// TODO Auto-generated method stub
		return respostaRepository.findByUsuario(usuario);
	}

	public Resposta buscar(Long id) {
		// TODO Auto-generated method stub
		return respostaRepository.findById(id);
	}

	public Resposta salvar(Resposta resposta) {
		// TODO Auto-generated method stub
		return respostaRepository.save(resposta);
	}

	public void deletar(Resposta resposta) {
		respostaRepository.delete(resposta);
		
	}

}
