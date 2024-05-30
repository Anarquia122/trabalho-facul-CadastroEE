package cadastroee.controller;

import cadastroee.model.Usuario;
import java.util.List;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
/**
 * Session Bean implementation class UsuarioFacade
 */
@Stateless
@Local(UsuarioFacadeLocal.class)
@LocalBean
public class UsuarioFacade implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-3-ejb")
    private EntityManager em;

	@Override
    public List<Usuario> findAll() {
    	return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

	@Override
    public List<Usuario> findRange(int[] range) {
    	jakarta.persistence.Query q = em.createQuery("SELECT u FROM Usuario u");
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

	@Override
    public void create(Usuario usuario) {
        em.persist(usuario);
    }

	@Override
    public void edit(Usuario usuario) {
        em.merge(usuario);
    }

	@Override
    public Usuario find(Object id) {
        return em.find(Usuario.class, id);
    }

	@Override
    public int count() {
    	jakarta.persistence.Query q = em.createQuery("SELECT COUNT(u) FROM Usuario u");
        return ((Long) q.getSingleResult()).intValue();
    }

	@Override
    public void remove(Usuario usuario) {
        em.remove(usuario);
    }

}
