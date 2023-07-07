package dao;

import classes.Aeroporto;
import util.JPAUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AeroportoDAO {

    private EntityManager em;

    public AeroportoDAO() {
    }

    public boolean salvar(Aeroporto entity) {
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
            System.out.println("Erro no método SALVAR na classe AeroportoDAO" + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Aeroporto entity) {
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
            System.out.println("Erro no metodo ATUALIZAR na classe AeroportoDAO" + e.getMessage());
            return false;
        }
    }

    public boolean remover(long id) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            Aeroporto entity = em.find(Aeroporto.class, id);
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo REMOVER na classe AeroportoDAO" + e.getMessage());
            return false;
        }
    }

    public Aeroporto buscarID(long id) {
        try {
            em = JPAUtil.getEntityManager();
            Aeroporto entity = em.find(Aeroporto.class, id);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Erro no metodo BUSCAR_ID na classe AeroportoDAO" + e.getMessage());
            return null;
        }
    }

    public Aeroporto buscarIdQuarto(long aeroporto, long voo) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Aeroporto> query = em.createQuery("SELECT q.aeroporto\n" +
                    "FROM Voo q\n" +
                    "WHERE q.classificacao.idClassificacao = :idAeroporto q.idVoo = :idVoo", Aeroporto.class);
            query.setParameter("idAeroporto", aeroporto);
            query.setParameter("idVoo", voo);
            return query.getSingleResult();
        }catch (RuntimeException e) {
        	System.out.println("Erro no metodo BUSCAR_ID_VOO na classe AeroportoDAO" + e.getMessage());
            return null;
        }
    }


    public List<Aeroporto> buscarPorCidade(String cidade) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Aeroporto> query = em.createQuery("SELECT obj FROM Aeroporto obj WHERE obj.cidade = :cidade", Aeroporto.class);
            query.setParameter("cidade", cidade);
            List<Aeroporto> classificacoes = query.getResultList();
            return classificacoes;
        } catch (RuntimeException e) {
        	System.out.println("Erro no metodo BUSCAR_POR_CIDADE na classe AeroportoDAO" + e.getMessage());
            return null;
        }
    }

}
