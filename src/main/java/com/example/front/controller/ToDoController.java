package com.example.front.controller;

import com.example.front.app.*;
import com.example.front.tools.*;
import org.json.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "todo", value = "/todo")
public class ToDoController extends HttpServlet {
    ToDoHelper tdh = ToDoHelper.getHelper();

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JSONObject jso = tdh.selectAll();
        request.setAttribute("jsoData", jso.getJSONArray("data"));
        request.getRequestDispatcher("to-do-list.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        String createTopic = jso.getString("create_topic");
        String createContent = jso.getString("create_content");

        ToDo todo = new ToDo(createTopic, createContent);
        String resp = "{\"status\": 200, \"message\": \"create successful\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        int id = jso.getInt("update_id");
        String createTopic = jso.getString("update_topic");
        String createContent = jso.getString("update_content");

        ToDo todo = new ToDo(id, createTopic, createContent);
        String resp = "{\"status\": 200, \"message\": \"update successful\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        int id = jso.getInt("delete_id");
        ToDo todo = new ToDo(id);
        String resp = "{\"status\": 200, \"message\": \"delete successful\", \"response\": \"\"}";
        jsr.response(resp, response);
    }

    public void destroy() {
    }
}