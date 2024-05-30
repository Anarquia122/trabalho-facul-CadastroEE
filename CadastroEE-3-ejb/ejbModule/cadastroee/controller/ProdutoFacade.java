package cadastroee.controller;

import cadastroee.model.Produto;
import java.util.List;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
@Local(ProdutoFacadeLocal.class)
@LocalBean
public class ProdutoFacade implements ProdutoFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-3-ejb")
    private EntityManager em;

    @Override
    public void edit(Produto produto) {
        // Verifica se a entidade está detached e, se sim, converte para managed
        if (!em.contains(produto)) {
            produto = em.merge(produto);
        }
        // Agora a entidade está no estado managed e pode ser editada
        em.merge(produto);
    }

    @Override
    public void remove(Produto produto) {
        // Verifica se a entidade está detached e, se sim, converte para managed
        if (!em.contains(produto)) {
            produto = em.merge(produto);
        }
        // Agora a entidade está no estado managed e pode ser removida
        em.remove(produto);
    }

    @Override
    public List<Produto> findRange(int[] range) {
        jakarta.persistence.Query q = em.createQuery("SELECT pr FROM Produto pr");
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public Produto find(Object id) {
        return em.find(Produto.class, id);
    }

    @Override
    public int count() {
        jakarta.persistence.Query q = em.createQuery("SELECT COUNT(pr) FROM Produto pr");
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public List<Produto> findAll() {
        return em.createQuery("SELECT pr FROM Produto pr", Produto.class).getResultList();
    }

    @Override
    public void create(Produto produto) {
        // Verifica se a entidade está detached e, se sim, converte para managed
        if (!em.contains(produto)) {
            produto = em.merge(produto);
        }
        // Agora a entidade está no estado managed e pode ser persistida
        em.persist(produto);
    }
}