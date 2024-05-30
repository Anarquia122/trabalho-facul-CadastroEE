package cadastroee.controller;

import cadastroee.model.Movimento;
import cadastroee.model.Pessoa;

import java.util.List;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class MovimentoFacade
 */
@Stateless
@Local(MovimentoFacadeLocal.class)
@LocalBean
public class MovimentoFacade implements MovimentoFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-3-ejb")
    private EntityManager em;

	@Override
    public List<Movimento> findRange(int[] range) {
    	jakarta.persistence.Query q = em.createQuery("SELECT m FROM Movimento m");
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

	@Override
    public List<Movimento> findAll() {
    	return em.createQuery("SELECT m FROM Movimento m", Movimento.class).getResultList();
    }

	@Override
    public void edit(Movimento movimento) {
        em.merge(movimento);
    }

	@Override
    public Movimento find(Object id) {
        return em.find(Movimento.class, id);
    }

	@Override
    public int count() {
    	jakarta.persistence.Query q = em.createQuery("SELECT COUNT(m) FROM Movimento m");
        return ((Long) q.getSingleResult()).intValue();
    }

	@Override
    public void create(Movimento movimento) {
        em.persist(movimento);
    }

	@Override
    public void remove(Movimento movimento) {
        em.remove(movimento);
    }

}
