package com.github.expram;

import com.github.expram.exceptions.InvalidUUIDException;
import com.github.expram.exceptions.ServerIssuesException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utils {

    protected Content getContent(String url) {
        int code = 0;
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            code = connection.getResponseCode();
            if(code == 500){
                throw new ServerIssuesException("No skin/cape/uuid was found because of Mojang or Crafatar server issues.");
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return new Content(code, response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String getUUID(String nickname) throws InvalidUUIDException {
        Content contents = getContent("https://api.mojang.com/users/profiles/minecraft/" + nickname);
        JSONObject uuid;
        int code = contents.getCode();
        try {
            uuid = new JSONObject(contents.getResult());
            return uuid.getString("id");
        } catch (JSONException e) {
            if(code == 204) {
                throw new InvalidUUIDException("Invalid nickname!");
            }
            return null;
        }
    }
}
