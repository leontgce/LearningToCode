 package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Musica;
import util.JPAUtil;

public class MusicaDAO {
	public static void salvar(Musica m) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}
	

	public static List<Musica> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select m from Musica m");
		return q.getResultList();	
	}
	
	public static void excluir(Musica m) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		m = em.merge(m);
		em.remove(m);
		em.getTransaction().commit();
		em.close();
	}
	public static void editar(Musica m) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
		em.close();
	}
}


