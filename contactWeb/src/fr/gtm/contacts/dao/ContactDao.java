package fr.gtm.contacts.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.entities.Civilite;
import fr.gtm.contacts.entities.Contact;

public class ContactDao extends AbstractDAO<Contact, Long>{
	
	public ContactDao(EntityManagerFactory emf) {
		super(emf, Contact.class);
		// TODO Auto-generated constructor stub
	}
	
	public void createContact(Contact contact){
		EntityManager em = getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteContact(String id) {
		EntityManager em = getEmf().createEntityManager();
		em.getTransaction().begin();
		
		Contact contact = em.find(Contact.class, Long.valueOf(id));
		em.remove(contact);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void updateContact(Contact contact) {
		EntityManager em = getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(contact);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Contact> getContactByCivilite(Civilite civilite){
		String sql = "SELECT c FROM Contact c WHERE c.civilite= :civilite";
		EntityManager em = getEmf().createEntityManager();
		List<Contact> contacts = em.createQuery(sql, Contact.class).setParameter("civilite", civilite).getResultList();
		em.close();
		return contacts;
	}
	
	public List<Contact> getContactByNom(String nom){
		EntityManager em = getEmf().createEntityManager();

		List<Contact> contacts = em.createNamedQuery("Contact.getByNom", Contact.class).setParameter("nom", nom+"%").getResultList();
		em.close();
		return contacts;
	}
	
	public List<Contact> getContactByAdresseNotNull(){
		EntityManager em = getEmf().createEntityManager();

		List<Contact> contacts = em.createNamedQuery("Contact.getAdresseNotEmpty", Contact.class).getResultList();
		em.close();
		return contacts;
	}
	
	public List<Contact> getAllContact(){
		EntityManager em = getEmf().createEntityManager();

		List<Contact> contacts = em.createNamedQuery("Contact.getAllContact", Contact.class).getResultList();
		em.close();
		return contacts;
	}
	
	public Set<Adresse> getAllAdresses(String id){
		EntityManager em = getEmf().createEntityManager();
		Contact contact = em.find(Contact.class, Long.valueOf(id));
		Set<Adresse> adresses = new HashSet<Adresse>();
		for(Adresse a : contact.getAdresse()) {
			adresses.add(a);
		}
		em.close();
		return adresses;
	}
	
	public Contact getContactById(String id){
		EntityManager em = getEmf().createEntityManager();
		Contact contact = em.find(Contact.class, Long.valueOf(id));
		em.close();
		return contact;
	}

}
