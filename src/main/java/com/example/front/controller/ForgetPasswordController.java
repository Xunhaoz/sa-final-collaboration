package com.example.front.controller;


import cn.hutool.crypto.digest.BCrypt;
import com.example.front.app.Helper;
import com.example.front.app.User;
import com.example.front.tools.JsonReader;
import com.example.front.app.Auth;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;


@WebServlet(name = "forgetPassword", value = "/forget-password")
public class ForgetPasswordController extends HttpServlet {

    Helper helper = Helper.getHelper();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("forgot-password.html").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        String email = jso.getString("email");

        if (email.isEmpty()) {
            String resp = "{\"status\": 422, \"message\": \"All blank should be filled.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        User user = helper.selectUserByEmail(email);
        if (user == null) {
            String resp = "{\"status\": 417, \"message\": \"User does not exist.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        String newPassword = BCrypt.hashpw(user.getPassword(), user.getSalt());
        new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), newPassword, user.getIdentity());

        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.debug", "true");

        Auth auth = new Auth("leo20020529@gmail.com", "revtexjpeqwjqflo");
        Session session = Session.getDefaultInstance(prop, auth);
        MimeMessage message = new MimeMessage(session);


        try {
            String msg = "Hello [User],\nWe received a request to reset your password. Here’s your new password [new-password].";
            msg = msg.replace("[User]", (user.getFirstName() + " " + user.getLastName()));
            msg = msg.replace("[new-password]", newPassword);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Your Password Genie");
            message.setContent(msg, "text/html;charset = UTF-8");
            Transport transport = session.getTransport();
            Transport.send(message);
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        String resp = "{\"status\": 200, \"message\": \"Email send successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void destroy() {
    }
}
