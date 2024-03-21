package com.proyectojm.app.controllers;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.proyectojm.app.dto.ContactoDto;
import com.proyectojm.app.dto.ServicioDto;
import com.proyectojm.app.dto.UsuarioDto;
import com.proyectojm.app.entities.CitaEntity;
import com.proyectojm.app.service.IServiceServicio;
import com.proyectojm.app.service.IServiceUsuario;

@Component
public class CorreoController {

    private final JavaMailSender javaMailSender;
    final String correoTaller = "talleresyoda@gmail.com";
    
    @Autowired
	private IServiceUsuario usuarioService;
    
    @Autowired
    private IServiceServicio servicioService;

    public CorreoController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    //CORREO CITA PARA EL USUARIO
    public void enviarCorreo(CitaEntity cita) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        
        UsuarioDto usuario = usuarioService.recuperarUnUsuario(Integer.parseInt(cita.getUsuarioId()));
        ServicioDto servicio = servicioService.recuperarUnServicio(cita.getServicioId());
        
        try {
            if(cita.getDescripcionAveria() == null || cita.getDescripcionAveria().isEmpty()) {
            	cita.setDescripcionAveria("Avería no especificada");
            }
            
            if(cita.getVehiculoSustitucionMatricula() == null || cita.getVehiculoSustitucionMatricula().isEmpty()) {
        		cita.setVehiculoSustitucionMatricula("Vehículo de sustitución no solicitado.");
        	}
            
            helper.setTo(usuario.getMail());
            helper.setSubject("Talleres YoDa: " + servicio.getNombre() + " " + cita.getEntrada().getDayOfMonth() + "/" + cita.getEntrada().getMonthValue() + " " + cita.getEntrada().getHour() + ":00");
            helper.setText("¡Hola, " + usuario.getNombre() + "!\n"
            		+ "Se ha registrado una cita a nombre de " + usuario.getNombre() + " " + usuario.getApellido() + ", el día " 
            		+ cita.getEntrada().getDayOfMonth() + "/" + cita.getEntrada().getMonthValue() + " a las " + cita.getEntrada().getHour() + ":00. \n\n"
            		+ "Motivo de la cita: \n" + cita.getDescripcionAveria() + "\n\nServicio solicitado:\n" + servicio.getNombre()
            		//+ "\n\nMatrícula:\n" + cita.getVehiculoMatricula()
            		+ "\n\nVehículo de sustitución:\n" + cita.getVehiculoSustitucionMatricula()
            		+ "\n\nSe ruega puntualidad. En caso de no poder asistir a la fecha citada, por favor póngase en contacto con nosotros a través del número 926-586-068 o enviándonos un correo a talleresyoda@gmail.com. \nTambién puede encontrarnos de 9:00 a 13:00 y de 15:00 a 19:00 en Calle Miguel de Cervantes, 17, Manzanares."
            		+ "\n\n¡Gracias por elegirnos!\nTalleres YoDa");

            javaMailSender.send(mimeMessage);
            citaTaller(cita, servicio, usuario);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    //CORREO CITA PARA EL TALLER
    public void citaTaller(CitaEntity cita, ServicioDto servicio, UsuarioDto usuario) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        
        try {
        	if(cita.getDescripcionAveria() == null || cita.getDescripcionAveria().isEmpty()) {
            	cita.setDescripcionAveria("Avería no especificada");
            }
        	
        	if(cita.getVehiculoSustitucionMatricula() == null || cita.getVehiculoSustitucionMatricula().isEmpty()) {
        		cita.setVehiculoSustitucionMatricula("Vehículo de sustitución no solicitado.");
        	}
        	
            helper.setTo(correoTaller);
            helper.setSubject("Nueva Cita " + cita.getIdCita() + ": " + cita.getEntrada().getDayOfMonth() + "/" + cita.getEntrada().getMonthValue() + " " + cita.getEntrada().getHour() + ":00");
            helper.setText("Se ha registrado una cita a nombre de " + usuario.getNombre() + " " + usuario.getApellido() + ", el día " 
            		+ cita.getEntrada().getDayOfMonth() + "/" + cita.getEntrada().getMonthValue() + " a las " + cita.getEntrada().getHour() + ":00. \n\n"
            		//+ "Matrícula:\n" + cita.getVehiculoMatricula()
            		+ "\n\nMotivo de la cita: \n" + cita.getDescripcionAveria() 
            		+ "\n\nServicio solicitado:\n" + servicio.getNombre()
            		+ "\n\nDuración estimada del servicio:\n" + servicio.getManoDeObra() + " horas"
            		+ "\n\nHora estimada de salida:\n" + cita.getSalida().getHour() + ":00"
            		+ "\n\nVehículo de sustitución:\n" + cita.getVehiculoSustitucionMatricula()
            		);

            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
    //CORREO AL REGISTRARSE
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
    
    
    //CORREO AL HACER UNA CONSULTA EN CONTACTO PARA EL CLIENTE
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
    
  //CORREO AL HACER UNA CONSULTA EN CONTACTO PARA EL TALLER
    public void correoContactoTaller(ContactoDto contacto) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo(correoTaller);
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
