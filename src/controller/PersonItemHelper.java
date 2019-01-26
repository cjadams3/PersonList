package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.PersonItem;

public class PersonItemHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PersonList");
	
	public void InsertItem(PersonItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PersonItem> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<PersonItem> allItems = em.createQuery("SELECT i FROM PersonItem i").getResultList();
		return allItems;
	}
	
	public void DeleteItem(String toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PersonItem> typedQuery = em.createQuery("SELECT li FROM "
		+ "PersonItem li where li.name = :selectedName", PersonItem.class);
		
		typedQuery.setParameter("selectedName",toDelete);
		
		typedQuery.setMaxResults(1);
		
		PersonItem result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public PersonItem searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PersonItem found = em.find(PersonItem.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<PersonItem> getItemsByName(String name) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PersonItem> typedQuery = em.createQuery("SELECT li FROM "
				+ "PersonItem li where li.name = :selectedName", PersonItem.class);
		
		typedQuery.setParameter("selectedName", name);
		List<PersonItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
		
	}
	
	public void updateItem(PersonItem toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
