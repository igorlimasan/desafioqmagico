package desafio.qmagico.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import desafio.qmagico.model.Usuario;
import desafio.qmagico.security.CriptografarSenha;
import desafio.qmagico.service.UsuarioService;
import desafio.qmagico.view.View;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(value = "/getAll")
	@JsonView(View.All.class)
//	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Collection<Usuario>> getAll(){
		return new ResponseEntity<Collection<Usuario>>(usuarioService.buscarTodos(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario save (@RequestBody Usuario usuario, HttpServletRequest request, HttpServletResponse response){
			System.out.println(usuario.getNome());
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getSenha());
			System.out.println(usuario.getAutorizacoes());
			Usuario user = usuario;
			String senha = CriptografarSenha.criptografar(usuario.getSenha());
			user.setSenha(senha);
			return usuarioService.salvar(user);
			
		
	}
	
	
	                                                                                             

}
