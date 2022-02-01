package modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY) /* gera chave auto incremento */
	private Long id;
	
	private String nome;
	
	//@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) /* operacao em cascat apara a insercao e opera��o */
	@OneToOne(cascade = CascadeType.PERSIST) /*Operacao em Cascata apenas na persistencia*/
	@JoinColumn(name = "assento_id", unique = true) /*Especifico para mapear campos que representam juncao*/
	private Assento assento;
	
	public Cliente() {
	
	}

	public Cliente(String nome, Assento assento) {
		super();
		this.nome = nome;
		this.assento = assento;
	}

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

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

}
