package com.example.front.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.front.app.Helper;
import com.example.front.app.StudentCourse;
import com.example.front.app.Validation;
import com.example.front.tools.JsonReader;
import org.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "student-course", value = "/student-course")
public class StudentCourseController extends HttpServlet {

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();
        String authority = Validation.validCookie(request);
        JWT jwt = JWTUtil.parseToken(authority);

        int userId = Integer.parseInt(jwt.getPayload("id").toString());
        int courseId = jso.getInt("id");

        StudentCourse studentCourse = new StudentCourse(userId, courseId, "create");

        String resp = "{\"status\": 200, \"message\": \"Delete successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();
        String authority = Validation.validCookie(request);
        JWT jwt = JWTUtil.parseToken(authority);

        int userId = Integer.parseInt(jwt.getPayload("id").toString());
        int courseId = jso.getInt("id");

        StudentCourse studentCourse = new StudentCourse(userId, courseId, "delete");

        String resp = "{\"status\": 200, \"message\": \"Delete successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void destroy() {
    }
}
