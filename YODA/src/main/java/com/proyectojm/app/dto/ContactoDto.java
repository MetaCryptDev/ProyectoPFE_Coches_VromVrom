package com.proyectojm.app.dto;

import java.io.Serializable;

public class ContactoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nombre;
    private String mail;
    private String motivo;
    private String mensaje;

    public ContactoDto() {
        super();
    }

    public ContactoDto(Integer id, String nombre, String mail, String motivo, String mensaje) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.mail = mail;
        this.motivo = motivo;
        this.mensaje = mensaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
