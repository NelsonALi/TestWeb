package customTools;

	import java.util.ArrayList;
import java.util.List;

	import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.*;

	public class StatusDB {

		public static void insert(Status aStatus) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.persist(aStatus);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void update(Status aStatus) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.merge(aStatus);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void delete(Status aStatus) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.remove(em.merge(aStatus));
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}
		public static List<Status> selectAll() {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			List<Status> tList = new ArrayList<Status>();
			String qString = "select e from Status e";
			TypedQuery<Status> q = (TypedQuery<Status>) em.createQuery(qString, Status.class);
			try {
				q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return tList;
		}
		
		public static Status getStatusById(int statusId) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Status e where e.id = :statusId";
			TypedQuery<Status> q = (TypedQuery<Status>) em.createQuery(qString, Status.class);
			Status status = null;
			try {
				status = q.getSingleResult();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return status;
		}
				
	}