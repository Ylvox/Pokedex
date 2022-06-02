package me.ylvox.network;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class HTTPRequest {

    JSONObject jsonObject = null;

    public JSONObject requestGetMethod(String stringUrl){

        URL url;

        try {
            
            url = new URL(stringUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection(); 
            connection.connect();

            String response = IOUtils.toString(connection.getInputStream(), "utf-8");

            jsonObject = new JSONObject(response);

        } catch(MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;

    }
    
}