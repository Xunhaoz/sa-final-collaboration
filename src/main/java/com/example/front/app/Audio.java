package com.example.front.app;

import org.json.JSONObject;

public class Audio {
    int id, classId, audioId, userId;
    String text, path, featureToken;

    Helper helper = Helper.getHelper();

    public Audio(int id, String text, String path) {
        this.id = id;
        this.text = text;
        this.path = path;
        helper.updateAudio(this);
    }

    public Audio(int classId, int userId, String text, String path) {
        this.classId = classId;
        this.userId = userId;
        this.text = text;
        this.path = path;
        helper.createAudio(this);
    }

    public Audio(int classId, int userId, int audioId, String text,String path) {
        this.classId = classId;
        this.userId = userId;
        this.audioId = audioId;
        this.text = text;
        this.path = path;
        helper.createStudentAudio(this);
    }

    public Audio(int id, int classId, int audioId, int userId, String text, String path, String featureToken) {
        this.id = id;
        this.classId = classId;
        this.audioId = audioId;
        this.userId = userId;
        this.text = text;
        this.path = path;
        this.featureToken = featureToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getAudioId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId = audioId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFeatureToken() {
        return featureToken;
    }

    public void setFeatureToken(String featureToken) {
        this.featureToken = featureToken;
    }

    public JSONObject getJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("userId", getUserId());
        jsonObject.put("classId", getClassId());
        jsonObject.put("audioId", getAudioId());
        jsonObject.put("userId", getUserId());
        jsonObject.put("text", getText());
        jsonObject.put("path", getPath());
        jsonObject.put("featureToken", getFeatureToken());
        return jsonObject;
    }
}
