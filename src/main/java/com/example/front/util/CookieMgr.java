package com.example.front.util;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.example.front.app.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CookieMgr {
    public static User getUser(HttpServletRequest request) {

        String authority = validCookie(request);
        if (authority == null) return null;

        JWT jwt = JWTUtil.parseToken(authority);
        int userId = Integer.parseInt(jwt.getPayload("id").toString());

        return new User(userId);
    }

    private static String validCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;

        Map<String, String> map = new HashMap<>();
        for (Cookie i : cookies) {
            map.put(i.getName(), i.getValue());
        }
        return map.getOrDefault("Authority", null);
    }
}
