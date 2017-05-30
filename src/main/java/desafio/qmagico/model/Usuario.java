package desafio.qmagico.model;

import java.util.Collection;
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
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import desafio.qmagico.view.View;


@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({View.All.class,View.Alternative.class})
	private Long id;
	
	@Column(name = "nome")
	@JsonView({View.All.class,View.Alternative.class})
	private String nome;
	
	@Column(name = "login")
	//@JsonIgnore
	@JsonView({View.All.class,View.Alternative.class})
	private String login;
	
	@Column(name = "senha")
	@JsonIgnore
	private String senha;
	
	
	@JsonView({View.All.class,View.Alternative.class})
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "autorizacao_usuario", joinColumns = {@JoinColumn(name ="fk_usuario")},
	inverseJoinColumns = {@JoinColumn(name = "fk_autorizacao")})
	private List<Autorizacao> autorizacoes;
	
	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//@JsonIgnore
	public String getLogin() {
		return login;
	}
	
	@JsonProperty
	public void setLogin(String login) {
		this.login = login;
	}
	
	@JsonIgnore
	public String getSenha() {
		return senha;
	}

	@JsonProperty
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}
	@JsonProperty
	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return autorizacoes;
	}
	
	@JsonIgnore
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	//@JsonIgnore
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
