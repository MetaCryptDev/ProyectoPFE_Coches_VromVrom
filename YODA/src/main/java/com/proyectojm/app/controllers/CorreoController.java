package com.proyectojm.app.controllers;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

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
    
    public void correoContacto(String mensaje, String email, String motivo, String nombre) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo(email);
            helper.setSubject("Consulta: " + motivo + ". Talleres YoDa");
            helper.setText("¡Hola, " + nombre + "! \n"
            		+ "Gracias por ponerte en contacto con nosotros, hemos recibido la siguiente consulta: \n" 
            		+ motivo + "\n" 
            		+ mensaje + "\n"
            		+ "Intentaremos resolver tu consulta a la mayor brevedad posible.");

            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
