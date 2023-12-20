package com.example.front.tools;

import org.json.JSONObject;

public class RespMaker {
    public static JSONObject makeResp(int status, String message, JSONObject response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("message", message);
        jsonObject.put("response", response);
        return jsonObject;
    }
}
