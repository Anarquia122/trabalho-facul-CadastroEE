package cadastroee.controller;

import cadastroee.model.Pessoajuridica;
import java.util.List;
import jakarta.ejb.Local;

@Local
public interface PessoaJuridicaFacadeLocal {
	void create(Pessoajuridica pessoaJuridica);
	void edit(Pessoajuridica pessoaJuridica);
	void remove(Pessoajuridica pessoaJuridica);
	Pessoajuridica find(Object id);
	List<Pessoajuridica> findAll();
	List<Pessoajuridica> findRange(int[] range);
	int count();
}
