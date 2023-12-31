package com.example.front.controller;

import com.example.front.app.Helper;
import com.example.front.app.User;
import com.example.front.tools.JsonReader;
import com.example.front.util.CookieMgr;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login-log", value = "/login-log")
public class LoginLogController extends HttpServlet {
    Helper helper = Helper.getHelper();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = CookieMgr.getUser(request);
        if (user == null) {
            request.getRequestDispatcher("404.html").forward(request, response);
            return;
        }

        JSONArray ja = helper.selectLoginLogById(user.getId());
        request.setAttribute("ja", ja);
        request.setAttribute("user", user);
        request.getRequestDispatcher("login-log.jsp").forward(request, response);
    }


    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();
        int id = jso.getInt("id");

        helper.deleteLoginLog(id);

        String resp = "{\"status\": 200, \"message\": \"Delete successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void destroy() {
    }
}
