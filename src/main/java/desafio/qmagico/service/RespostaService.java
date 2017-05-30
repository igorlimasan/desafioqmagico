package desafio.qmagico.service;

import java.util.List;

import desafio.qmagico.model.Resposta;

public interface RespostaService {
	
	public List<Resposta> buscarTodos();
	public List<Resposta> buscarPorUsuario(Long usuario);
	public Resposta buscar(Long id);
	public Resposta salvar(Resposta resposta);
	public void deletar(Resposta resposta);

}
