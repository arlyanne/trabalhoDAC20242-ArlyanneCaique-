package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entidades.Jogo;
import util.JPAUtil;

public class JogoDao {

	public static void save(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(jogo);
            transaction.commit();
        } finally {
            em.close();
        }
    }
	

	public static void update(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		EntityTransaction transaction = em.getTransaction();
	        try {
	            transaction.begin();
	            em.merge(jogo);
	            transaction.commit();
	        } finally {
	            em.close();
	        }
	    }
	
	public static void delete(Jogo jogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            jogo = em.find(Jogo.class, jogo.getId());
            em.remove(jogo);
            transaction.commit();
        } finally {
            em.close();
        }
    }
	
	public List<Jogo> listar() {
        EntityManager em = JPAUtil.criarEntityManager();
        TypedQuery<Jogo> query = em.createQuery("SELECT j FROM Jogo j", Jogo.class);
        return query.getResultList();
    }
}
	
