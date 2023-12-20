package com.example.front.controller;

import com.example.front.app.*;
import com.example.front.tools.JsonReader;
import com.example.front.tools.Poster;
import com.example.front.tools.RespMaker;
import com.example.front.util.CookieMgr;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "audio", value = "/audio")
public class AudioController extends HttpServlet {
    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Helper helper = Helper.getHelper();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        int audioId = Integer.parseInt(request.getHeader("id"));

        Audio audio = helper.selectAudioById(audioId);
        jsr.response(RespMaker.makeResp(200, "Select Successful.", audio.getJSONObject()), response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        User user = CookieMgr.getUser(request);
        int classId = jso.getInt("classId");
        String audio = jso.getString("audio");

        if (Integer.toString(classId).isEmpty() || audio.isEmpty()) {
            jsr.response(RespMaker.makeResp(422, "All blank should be filled.", null), response);
            return;
        }

        if (user == null) {
            jsr.response(RespMaker.makeResp(422, "User not Found.", null), response);
            return;
        }

        String filePath = generateFileName(request);
        decodeBase64Audio(audio, filePath);

        if (jso.has("text")) {
            String text = jso.getString("text");
            new Audio(classId, user.getId(), text, filePath);
            jsr.response(RespMaker.makeResp(200, "Upload successful.", null), response);
            return;
        }

        int audioId = jso.getInt("audioId");
        Audio audioParents = new Audio(audioId);
        new Audio(classId, user.getId(), audioId, audioParents.getText(), filePath);
        ScoreTable scoreTable = judgeAudio(audioParents.getFeatureToken(), filePath, user.getId());
        jsr.response(RespMaker.makeResp(200, "judge successful", scoreTable.getObject()), response);
    }


    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        if (CookieMgr.getUser(request) == null) {
            jsr.response(RespMaker.makeResp(422, "User not Found.", null), response);
            return;
        }


        int id = jso.getInt("id");
        String text = jso.getString("text");
        String audio = jso.getString("audio");

        if (Integer.toString(id).isEmpty() || audio.isEmpty() || text.isEmpty()) {
            jsr.response(RespMaker.makeResp(422, "All blank should be filled.", null), response);
            return;
        }

        String filePath = generateFileName(request);
        decodeBase64Audio(audio, filePath);
        new Audio(id, text, filePath);
        jsr.response(RespMaker.makeResp(200, "Update successful.", null), response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        if (CookieMgr.getUser(request) == null) {
            jsr.response(RespMaker.makeResp(422, "User not Found.", null), response);
            return;
        }

        int audioId = jso.getInt("id");
        helper.deleteAudio(audioId);

        String resp = "{\"status\": 200, \"message\": \"Delete successful.\", \"response\": \"\"}";
        jsr.response(resp, response);
    }


    private static void decodeBase64Audio(String base64AudioString, String outputPath) throws IOException {

        base64AudioString = base64AudioString.contains(",") ? base64AudioString.split(",")[1] : base64AudioString;
        byte[] decodedBytes = Base64.getDecoder().decode(base64AudioString);

        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            fos.write(decodedBytes);
        }
    }

    private static String generateFileName(HttpServletRequest request) {
        String appPath = request.getServletContext().getRealPath("");

        int length = 10;
        StringBuilder randomFileName = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomChar = ALLOWED_CHARACTERS.charAt(index);
            randomFileName.append(randomChar);
        }

        return appPath + File.separator + "audio" + File.separator + randomFileName + ".wav";
    }

    private ScoreTable judgeAudio(String token, String audioPath, int userId) {
        Audio audio = helper.selectAudioByPath(audioPath);
        String url = "http://judge.nevercareu.space/liveabc-mentorai/evaluate-student";
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
        ScoreTable scoreTable = new ScoreTable(userId, audio.getId(), overall.getInt("final_score"), overall.getJSONObject("index_score").getInt("intonation"), overall.getJSONObject("index_score").getInt("pronunciation"), overall.getJSONObject("index_score").getInt("phrasing"), overall.getJSONObject("index_score").getInt("loudness"), overall.getJSONObject("index_score").getInt("rhythm"), overall.getJSONObject("index_score").getInt("speed"), part.getJSONObject("feedback").getString("intonation"), part.getJSONObject("feedback").getString("pronunciation"), part.getJSONObject("feedback").getString("phrasing"), part.getJSONObject("feedback").getString("loudness"), part.getJSONObject("feedback").getString("rhythm"), part.getJSONObject("feedback").getString("speed"));
        return scoreTable;
    }

    public void destroy() {

    }
}
