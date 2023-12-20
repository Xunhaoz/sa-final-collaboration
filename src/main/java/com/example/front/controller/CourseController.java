package com.example.front.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.front.app.*;
import com.example.front.tools.JsonReader;
import com.example.front.tools.RespMaker;
import com.example.front.util.CookieMgr;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

@WebServlet(name = "course", value = "/course")
public class CourseController extends HttpServlet {
    Helper helper = Helper.getHelper();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);

        User user = CookieMgr.getUser(request);
        if (user == null) {
            request.getRequestDispatcher("404.html").forward(request, response);
            return;
        }

        String courseId = request.getHeader("id");
        if (courseId != null && !courseId.isEmpty()) {
            Course course = new Course(Integer.parseInt(courseId));
            jsr.response(RespMaker.makeResp(200, "Select successful.", course.getObject()), response);
            return;
        }

        JSONArray jsonArray = helper.selectCourse();
        request.setAttribute("courseList", jsonArray);
        Set<Integer> set = helper.selectStudentCourse();
        request.setAttribute("selectedSet", set);
        request.setAttribute("userIdentity", user.getIdentity());
        request.setAttribute("user", user);
        request.getRequestDispatcher("course-management.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        String title = jso.getString("title");
        String teacher = jso.getString("teacher");
        String content = jso.getString("content");
        String difficult = jso.getString("difficult");
        String midtermString = jso.getString("midtermTime");
        String finalString = jso.getString("finalTime");

        if (title.isEmpty() || teacher.isEmpty() || content.isEmpty() || difficult.isEmpty() || midtermString.isEmpty() || finalString.isEmpty()) {
            String resp = "{\"status\": 422, \"message\": \"All blank should be filled.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date midtermTime = new Date(dateFormat.parse(midtermString).getTime());
            Date finalTime = new Date(dateFormat.parse(finalString).getTime());
            Course course = new Course(title, teacher, content, difficult, midtermTime, finalTime);
        } catch (ParseException e) {
            String resp = "{\"status\": 400, \"message\": \"Format error.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        String resp = "{\"status\": 200, \"message\": \"Create successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        int id = jso.getInt("id");
        helper.deleteCourse(id);

        String resp = "{\"status\": 200, \"message\": \"Delete successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }


    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        Integer id = jso.getInt("id");
        String title = jso.getString("title");
        String teacher = jso.getString("teacher");
        String content = jso.getString("content");
        String difficult = jso.getString("difficult");
        String midtermString = jso.getString("midtermTime");
        String finalString = jso.getString("finalTime");

        if (id.toString().isEmpty() || title.isEmpty() || teacher.isEmpty() || content.isEmpty() || difficult.isEmpty() || midtermString.isEmpty() || finalString.isEmpty()) {
            String resp = "{\"status\": 422, \"message\": \"All blank should be filled.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date midtermTime = new Date(dateFormat.parse(midtermString).getTime());
            Date finalTime = new Date(dateFormat.parse(finalString).getTime());
            Course course = new Course(id, title, teacher, content, difficult, midtermTime, finalTime);
        } catch (ParseException e) {
            String resp = "{\"status\": 400, \"message\": \"Format error.\", \"response\": \"\"}";
            jsr.response(resp, response);
            return;
        }

        String resp = "{\"status\": 200, \"message\": \"Create successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }


    public void destroy() {
    }
}
