package com.proyectojm.app.controllers;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.proyectojm.app.dto.ContactoDto;

@Component
public class CorreoController {

    private final JavaMailSender javaMailSender;

    public CorreoController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarCorreo(String subject, String email, String body) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(body);

            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public void registro(String nombre, String email) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo(email);
            helper.setSubject("Bienvenido a Talleres YoDa");
            helper.setText("¡Hola, " + nombre + "! \n"
            		+ "Tu cuenta ha sido registrada correctamente, ya estás listo para pedir cita cuando lo necesites y aprovechar nuestras ofertas. \n"
            		+ "¡Gracias por elegir nuestro taller!");

            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public void correoContacto(ContactoDto contacto) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo(contacto.getMail());
            helper.setSubject("Consulta: " + contacto.getMotivo() + ". Talleres YoDa");
            helper.setText("¡Hola, " + contacto.getNombre() + "! \n"
            		+ "Gracias por ponerte en contacto con nosotros, hemos recibido la siguiente consulta: \n" 
            		+ contacto.getMotivo() + "\n" 
            		+ contacto.getMensaje() + "\n"
            		+ "Intentaremos resolver tu consulta a la mayor brevedad posible.");

            javaMailSender.send(mimeMessage);
            correoContactoTaller(contacto);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    public void correoContactoTaller(ContactoDto contacto) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo("talleresyoda@gmail.com");
            helper.setSubject("Consulta: " + contacto.getNombre() + " - " + contacto.getMotivo());
            helper.setText("Nueva consulta de " + contacto.getNombre() + "\n"
            		+ "Motivo de la consulta: \n" 
            		+ contacto.getMotivo() + "\n"
            		+ "Mensaje de la consulta: \n" 
            		+ contacto.getMensaje() + "\n"
            		+ "Correo del cliente:" + "\n"
            		+ contacto.getMail());

            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
