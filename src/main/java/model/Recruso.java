package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("1")
public class Recruso extends Pessoa{

	public Recruso(String nome, String dataNascimento) {
		super(nome, dataNascimento);
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany
	private List<TipoDeCrime> tipoDeCrime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<TipoDeCrime> getTipoDeCrime() {
		return tipoDeCrime;
	}
	public void setTipoDeCrime(List<TipoDeCrime> tipoDeCrime) {
		this.tipoDeCrime = tipoDeCrime;
	}
	
	
	
	
}
