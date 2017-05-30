package desafio.qmagico.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import desafio.qmagico.view.View;

@Entity
@Table(name = "perguntas")
public class Perguntas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonView({View.All.class, View.Alternative.class})
	private Long id;
	
	@JsonView({View.All.class, View.Alternative.class})
	@Column(name = "pergunta")
	private String pergunta;
	
	@JsonView({View.All.class, View.Alternative.class})
	@OneToOne
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;
	
	@JsonView({View.All.class, View.Alternative.class})
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perguntas_respostas", joinColumns={@JoinColumn(name = "fk_perguntas")},
	inverseJoinColumns={@JoinColumn(name = "fk_respostas")})
	private List<Resposta> resposta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Resposta> getResposta() {
		return resposta;
	}

	public void setResposta(List<Resposta> resposta) {
		this.resposta = resposta;
	}
	
	
	

}
