package com.infact.nightour.rest;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Klinsman
 */
public class RestClient {
    private final String url;

    public RestClient(String url){
        this.url = url;
    }

    public String getStringFromInputStream(InputStream inputStream){
        BufferedReader reader = null;
        StringBuilder text =  new StringBuilder();
        String line;

        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return text.toString();
    }

    public String post(String json) {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(this.url);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpURLConnection.setRequestProperty("Accept", "application/json;charset=UTF-8");

            OutputStream out = httpURLConnection.getOutputStream();

            out.write(json.getBytes());

            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = httpURLConnection.getInputStream();
                return getStringFromInputStream(inputStream);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }


    public String get() {
        HttpURLConnection httpURLConnection = null;
        try {
            Log.d("Tag", "cheguei aqui");
            URL url = new URL(this.url);
            Log.d("Tag", (this.url == null)? "É NULO" : url.toString());
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpURLConnection.setRequestProperty("Accept", "application/json;charset=UTF-8");

            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = httpURLConnection.getInputStream();
                return getStringFromInputStream(inputStream);

            }
            else Log.d("Tag", httpURLConnection.getResponseCode() + "");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }



}
