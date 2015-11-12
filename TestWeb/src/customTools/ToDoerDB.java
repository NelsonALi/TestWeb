package customTools;

import java.util.ArrayList;
import java.util.List;

//import java.util.LinkedList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.*;

public class ToDoerDB {

	public static void insert(Todoer doer) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(doer);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Todoer doer) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(doer);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Todoer doer) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(doer));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<Todoer> selectAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Todoer> tList = new ArrayList<Todoer>();
		String qString = "select e from TTodoer e";
		TypedQuery<Todoer> q = (TypedQuery<Todoer>) em.createQuery(qString, Todoer.class);
		try {
			q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return tList;
	}
	
	public static Todoer getDoerById(int TodoerId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select e from Todoer e where e.id = :TodoerId";
		TypedQuery<Todoer> q = (TypedQuery<Todoer>) em.createQuery(qString, Todoer.class);
		Todoer tTodoer = null;
		try {
			tTodoer = q.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return tTodoer;
	}
	
	public static boolean doerExist(String loginName) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		boolean TodoerExist = false;
		String qString = "select e from Todoer e where e.name = :loginName";
		TypedQuery<Todoer> q = (TypedQuery<Todoer>) em.createQuery(qString, Todoer.class);
		q.setParameter("loginName", loginName);
		Todoer tTodoer = null;
		try {
			tTodoer = q.getSingleResult();
			if (tTodoer != null) TodoerExist = true;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return TodoerExist ;
	}
	public static Todoer getTodoerByName(String loginName) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		String qString = "select e from Todoer e where e.name = :loginName";
		TypedQuery<Todoer> q = (TypedQuery<Todoer>) em.createQuery(qString, Todoer.class);
		q.setParameter("loginName", loginName);
		Todoer todoer = null;
		try {
			todoer = q.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return todoer ;
	}	 
}