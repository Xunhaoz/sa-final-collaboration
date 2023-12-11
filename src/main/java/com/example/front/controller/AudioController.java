package com.example.front.controller;

import cn.hutool.jwt.*;
import com.example.front.app.*;
import com.example.front.tools.JsonReader;
import com.example.front.tools.Poster;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "audio", value = "/audio")
public class AudioController extends HttpServlet {
    Helper helper = Helper.getHelper();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        int audioId = Integer.parseInt(request.getHeader("id"));

        Audio audio = helper.selectAudioById(audioId);
        JSONObject resp = new JSONObject();

        resp.put("status", 200);
        resp.put("message", "Select Successful.");
        resp.put("response", audio.getJSONObject());
        jsr.response(resp, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();
        String authority = Validation.validCookie(request);
        JWT jwt = JWTUtil.parseToken(authority);

        String appPath = request.getServletContext().getRealPath("");
        int userId = Integer.parseInt(jwt.getPayload("id").toString());
        int classId = jso.getInt("classId");
        String audio = jso.getString("audio");

        if (jso.has("text")) {
            String text = jso.getString("text");
            try {
                String filePath = appPath + File.separator + "audio" + File.separator + generateRandomWindowsFileName() + ".wav";
                decodeBase64Audio(audio, filePath);
                Audio audioObj = new Audio(classId, userId, text, filePath);
                String resp = "{\"status\": 200, \"message\": \"Upload successful.\", \"response\": \"\"}";
                jsr.response(resp, response);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                String errorResp = "{\"status\": 500, \"message\": \"Internal Server Error.\", \"response\": \"\"}";
                jsr.response(errorResp, response);
                return;
            }
        }

        int audioId = jso.getInt("audioId");
        Audio audioParents = helper.selectAudioById(audioId);
        try {
            String filePath = appPath + File.separator + "audio" + File.separator + generateRandomWindowsFileName() + ".wav";
            decodeBase64Audio(audio, filePath);
            Audio audioObj = new Audio(classId, userId, audioId, audioParents.getText(), filePath);
            ScoreTable scoreTable = judgeAudio(audioParents.getFeatureToken(), filePath, userId);
            JSONObject resp = new JSONObject();
            resp.put("status", 200);
            resp.put("message", "judge successful");
            resp.put("response", scoreTable.getObject());
            jsr.response(resp, response);
        } catch (Exception e) {
            e.printStackTrace();
            String errorResp = "{\"status\": 500, \"message\": \"Internal Server Error.\", \"response\": \"\"}";
            jsr.response(errorResp, response);
        }
    }


    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();
        try {
            int id = jso.getInt("id");
            String text = jso.getString("text");
            String audio = jso.getString("audio");

            String appPath = request.getServletContext().getRealPath("");
            String filePath = appPath + File.separator + "audio" + File.separator + generateRandomWindowsFileName() + ".wav";
            decodeBase64Audio(audio, filePath);

            Audio audioObj = new Audio(id, text, filePath);

            String resp = "{\"status\": 200, \"message\": \"Update successful.\", \"response\": \"\"}";
            jsr.response(resp, response);
        } catch (Exception e) {
            e.printStackTrace();
            String errorResp = "{\"status\": 500, \"message\": \"Internal Server Error.\", \"response\": \"\"}";
            jsr.response(errorResp, response);
        }
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        int audioId = jso.getInt("id");
        helper.deleteAudio(audioId);

        String resp = "{\"status\": 200, \"message\": \"Delete successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }


    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static void decodeBase64Audio(String base64AudioString, String outputPath) throws IOException {

        base64AudioString = base64AudioString.contains(",") ? base64AudioString.split(",")[1] : base64AudioString;
        byte[] decodedBytes = Base64.getDecoder().decode(base64AudioString);

        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            fos.write(decodedBytes);
        }
    }

    private static String generateRandomWindowsFileName() {
        int length = 10;  // 設定檔案名稱的長度
        StringBuilder randomFileName = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomChar = ALLOWED_CHARACTERS.charAt(index);
            randomFileName.append(randomChar);
        }
        return randomFileName.toString();
    }

    public void destroy() {

    }

    public ScoreTable judgeAudio(String token, String audioPath, int userId) {
        Audio audio = helper.selectAudioByPath(audioPath);
        String url = "http://localhost:5000/liveabc-mentorai/evaluate-student";
        JSONObject resFromPython = null;

        try {
            String res = Poster.sendPostRequest(url, token, audioPath);
            resFromPython = new JSONObject(res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(resFromPython.toString());
        JSONObject part = (JSONObject) resFromPython.getJSONArray("part").get(0);
        JSONObject overall = resFromPython.getJSONObject("overall");
        ScoreTable scoreTable = new ScoreTable(
                userId,
                audio.getId(),
                overall.getInt("final_score"),
                overall.getJSONObject("index_score").getInt("intonation"),
                overall.getJSONObject("index_score").getInt("pronunciation"),
                overall.getJSONObject("index_score").getInt("phrasing"),
                overall.getJSONObject("index_score").getInt("loudness"),
                overall.getJSONObject("index_score").getInt("rhythm"),
                overall.getJSONObject("index_score").getInt("speed"),
                part.getJSONObject("feedback").getString("intonation"),
                part.getJSONObject("feedback").getString("pronunciation"),
                part.getJSONObject("feedback").getString("phrasing"),
                part.getJSONObject("feedback").getString("loudness"),
                part.getJSONObject("feedback").getString("rhythm"),
                part.getJSONObject("feedback").getString("speed")
        );
        return scoreTable;
    }
}
