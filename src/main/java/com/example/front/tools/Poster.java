package com.example.front.tools;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Poster {
    public static String sendPostRequest(String url, String textData, String filePath) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart("text", new StringBody(textData, ContentType.TEXT_PLAIN));
        builder.addPart("audio", new FileBody(new File(filePath)));

        HttpEntity entity = builder.build();
        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);

        return getResponseBody(response);
    }

    private static String getResponseBody(HttpResponse response) throws IOException {
        StringBuilder result = new StringBuilder();
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    result.append(inputLine);
                }
            }
        }

        return result.toString();
    }
}
