package cadastroee.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import jakarta.persistence.Entity;


/**
 * The persistent class for the movimento database table.
 * 
 */
@Entity
@NamedQuery(name="Movimento.findAll", query="SELECT m FROM Movimento m")
public class Movimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idmovimento;

	private Timestamp datamovimento;

	private Integer quantidade;

	private String tipo;

	private BigDecimal valorunitario;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="idpessoa")
	private Pessoa pessoa;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="idproduto")
	private Produto produto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Movimento() {
	}

	public Integer getIdmovimento() {
		return this.idmovimento;
	}

	public void setIdmovimento(Integer idmovimento) {
		this.idmovimento = idmovimento;
	}

	public Timestamp getDatamovimento() {
		return this.datamovimento;
	}

	public void setDatamovimento(Timestamp datamovimento) {
		this.datamovimento = datamovimento;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(BigDecimal valorunitario) {
		this.valorunitario = valorunitario;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}