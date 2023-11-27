package com.example.front.app;

import org.json.*;

import java.sql.Timestamp;

public class ToDo {
    private int id;
    private String topic, content;
    private Timestamp createTime, updateTime;

    private ToDoHelper tdh = ToDoHelper.getHelper();

    /**
     * select all
     */
    public ToDo(int id, String topic, String content, Timestamp createTime, Timestamp updateTime) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /**
     * create one
     */
    public ToDo(String topic, String content) {
        this.topic = topic;
        this.content = content;
        tdh.create(this);
    }

    /**
     * update one
     */
    public ToDo(int id, String topic, String content) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        tdh.update(this);
    }

    /**
     * delete one
     */
    public ToDo(int id) {
        this.id = id;
        tdh.delete(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public JSONObject getData() {
        JSONObject jso = new JSONObject();
        jso.put("id", getId());
        jso.put("topic", getTopic());
        jso.put("content", getContent());
        jso.put("create_time", getCreateTime());
        jso.put("update_time", getUpdateTime());
        return jso;
    }
}
