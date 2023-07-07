package dao;

import classes.Pessoa;
import util.JPAUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PessoaDAO {

    private EntityManager em;

    public PessoaDAO() {
    }

    public boolean salvar(Pessoa entity) {
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
            System.out.println("Erro no metodo SALVAR na classe PessoaDAO" + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Pessoa entity) {
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
            System.out.println("Erro no metodo ATUALIZAR na classe PessoaDAO" + e.getMessage());
            return false;
        }
    }

    public boolean remover(long id) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            Pessoa entity = em.find(Pessoa.class, id);
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo REMOVER na classe PessoaDAO" + e.getMessage());
            return false;
        }
    }

    public Pessoa buscarID(long id) {
        try {
            em = JPAUtil.getEntityManager();
            Pessoa entity = em.find(Pessoa.class, id);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo BUSCAR_ID na classe PessoaDAO" + e.getMessage());
            return null;
        }
    }

    public List<Pessoa> buscarTodos() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Pessoa> query = em.createQuery("SELECT obj FROM Pessoa obj", Pessoa.class);
            List<Pessoa> Pessoas = query.getResultList();
            return Pessoas;
        } catch (RuntimeException e) {
        	System.out.println("Erro no metodo BUSCAR_TODOS na classe PessoaDAO" + e.getMessage());
            return null;
        }
    }
}