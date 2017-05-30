package desafio.qmagico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import desafio.qmagico.view.View;

@Entity
@Table(name = "respostas")
public class Resposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonView({View.All.class, View.Alternative.class})
	private Long id;
	
	@Column(name = "respostas")
	@JsonView({View.All.class, View.Alternative.class})
	private String respostas;
	
	
	@OneToOne
	@JoinColumn(name="fk_usuario")
	@JsonView({View.All.class, View.Alternative.class})
	private Usuario usuario;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRespostas() {
		return respostas;
	}


	public void setRespostas(String respostas) {
		this.respostas = respostas;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
