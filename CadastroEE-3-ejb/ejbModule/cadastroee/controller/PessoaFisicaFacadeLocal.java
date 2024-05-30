package cadastroee.controller;

import cadastroee.model.Pessoafisica;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface PessoaFisicaFacadeLocal {
	void create(Pessoafisica pessoaFisica);
	void edit(Pessoafisica pessoaFisica);
	void remove(Pessoafisica pessoaFisica);
	Pessoafisica find(Object id);
	List<Pessoafisica> findAll();
	List<Pessoafisica> findRange(int[] range);
	int count();
}
