package com.example.front.controller;

import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.front.app.Helper;
import com.example.front.app.User;
import com.example.front.tools.JsonReader;
import com.example.front.tools.RespMaker;
import com.example.front.util.CookieMgr;
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
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = CookieMgr.getUser(request);

        if (user == null) {
            request.getRequestDispatcher("404.html").forward(request, response);
            return;
        }

        request.setAttribute("user", user);
        request.getRequestDispatcher("personal-info.jsp").forward(request, response);
    }


    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        String email = jso.getString("email");
        String firstName = jso.getString("firstName");
        String lastName = jso.getString("lastName");
        String password = jso.getString("password");
        Boolean identity = jso.getBoolean("identity");

        User oldData = CookieMgr.getUser(request);


        if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || identity.toString().isEmpty()) {
            jsr.response(RespMaker.makeResp(422, "All blank should be filled.", null), response);
            return;
        }

        if (oldData == null) {
            jsr.response(RespMaker.makeResp(422, "User not Found.", null), response);
            return;
        }

        if (password.isEmpty()) {
            new User(oldData.getId(), firstName, lastName, email, identity);
        } else {
            password = BCrypt.hashpw(password, oldData.getSalt());
            new User(oldData.getId(), firstName, lastName, email, password, identity);
        }

        jsr.response(RespMaker.makeResp(200, "Update successful.", null), response);
    }

    public void destroy() {
    }
}
