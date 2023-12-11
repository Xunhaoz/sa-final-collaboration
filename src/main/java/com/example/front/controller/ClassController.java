package com.example.front.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.front.app.Course;
import com.example.front.app.Helper;
import com.example.front.app.User;
import com.example.front.app.Validation;
import com.example.front.tools.JsonReader;
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
    Helper helper = Helper.getHelper();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String authority = Validation.validCookie(request);
        JWT jwt = JWTUtil.parseToken(authority);

        int userId = Integer.parseInt(jwt.getPayload("id").toString());
        int classId = -1;

        try {
            classId = Integer.parseInt(request.getParameter("class"));
        } catch (Exception ignore) {
            request.getRequestDispatcher("404.html").forward(request, response);
            return;
        }

        User user = helper.selectUserById(userId);
        Course course = helper.selectCourseById(classId);
        JSONArray audio = helper.selectAudio(classId);

        request.setAttribute("audio", audio);
        request.setAttribute("course", course);
        request.setAttribute("user", user);

        if (user.getIdentity()){
            request.getRequestDispatcher("ai-course.jsp").forward(request, response);
        } else {
            request.setAttribute("score", helper.selectScoreById(userId));
            request.getRequestDispatcher("ai-course-student.jsp").forward(request, response);
        }
    }


    public void destroy() {
    }
}
