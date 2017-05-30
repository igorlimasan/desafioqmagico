package desafio.qmagico.web.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import desafio.qmagico.model.Perguntas;
import desafio.qmagico.model.Resposta;
import desafio.qmagico.service.PerguntasService;
import desafio.qmagico.service.RespostaService;
import desafio.qmagico.view.View;

@RestController
@RequestMapping(value ="/pergunta")
public class PerguntasController {
	
	@Autowired
	private PerguntasService perguntasService;
	
	@Autowired
	private RespostaService respostaService;
	
	@RequestMapping(value = "/getAll")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Perguntas>> getAll(){
		return new ResponseEntity<Collection<Perguntas>>(perguntasService.buscarTodos(),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getByUser")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Perguntas>> getByUser(@RequestParam(value="id",defaultValue="1")Long id){
		List<Perguntas> perguntas = perguntasService.buscarPorUsuario(id);
		if(perguntas == null){
			return new ResponseEntity<Collection<Perguntas>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Collection<Perguntas>>(perguntas,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getById")
	@JsonView(View.All.class)
	public ResponseEntity<Perguntas> getById(@RequestParam(value="id",defaultValue="1")Long id){
		Perguntas pergunta = perguntasService.buscar(id);
		if(pergunta == null){
			return new ResponseEntity<Perguntas>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Perguntas>(pergunta,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	
	public Perguntas save(@RequestBody Perguntas perguntas, HttpServletResponse response, HttpServletRequest request){
		
		for(Resposta r:perguntas.getResposta()){
			if(r.getId() == null){
			respostaService.salvar(r);
			}
		}
		
		return perguntasService.salvar(perguntas);
		
	}
	
	@RequestMapping(value = "/delete")
	@JsonView(View.All.class)
	
	public String deletar(@RequestParam(value="id",defaultValue = "1") Long id){
		Perguntas pergunta = perguntasService.buscar(id);
		if(pergunta != null){
			perguntasService.deletar(pergunta);
			return "{msg: \"Pergunta deletada\"}";
			
		}
		return "{}";
		
	}

}
