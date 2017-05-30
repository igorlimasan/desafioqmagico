package desafio.qmagico.service;

import java.util.List;

import desafio.qmagico.model.Usuario;

public interface UsuarioService {
	public List<Usuario> buscarTodos();
	public Usuario buscarPorLogin(String login);
	public Usuario salvar(Usuario usuario);
	

}
