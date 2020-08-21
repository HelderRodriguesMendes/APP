package com.example.teste_redeindustrial.controller;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.teste_redeindustrial.model.Movie;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MovieController {

    private RequestQueue requestQueue;

    Movie movie = new Movie();
    public Movie buscarFilme(String titulo, String id){
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, montarURL(titulo, id), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject MOVIE = jsonArray.getJSONObject(i);
                        movie = new Gson().fromJson(MOVIE.toString(), Movie.class);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        requestQueue.add(request);
        System.out.println("TITLE: " + movie.getTitle());

        return movie;
    }

    private String montarURL(String titulo, String id){
        String URL = "";
        final String urlTitulo = "http://www.omdbapi.com/?t=";
        final String urlID = "http://www.omdbapi.com/?i=";

        final String plot = "&plot=full";
        final String chave = "&apikey=33cb3254";

        if(!titulo.equals("") && id.equals("")){
            URL = urlTitulo + titulo + plot + chave;   //http://www.omdbapi.com/?t=Guardians&plot=full&apikey=33cb3254
        }else{
            URL = urlID + id + plot + chave;    //http://www.omdbapi.com/?i=tt3896198&plot=full&apikey=33cb3254
        }
        return URL;
    }
}
