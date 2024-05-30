package cadastroee.controller;

import cadastroee.model.Pessoa;
import java.util.List;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class PessoaFacade
 */
@Stateless
@Local(PessoaFacadeLocal.class)
@LocalBean
public class PessoaFacade implements PessoaFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-3-ejb")
    private EntityManager em;
    
    @Override
    public void create(Pessoa pessoa) {
        em.persist(pessoa);
    }

	@Override
    public void remove(Pessoa pessoa) {
        em.remove(pessoa);
    }

	@Override
    public List<Pessoa> findRange(int[] range) {
    	jakarta.persistence.Query q = em.createQuery("SELECT p FROM Pessoa p");
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

	@Override
    public int count() {
    	jakarta.persistence.Query q = em.createQuery("SELECT COUNT(p) FROM Pessoa p");
        return ((Long) q.getSingleResult()).intValue();
    }

	@Override
    public Pessoa find(Object id) {
        return em.find(Pessoa.class, id);
    }

	@Override
    public List<Pessoa> findAll() {
    	return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

	@Override
    public void edit(Pessoa pessoa) {
        em.merge(pessoa);
    }

}
