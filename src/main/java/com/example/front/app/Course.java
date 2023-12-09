package com.example.front.app;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Date;
import java.sql.Timestamp;

public class Course {
    int id;
    String title, teacher, content, difficulty;
    Date midtermTime, finalTime;
    Timestamp createTime;
    private Helper helper = Helper.getHelper();

    public Course(int id, String title, String teacher, String content, String difficulty, Date midtermTime, Date finalTime, Timestamp createTime) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
        this.content = content;
        this.difficulty = difficulty;
        this.midtermTime = midtermTime;
        this.finalTime = finalTime;
        this.createTime = createTime;
    }

    public Course(String title, String teacher, String content, String difficulty, Date midtermTime, Date finalTime) {
        this.title = title;
        this.teacher = teacher;
        this.content = content;
        this.difficulty = difficulty;
        this.midtermTime = midtermTime;
        this.finalTime = finalTime;
        helper.createCourse(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Date getMidtermTime() {
        return midtermTime;
    }

    public void setMidtermTime(Date midtermTime) {
        this.midtermTime = midtermTime;
    }

    public Date getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(Date finalTime) {
        this.finalTime = finalTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public JSONObject getObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("title", getTitle());
        jsonObject.put("content", getContent());
        jsonObject.put("teacher", getTeacher());
        jsonObject.put("difficult", getDifficulty());
        jsonObject.put("midtermTime", getMidtermTime());
        jsonObject.put("finalTime", getFinalTime());
        jsonObject.put("createTime", getCreateTime());
        return jsonObject;
    }
}
