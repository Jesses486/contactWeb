package fr.gtm.contacts.services;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManagerFactory;

import fr.gtm.contacts.dao.ContactDao;
import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.entities.Contact;

public class ContactServices {
	private ContactDao dao;
	
	public ContactServices(EntityManagerFactory emf) {
		dao = new ContactDao(emf);
	}

	public void createContact(Contact contact) {
		dao.createContact(contact);
	}
	
	public void deleteContact(String id) {
		dao.deleteContact(id);
	}
	
	public void updateContact(Contact contact) {
		dao.updateContact(contact);
	}
	
	public List<Contact> getContactByNom(String nom) {
		return dao.getContactByNom(nom);
	}
	
	public List<Contact> getContactByAdresseNotNull() {
		return dao.getContactByAdresseNotNull();
	}
	
	public List<Contact> getAllContact() {
		return dao.getAllContact();
	}
	
	public Set<Adresse> getAllAdresses(String id) {
		return dao.getAllAdresses(id);
	}
	
	public Contact getContactById(String id) {
		return dao.getContactById(id);
	}
}
