package com.zapaticosCorp.PagEventos.email.service;

import com.zapaticosCorp.PagEventos.email.dto.EmailDto;
import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Scanner;

@Service
public class EmailService {

    private Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @EventListener
    public void sendEmail(EmailDto usuario){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("ZapaticosCorp");
            helper.setTo(usuario.getEmail());
            helper.setSubject("Sentimos mucho tu salida 😢");

            String contenidoHtml = cargarContenidoHtml();
            helper.setText(contenidoHtml, true);
            helper.addInline("logo", new ClassPathResource("static/sad.jpg"));

            javaMailSender.send(message);
            logger.info("Correo Enviado correctamente a {}", usuario.getEmail());
        } catch (Exception e) {
            logger.error("el error obtenido fue: {}", e.getMessage());
        }
    }

    private String cargarContenidoHtml() throws IOException {
        ClassPathResource resource = new ClassPathResource("templates/email.html");
        try (InputStream inputStream = resource.getInputStream()){
            Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
            String contenidoHtml = scanner.useDelimiter("\\A").next();
            scanner.close();
            return contenidoHtml;
        } catch (Exception e) {
            logger.error("Error al cargar html {}", e.getMessage());
            return "Error al cargar html";
        }
    }
}

