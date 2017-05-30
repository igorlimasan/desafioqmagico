package desafio.qmagico.service;

import java.util.List;

import desafio.qmagico.model.Perguntas;

public interface PerguntasService {
	
	public List<Perguntas> buscarTodos();
	public List<Perguntas> buscarPorUsuario(Long id);
	public Perguntas buscar(Long id);
	public Perguntas salvar(Perguntas perguntas);
	public void deletar(Perguntas perguntas);

}
