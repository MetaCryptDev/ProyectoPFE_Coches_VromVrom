package com.proyectojm.app.dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private String mail;
    private String passwd;
    private Integer rol;

    public UsuarioDto() {
        super();
    }

    public UsuarioDto(Integer idUsuario, String nombre, String apellido, String telefono, String mail, String passwd, Integer rol) {
        super();
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.passwd = passwd;
        this.rol = rol;
    }

    public Integer getRol() {
		return rol;
	}

	public void setRol(Integer rol) {
		this.rol = rol;
	}

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
}
