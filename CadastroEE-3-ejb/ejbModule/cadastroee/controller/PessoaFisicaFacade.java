package cadastroee.controller;

import cadastroee.model.Pessoa;
import cadastroee.model.Pessoafisica;
import java.util.List;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class PessoaFisicaFacade
 */
@Stateless
@Local(PessoaFisicaFacadeLocal.class)
@LocalBean
public class PessoaFisicaFacade implements PessoaFisicaFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-3-ejb")
    private EntityManager em;

	@Override
    public Pessoafisica find(Object id) {
        return em.find(Pessoafisica.class, id);
    }

	@Override
    public void edit(Pessoafisica pessoaFisica) {
        em.merge(pessoaFisica);
    }

	@Override
    public void remove(Pessoafisica pessoaFisica) {
        em.remove(pessoaFisica);
    }

	@Override
    public List<Pessoafisica> findAll() {
    	return em.createQuery("SELECT pf FROM PessoaFisica pf", Pessoafisica.class).getResultList();
    }

	@Override
    public int count() {
		jakarta.persistence.Query q = em.createQuery("SELECT COUNT(pf) FROM Pessoafisica pf");
        return ((Long) q.getSingleResult()).intValue();
    }

	@Override
    public void create(Pessoafisica pessoaFisica) {
        em.persist(pessoaFisica);
    }

	@Override
    public List<Pessoafisica> findRange(int[] range) {
		jakarta.persistence.Query q = em.createQuery("SELECT pf FROM Pessoafisica pf");
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

}
