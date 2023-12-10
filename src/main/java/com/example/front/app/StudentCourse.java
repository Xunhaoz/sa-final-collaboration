package com.example.front.app;

import org.json.JSONObject;

public class StudentCourse {
    int id, studentId, courseId;
    Helper helper = Helper.getHelper();


    public StudentCourse(int studentId, int courseId, String action) {
        this.studentId = studentId;
        this.courseId = courseId;
        if (action.equals("create")) {
            helper.createStudentCourse(this);
        } else if (action.equals("delete")) {
            helper.deleteStudentCourse(this);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public JSONObject getObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("studentId", getStudentId());
        jsonObject.put("courseId", getCourseId());
        return jsonObject;
    }
}
