package com.example.front.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.front.app.*;
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
import java.util.Objects;

@WebServlet(name = "class", value = "/class")
public class ClassController extends HttpServlet {
    private Helper helper = Helper.getHelper();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = CookieMgr.getUser(request);
        if (user == null) {
            request.getRequestDispatcher("404.html").forward(request, response);
            return;
        }

        int classId = -1;
        try {
            classId = Integer.parseInt(request.getParameter("class"));
        } catch (Exception ignore) {
            request.getRequestDispatcher("404.html").forward(request, response);
            return;
        }

        Course course = new Course(classId);
        JSONArray audio = helper.selectAudio(classId);

        request.setAttribute("audio", audio);
        request.setAttribute("course", course);
        request.setAttribute("user", user);

        if (user.getIdentity()) {
            request.getRequestDispatcher("ai-course.jsp").forward(request, response);
        } else {
            request.setAttribute("score", helper.selectScoreByIdClass(user.getId(), classId));
            request.getRequestDispatcher("ai-course-student.jsp").forward(request, response);
        }
    }


    public void destroy() {
    }
}
