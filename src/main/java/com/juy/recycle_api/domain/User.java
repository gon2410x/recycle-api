package com.juy.recycle_api.domain;

import jakarta.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String user;
	private String email;
	private String password;

	public User(){ }

	public User(String user, String email, String password, Rol rol) {
		super();
		this.user = user;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="rol")
	private Rol rol;

	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
