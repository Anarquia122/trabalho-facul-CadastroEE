package cadastroee.controller;

import cadastroee.model.Pessoa;
import cadastroee.model.Pessoajuridica;
import java.util.List;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class PessoaJuridicaFacade
 */
@Stateless
@Local(PessoaJuridicaFacadeLocal.class)
@LocalBean
public class PessoaJuridicaFacade implements PessoaJuridicaFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-3-ejb")
    private EntityManager em;

	@Override
    public List<Pessoajuridica> findAll() {
    	return em.createQuery("SELECT pj FROM Pessoajuridica pj", Pessoajuridica.class).getResultList();
    }

	@Override
    public void remove(Pessoajuridica pessoaJuridica) {
        em.remove(pessoaJuridica);
    }

	@Override
    public int count() {
    	jakarta.persistence.Query q = em.createQuery("SELECT COUNT(pj) FROM Pessoajuridica pj");
        return ((Long) q.getSingleResult()).intValue();
    }

	@Override
    public void edit(Pessoajuridica pessoaJuridica) {
        em.merge(pessoaJuridica);
    }

	@Override
    public void create(Pessoajuridica pessoaJuridica) {
        em.persist(pessoaJuridica);
    }

	@Override
    public Pessoajuridica find(Object id) {
        return em.find(Pessoajuridica.class, id);
    }

	@Override
    public List<Pessoajuridica> findRange(int[] range) {
    	jakarta.persistence.Query q = em.createQuery("SELECT pj FROM Pessoajuridica pj");
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

}
