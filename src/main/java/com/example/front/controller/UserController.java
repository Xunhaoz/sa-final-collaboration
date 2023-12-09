package com.example.front.controller;

import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.front.app.Helper;
import com.example.front.app.User;
import com.example.front.tools.JsonReader;
import org.json.JSONObject;
import com.example.front.app.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "user", value = "/user")
public class UserController extends HttpServlet {
    Helper helper = Helper.getHelper();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String authority = Validation.validCookie(request);

        JWT jwt = JWTUtil.parseToken(authority);
        int id = Integer.parseInt(jwt.getPayload("id").toString());

        User user = helper.selectUserById(id);
        request.setAttribute("user", user.getObject());

        request.getRequestDispatcher("personal-info.jsp").forward(request, response);

    }


    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String authority = Validation.validCookie(request);
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        JWT jwt = JWTUtil.parseToken(authority);
        int id = Integer.parseInt(jwt.getPayload("id").toString());
        String email = jso.getString("email");
        String firstName = jso.getString("firstName");
        String lastName = jso.getString("lastName");
        String password = jso.getString("password");
        Boolean identity = jso.getBoolean("identity");

        User oldData = helper.selectUserById(id);

        if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || identity.toString().isEmpty()) {
            String resp = "{\"status\": 422, \"message\": \"All blank should be filled.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        if (password.isEmpty()) {
            User user = new User(id, firstName, lastName, email, identity);
        } else {
            password = BCrypt.hashpw(password, oldData.getSalt());
            User user = new User(id, firstName, lastName, email, password, identity);
        }

        String resp = "{\"status\": 200, \"message\": \"Update successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void destroy() {
    }
}
