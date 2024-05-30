package cadastroee.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
	@SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1)
	private Long idproduto;

	private String nomeproduto;

	private Float preco;

	private Integer quantidade;

	//bi-directional many-to-one association to Movimento
	@OneToMany(mappedBy="produto")
	private List<Movimento> movimentos;

	public Produto() {
	}

	public Long getIdproduto() {
		return this.idproduto;
	}

	public void setIdproduto(Long idproduto) {
		this.idproduto = idproduto;
	}

	public String getNomeproduto() {
		return this.nomeproduto;
	}

	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}

	public Float getPreco() {
		return this.preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public List<Movimento> getMovimentos() {
		return this.movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	public Movimento addMovimento(Movimento movimento) {
		getMovimentos().add(movimento);
		movimento.setProduto(this);

		return movimento;
	}

	public Movimento removeMovimento(Movimento movimento) {
		getMovimentos().remove(movimento);
		movimento.setProduto(null);

		return movimento;
	}

}