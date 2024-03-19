package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia")
    @SequenceGenerator(name = "secuencia", allocationSize = 1, sequenceName = "SEQ_USUARIO")
    @Id
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "PASSWD")
    private String passwd;

    @Column(name = "ROL")
    private Integer rol;



    // Constructor vacío
    public UsuarioEntity() {
    }

    // Constructor con todos los campos
    public UsuarioEntity(Integer idUsuario, String nombre, String apellido, String telefono, String mail, String passwd,
			Integer rol) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
		this.passwd = passwd;
		this.rol = rol;
	}

    // Getters y setters
    public Integer getIdUsuario() {
        return idUsuario;
    }

	public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }
}