package desafio.qmagico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import desafio.qmagico.view.View;

@Entity
@Table(name = "autorizacao")
public class Autorizacao implements GrantedAuthority{
	
	@Id
	@Column(name = "id")
	@JsonView({View.All.class,View.Alternative.class})
	private Long id;
	
	@Column(name = "nome")
	@JsonView({View.All.class,View.Alternative.class})
	private String nome;

	@JsonIgnore
	public String getAuthority() {
		// TODO Auto-generated method stub
		return nome;
	}
	

}
