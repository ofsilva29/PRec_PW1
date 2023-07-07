package dao;

import classes.Passagem;
import util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PassagemDAO {

    private EntityManager em;

    public PassagemDAO() {
    }

    public boolean salvar(Passagem entity) {
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
            System.out.println("Erro no metodo SALVAR na classe PassagemDAO" + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Passagem entity) {
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
            System.out.println("Erro no metodo ATUALIZAR na classe PassagemDAO" + e.getMessage());
            return false;
        }
    }

    public boolean remover(long id) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            Passagem entity = em.find(Passagem.class, id);
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo REMOVER na classe PassagemDAO" + e.getMessage());
            return false;
        }
    }

    public Passagem buscarID(long idPassagem) {
        try {
            em = JPAUtil.getEntityManager();
            Passagem entity = em.find(Passagem.class, idPassagem);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo BUSCAR_ID na classe PassagemDAO" + e.getMessage());
            return null;
        }
    }

    public List<Passagem> buscarTodos() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Passagem> query = em.createQuery("SELECT obj FROM Passagem obj", Passagem.class);
            List<Passagem> Passagens = query.getResultList();
            return Passagens;
        } catch (RuntimeException e) {
        	System.out.println("Erro no metodo BUSCAR_TODOS na classe PassagemDAO" + e.getMessage());
            return null;
        }
    }

    public Passagem buscarIdPessoa(long passagem, long passageiro) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Passagem> query = em.createQuery("SELECT obj FROM Passagem obj JOIN obj.idpassageiro h WHERE obj.idpassagem = :idReserva AND h.idPessoa = :idPessoa", Passagem.class);
            query.setParameter("idReserva", passagem);
            query.setParameter("idPessoa", passageiro);
            return query.getSingleResult();
        }catch (RuntimeException e) {
        	System.out.println("Erro no método BUSCAR_ID_PESSOA na classe ReservaDAO" + e.getMessage());
            return null;
        }
    }
}
