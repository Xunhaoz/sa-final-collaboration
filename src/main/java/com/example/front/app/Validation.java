package com.example.front.app;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class Validation {
    public static String validCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        Map<String, String> map = new HashMap<>();
        for (Cookie i : cookies) {
            map.put(i.getName(), i.getValue());
        }

        return map.getOrDefault("Authority", null);
    }
}
