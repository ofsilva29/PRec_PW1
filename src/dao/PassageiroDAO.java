package dao;

import classes.Passageiro;
import util.JPAUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
public class PassageiroDAO {
    private EntityManager em;

    public PassageiroDAO() {
    }

    public boolean salvar(Passageiro entity) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo SALVAR na classe PassageiroDAO" + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Passageiro entity) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo ATUALIZAR na classe PassageiroDAO" + e.getMessage());
            return false;
        }
    }

    public boolean remover(long id) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            Passageiro entity = em.find(Passageiro.class, id);
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo REMOVER na classe PassageiroDAO" + e.getMessage());
            return false;
        }
    }

    public Passageiro buscarID(long id) {
        try {
            em = JPAUtil.getEntityManager();
            Passageiro entity = em.find(Passageiro.class, id);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo BUSCAR_ID na classe PassageiroDAO" + e.getMessage());
            return null;
        }
    }

    public List<Passageiro> buscarTodos() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Passageiro> query = em.createQuery("SELECT obj FROM Passageiro obj", Passageiro.class);
            List<Passageiro> Passageiros = query.getResultList();
            return Passageiros;
        } catch (RuntimeException e) {
        	System.out.println("Erro no metodo BUSCAR_TODOS na classe PassageiroDAO" + e.getMessage());
            return null;
        }
    }

    public Passageiro buscarPorNome(String nome) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Passageiro> query = em.createQuery("SELECT obj FROM Passageiro obj WHERE obj.nome = :nome", Passageiro.class);
            query.setParameter("nome", nome);
            return query.getSingleResult();
        }catch (RuntimeException e) {
        	System.out.println("Erro no metodo BUSCAR_POR_NOME na classe PassageiroDAO" + e.getMessage());
            return null;
        }
    }
}
