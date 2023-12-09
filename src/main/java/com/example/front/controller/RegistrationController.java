package com.example.front.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import cn.hutool.core.lang.Validator;
import cn.hutool.crypto.digest.BCrypt;
import com.example.front.app.Helper;
import org.json.*;
import com.example.front.tools.JsonReader;

import com.example.front.app.User;

@WebServlet(name = "registration", value = "/registration")
public class RegistrationController extends HttpServlet {
    private Helper helper = Helper.getHelper();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register.html").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        String firstName = jso.getString("firstName");
        String lastName = jso.getString("lastName");
        String email = jso.getString("email");
        String password = jso.getString("password");
        String confirmPassword = jso.getString("confirmPassword");
        Boolean identity = jso.getBoolean("identity");

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || identity.toString().isEmpty()) {
            String resp = "{\"status\": 422, \"message\": \"All blank should be filled.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        if (!confirmPassword.equals(password)) {
            String resp = "{\"status\": 400, \"message\": \"Confirm password is not equal to password.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }


        if (firstName.length() > 30) {
            String resp = "{\"status\": 422, \"message\": \"Firstname is too long.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        if (lastName.length() > 30) {
            String resp = "{\"status\": 422, \"message\": \"LastName is too long.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        if (password.length() > 30) {
            String resp = "{\"status\": 422, \"message\": \"Password is longer 30 character.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        } else if (password.length() < 8) {
            String resp = "{\"status\": 422, \"message\": \"Password is shorter than 8 character.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        if (!Validator.isEmail(email)) {
            String resp = "{\"status\": 422, \"message\": \"Email is not valid.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        User user = helper.selectUserByEmail(email);
        if(user != null){
            String resp = "{\"status\": 409, \"message\": \"User exists.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        String salt = BCrypt.gensalt();
        password = BCrypt.hashpw(password, salt);
        user = new User(firstName, lastName, email, password, identity, salt);
        String resp = "{\"status\": 200, \"message\": \"Registration is success.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void destroy() {
    }
}
