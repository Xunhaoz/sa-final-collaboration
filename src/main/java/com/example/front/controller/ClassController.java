package com.example.front.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.front.app.Course;
import com.example.front.app.Helper;
import com.example.front.app.User;
import com.example.front.app.Validation;
import com.example.front.tools.JsonReader;

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
        JsonReader jsr = new JsonReader(request);
        JWT jwt = JWTUtil.parseToken(authority);

        Course course = null;
        int userId = Integer.parseInt(jwt.getPayload("id").toString()), classId;
        String className = request.getParameter("class");

        try {
            classId = Integer.parseInt(className);
            course = helper.selectCourseById(classId);
            Objects.requireNonNull(course);
        } catch (Exception ignored) {
            request.getRequestDispatcher("404.html").forward(request, response);
            return;
        }

        User user = helper.selectUserById(userId);

        System.out.printf(course.toString());
        request.setAttribute("course", course);
        if (user.getIdentity()) {
            request.getRequestDispatcher("ai-course.jsp").forward(request, response);
        }
        request.getRequestDispatcher("ai-course-student.html").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }


    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }


    public void destroy() {
    }
}
