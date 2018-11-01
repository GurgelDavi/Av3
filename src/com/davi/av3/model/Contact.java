package com.davi.av3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Contato")
@Table(name = "Contatos")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id_contato", nullable = false, unique = true)
	private int id;
	@Column(name = "nome", nullable = false, unique = false)
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

}
