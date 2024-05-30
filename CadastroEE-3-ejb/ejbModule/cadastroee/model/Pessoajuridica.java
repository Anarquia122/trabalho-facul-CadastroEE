package cadastroee.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the pessoajuridica database table.
 * 
 */
@Entity
@NamedQuery(name="Pessoajuridica.findAll", query="SELECT p FROM Pessoajuridica p")
public class Pessoajuridica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idpessoajuridica;

	private String cnpj;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	private Pessoa pessoa;

	public Pessoajuridica() {
	}

	public Integer getIdpessoajuridica() {
		return this.idpessoajuridica;
	}

	public void setIdpessoajuridica(Integer idpessoajuridica) {
		this.idpessoajuridica = idpessoajuridica;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}