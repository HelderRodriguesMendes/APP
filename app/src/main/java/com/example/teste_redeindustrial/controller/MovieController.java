package com.example.teste_redeindustrial.controller;

import com.example.teste_redeindustrial.model.Movie;

import java.util.List;

public class MovieController {
    public List<Movie> buscarFilme(String titulo, String id){

        return null;
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
