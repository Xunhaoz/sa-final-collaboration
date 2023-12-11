package com.example.front.controller;

import com.example.front.app.Audio;
import com.example.front.app.Helper;
import com.example.front.tools.JsonReader;
import com.example.front.tools.Poster;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "judge", value = "/judge")
public class JudgeController extends HttpServlet {
    Helper helper = Helper.getHelper();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();
        JSONObject resFromPython = null;

        int audioId = jso.getInt("id");
        Audio audio = helper.selectAudioById(audioId);

        try {
            String url = "http://localhost:5000/liveabc-mentorai/build-template";
            String res = Poster.sendPostRequest(url, audio.getText(), audio.getPath());
            resFromPython = new JSONObject(res);
            helper.updateAudioFeature(audioId, resFromPython.getString("token"));
        } catch (Exception e) {
            e.printStackTrace();
            String errorResp = "{\"status\": 500, \"message\": \"Feature Extract Error.\", \"response\": \"\"}";
            jsr.response(errorResp, response);
            return;
        }
        String errorResp = "{\"status\": 200, \"message\": \"Feature Extract Success.\", \"response\": \"\"}";
        jsr.response(errorResp, response);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void destroy() {

    }
}
