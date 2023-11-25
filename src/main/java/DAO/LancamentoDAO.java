package DAO;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;

import entites.Lancamento;
import util.JPAUtil;

public class LancamentoDAO {
	public static void salvar(Lancamento lancamento) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		em.persist(lancamento);
		em.getTransaction().commit();
		em.close();
	}
	
	/* public static void deletar(Lancamento lancamento) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		lancamento = em.find(Lancamento.class, lancamento.getId());
		em.remove(lancamento);
		em.getTransaction().commit();
		em.close();
	} */
	
	public static void deletarPorId(Lancamento lancamento) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		
		lancamento = em.find(Lancamento.class, lancamento.getId());
		em.remove(lancamento);
	
		em.getTransaction().commit();
		em.close();
	}
	
	public static Lancamento findById(Integer id) {
		EntityManager em = JPAUtil.createEntityManager();
		Lancamento lancamento = em.find(Lancamento.class, id);
		em.close();
		return lancamento;
	}
	
	public static List<Lancamento> listarTodos(){
		EntityManager em = JPAUtil.createEntityManager();
		Query query = em.createQuery("select lancamento from Lancamento lancamento");
		List<Lancamento> lista = query.getResultList();
		em.close();
		return lista;
	}

}
