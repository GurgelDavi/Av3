package com.davi.av3.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.davi.av3.impl.ContactDaoImpl;
import com.davi.av3.model.Contact;

@ManagedBean(name="contactView")
public class ContactView implements Serializable{
	
	private static final long serialVersionUID = 5373823767595263175L;
	private Contact selected = new Contact();
	private String selectedContactId;
	private ContactDaoImpl cFacetes = new ContactDaoImpl();
	public String getTest() {
		return "teste";
	}
	public List getAllContacts() {
		return cFacetes.getAllContacts(null);
	}
	public String editContactDetails(){
		return "/contactEdit.xhtml";
	}
	public void editContact(){
		cFacetes.alter(selected);
	}
	public String deleteContact(){
		cFacetes.remove(selected);
		return "/contactList.xhtml";
		
	}
	public Contact getSelected() {
		return selected;
	}
	public void setSelected(Contact selected) {
		this.selected = selected;
	}
	public ContactDaoImpl getcFacetes() {
		return cFacetes;
	}
	public void setcFacetes(ContactDaoImpl cFacetes) {
		this.cFacetes = cFacetes;
	}
	
}
