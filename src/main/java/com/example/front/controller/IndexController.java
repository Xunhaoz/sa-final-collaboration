package com.example.front.controller;


import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.jwt.*;
import com.example.front.app.Helper;
import com.example.front.app.LoginLog;
import com.example.front.app.User;
import com.example.front.tools.JsonReader;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import javax.servlet.http.HttpServlet;

@WebServlet(name = "index", value = "/index")
public class IndexController extends HttpServlet {

    Helper helper = Helper.getHelper();

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        String email = jso.getString("email");
        String password = jso.getString("password");
        Boolean remember = jso.getBoolean("remember");
        String os = jso.getString("os");
        String browser = jso.getString("browser");
        String ip = jso.getString("ip");

        if (email.isEmpty() || password.isEmpty() || remember.toString().isEmpty() || browser.isEmpty() || os.isEmpty() || ip.isEmpty()) {
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

        if (!BCrypt.hashpw(password, user.getSalt()).equals(user.getPassword())) {
            String resp = "{\"status\": 401, \"message\": \"Password is not correct.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        DateTime now = DateTime.now();
        DateTime newTime = now.offsetNew(DateField.MINUTE, 10);

        Map<String, Object> payload = new HashMap<>();
        payload.put(JWTPayload.ISSUED_AT, now);
        payload.put(JWTPayload.EXPIRES_AT, newTime);
        payload.put(JWTPayload.NOT_BEFORE, now);

        payload.put("id", user.getId());
        String token = JWTUtil.createToken(payload, user.getSalt().getBytes());
        new LoginLog(token.substring(0, 20), ip, browser, os);

        if (remember) {
            Cookie jwt = new Cookie("Authority", token);
            response.addCookie(jwt);
        }

        String resp = "{\"status\": 200, \"message\": \"Login successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void destroy() {
    }
}
