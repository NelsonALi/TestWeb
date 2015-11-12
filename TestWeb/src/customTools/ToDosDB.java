package customTools;

import java.util.ArrayList;
import java.util.List;

//import java.util.LinkedList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.*;

public class ToDosDB {

	public static void insert(Todo item) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(item);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Todo item) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(item);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Todo item) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(item));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<Todo> selectAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Todo> tList = new ArrayList<Todo>();
		String qString = "select e from TTodo e";
		TypedQuery<Todo> q = (TypedQuery<Todo>) em.createQuery(qString, Todo.class);
		try {
			q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return tList;
	}
	
	public static List<Todo> getTodoByDoerName(String userName) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select e from Todo e where e.user_name = :userName";
		TypedQuery<Todo> q = (TypedQuery<Todo>) em.createQuery(qString, Todo.class);
		List<Todo> tTodo = null;
		try {
			tTodo = q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return tTodo;
	}
	
	public static List<Todo> getTodosByStatus(int statusId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "select e from Todo e where e.status_id = :statusId";
		TypedQuery<Todo> q = (TypedQuery<Todo>) em.createQuery(qString, Todo.class);
		List<Todo> todo = null;
		try {
			todo = q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
		}
		return todo;
	}

}