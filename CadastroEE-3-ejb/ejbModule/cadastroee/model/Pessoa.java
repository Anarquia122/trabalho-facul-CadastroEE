package cadastroee.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idpessoa;

	private String cidade;

	private String email;

	private String estado;

	private String logradouro;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to Movimento
	@OneToMany(mappedBy="pessoa")
	private List<Movimento> movimentos;

	//bi-directional many-to-one association to Pessoafisica
	@OneToMany(mappedBy="pessoa")
	private List<Pessoafisica> pessoafisicas;

	//bi-directional many-to-one association to Pessoajuridica
	@OneToMany(mappedBy="pessoa")
	private List<Pessoajuridica> pessoajuridicas;

	public Pessoa() {
	}

	public Integer getIdpessoa() {
		return this.idpessoa;
	}

	public void setIdpessoa(Integer idpessoa) {
		this.idpessoa = idpessoa;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Movimento> getMovimentos() {
		return this.movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	public Movimento addMovimento(Movimento movimento) {
		getMovimentos().add(movimento);
		movimento.setPessoa(this);

		return movimento;
	}

	public Movimento removeMovimento(Movimento movimento) {
		getMovimentos().remove(movimento);
		movimento.setPessoa(null);

		return movimento;
	}

	public List<Pessoafisica> getPessoafisicas() {
		return this.pessoafisicas;
	}

	public void setPessoafisicas(List<Pessoafisica> pessoafisicas) {
		this.pessoafisicas = pessoafisicas;
	}

	public Pessoafisica addPessoafisica(Pessoafisica pessoafisica) {
		getPessoafisicas().add(pessoafisica);
		pessoafisica.setPessoa(this);

		return pessoafisica;
	}

	public Pessoafisica removePessoafisica(Pessoafisica pessoafisica) {
		getPessoafisicas().remove(pessoafisica);
		pessoafisica.setPessoa(null);

		return pessoafisica;
	}

	public List<Pessoajuridica> getPessoajuridicas() {
		return this.pessoajuridicas;
	}

	public void setPessoajuridicas(List<Pessoajuridica> pessoajuridicas) {
		this.pessoajuridicas = pessoajuridicas;
	}

	public Pessoajuridica addPessoajuridica(Pessoajuridica pessoajuridica) {
		getPessoajuridicas().add(pessoajuridica);
		pessoajuridica.setPessoa(this);

		return pessoajuridica;
	}

	public Pessoajuridica removePessoajuridica(Pessoajuridica pessoajuridica) {
		getPessoajuridicas().remove(pessoajuridica);
		pessoajuridica.setPessoa(null);

		return pessoajuridica;
	}

}