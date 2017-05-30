package desafio.qmagico.web.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import desafio.qmagico.model.Perguntas;
import desafio.qmagico.model.Resposta;
import desafio.qmagico.service.PerguntasService;
import desafio.qmagico.service.RespostaService;
import desafio.qmagico.view.View;

@RestController
@RequestMapping(value = "/resposta")
public class RespostaController {
	
	
	@Autowired
	private RespostaService respostaService;
	
	@Autowired
	private PerguntasService perguntaService;
	
	@RequestMapping(value = "/getAll")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Resposta>> getAll (){
		
		return new ResponseEntity<Collection<Resposta>>(respostaService.buscarTodos(),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getById")
	@JsonView(View.All.class)
	public ResponseEntity<Resposta> getById (@RequestParam(value = "id", defaultValue = "1") Long id){
		Resposta resp = respostaService.buscar(id);
		if (resp == null){
			return new ResponseEntity<Resposta>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Resposta>(resp,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getByUser")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Resposta>> getByUser(@RequestParam(value = "id", defaultValue = "1") Long id){
		List<Resposta> resp = respostaService.buscarPorUsuario(id);
		if (resp == null){
			return new ResponseEntity<Collection<Resposta>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Collection<Resposta>>(resp,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	
	@JsonView(View.All.class)
	public Resposta save(@RequestBody Resposta resposta, HttpServletRequest request, HttpServletResponse response){
		System.out.println(resposta.getRespostas());
		return respostaService.salvar(resposta);
		
	}
	@RequestMapping(value = "/save/{id_pergunta}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(View.All.class)
	public ResponseEntity<Resposta> adicionarNaPergunta(@RequestBody Resposta resposta,@PathVariable("id_pergunta") Long id, HttpServletRequest request, HttpServletResponse response){
		System.out.println(resposta.getRespostas());
		Perguntas p = perguntaService.buscar(id);
		if(p == null)
		{
			new ResponseEntity<Resposta>(HttpStatus.NOT_FOUND);
		}
		else{
			resposta = respostaService.salvar(resposta);
			p.getResposta().add(resposta);
			perguntaService.salvar(p);
			
		}
		return new ResponseEntity<Resposta>(resposta,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/delete/{id_pergunta}")
	@JsonView(View.All.class)

	public String deletar(@RequestParam(value="id",defaultValue = "1") Long id,@PathVariable(value="id_pergunta") Long idPergunta){
		Resposta resposta = respostaService.buscar(id);
		System.out.println(resposta.getId());
		if(resposta != null){
			Perguntas p = perguntaService.buscar(idPergunta);
			p.getResposta().remove(resposta);			
			perguntaService.salvar(p);
			respostaService.deletar(resposta);
			return "{msg: \"Resposta deletada\"}";
			
		}
		return "{}";
		
	}
	
	
	
	
	
	

}
