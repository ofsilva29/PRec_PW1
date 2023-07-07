package dao;

import classes.Voo;
import util.JPAUtil;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class VooDAO {
    private EntityManager em;

    public VooDAO() {
    }

    public boolean salvar(Voo entity) {
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
            System.out.println("Erro no metodo SALVAR na classe VooDAO" + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Voo entity) {
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
            System.out.println("Erro no metodo ATUALIZAR na classe VooDAO" + e.getMessage());
            return false;
        }
    }

    public boolean remover(long id) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            Voo entity = em.find(Voo.class, id);
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo REMOVER na classe VooDAO" + e.getMessage());
            return false;
        }
    }

    public Voo buscarID(long id) {
        try {
            em = JPAUtil.getEntityManager();
            Voo entity = em.find(Voo.class, id);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo BUSCAR_ID na classe VooDAO" + e.getMessage());
            return null;
        }
    }

    public List<Voo> buscarTodos() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Voo> query = em.createQuery("SELECT obj FROM Voo obj", Voo.class);
            List<Voo> Voos = query.getResultList();
            return Voos;
        } catch (RuntimeException e) {
        	System.out.println("Erro no método BUSCAR_TODOS na classe VooDAO" + e.getMessage());
            return null;
        }
    }

    public Voo buscarPorNumero(int num) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Voo> query = em.createQuery("SELECT obj FROM Voo obj WHERE obj.numero= :numero", Voo.class);
            query.setParameter("numero", num);
            return query.getSingleResult();
        }catch (RuntimeException e) {
        	System.out.println("Erro no metodo SALVAR na classe VooDAO" + e.getMessage());
            return null;
        }
    }
}
