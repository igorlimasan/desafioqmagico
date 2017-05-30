package desafio.qmagico.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import desafio.qmagico.model.Usuario;
import desafio.qmagico.security.JwtUtils;
import desafio.qmagico.security.Login;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager auth;
	
	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> login(@RequestBody Login login,  HttpServletResponse response, HttpServletRequest request) throws JsonProcessingException{
		/*HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:9000");*/
		
		System.out.println("Login: " + login.getUsername()+"\nSenha: " + login.getPassword());
		
		 Authentication credentials = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
	        Usuario usuario = (Usuario) auth.authenticate(credentials).getPrincipal();
	        System.out.println(usuario.getNome());
	        usuario.setSenha(null);
	           response.setHeader("Token", JwtUtils.generateToken(usuario));
	          // response.setHeader("Access-Control-Allow-Origin", "http://192.168.0.23:9000");
	           return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	
	}
	

}
