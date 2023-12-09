package com.example.front.controller;

import com.example.front.app.Course;
import com.example.front.app.Helper;
import com.example.front.tools.JsonReader;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "course", value = "/course")
public class CourseController extends HttpServlet {
    Helper helper = Helper.getHelper();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        String courseId = request.getHeader("id");
        if (courseId != null && !courseId.isEmpty()) {
            Course course = helper.selectCourseById(Integer.parseInt(courseId));
            JSONObject resp = new JSONObject();
            resp.put("status", 200);
            resp.put("message", "Select successful.");
            resp.put("response", course.getObject());
            jsr.response(resp, response);
            return;
        }

        JSONArray jsonArray = helper.selectCourse();
        request.setAttribute("courseList", jsonArray);
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

    public void destroy() {
    }
}
