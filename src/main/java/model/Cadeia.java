package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cadeia {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Pessoa> getPessoa() {
		return pessoa;
	}
	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String localizacao;
	private String provincia;
	
	@OneToMany
	private List<Pessoa> pessoa;
	
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public long getId() {
		return id;
	}
	
	
}
