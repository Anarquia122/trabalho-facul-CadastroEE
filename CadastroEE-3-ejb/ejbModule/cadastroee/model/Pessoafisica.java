package cadastroee.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the pessoafisica database table.
 * 
 */
@Entity
@NamedQuery(name="Pessoafisica.findAll", query="SELECT p FROM Pessoafisica p")
public class Pessoafisica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idpessoafisica;

	private String cpf;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	private Pessoa pessoa;

	public Pessoafisica() {
	}

	public Integer getIdpessoafisica() {
		return this.idpessoafisica;
	}

	public void setIdpessoafisica(Integer idpessoafisica) {
		this.idpessoafisica = idpessoafisica;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}