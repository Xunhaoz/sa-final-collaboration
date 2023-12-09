package com.example.front.app;

import org.json.JSONObject;

import java.util.TimeZone;
import java.sql.Timestamp;

public class LoginLog {
    private int id;
    private String token, ipAddress, browser, os;
    private Timestamp loginTime;

    private Helper helper = Helper.getHelper();

    public LoginLog(int id, String token, String ipAddress, String bowser, String os, Timestamp loginTime) {
        this.id = id;
        this.token = token;
        this.ipAddress = ipAddress;
        this.browser = bowser;
        this.os = os;
        this.loginTime = loginTime;
    }

    public LoginLog(String token, String ipAddress, String bowser, String os) {
        this.token = token;
        this.ipAddress = ipAddress;
        this.browser = bowser;
        this.os = os;
        helper.createLoginLog(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ip_address) {
        this.ipAddress = ip_address;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getLoginTime() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+8"));
        return loginTime.toString();
    }

    public void setLoginTime(Timestamp login_time) {
        this.loginTime = login_time;
    }

    public Helper getHelper() {
        return helper;
    }

    public void setHelper(Helper helper) {
        this.helper = helper;
    }

    public JSONObject getObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("token", getToken());
        jsonObject.put("ipAddress", getIpAddress());
        jsonObject.put("os", getOs());
        jsonObject.put("browser", getBrowser());
        jsonObject.put("loginTime", getLoginTime());
        return jsonObject;
    }
}
