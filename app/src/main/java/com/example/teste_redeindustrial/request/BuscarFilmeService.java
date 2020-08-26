package com.example.teste_redeindustrial.request;

import com.example.teste_redeindustrial.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BuscarFilmeService {

    @GET("/?t=Guardians&plot=full&apikey=33cb3254")
    Call<Movie> buscarfilmeTitulo();    //http://www.omdbapi.com/?t=Guardians&plot=full&apikey=33cb3254

    Call<Movie> buscarfilmeID();    //http://www.omdbapi.com/?i=tt3896198&plot=full&apikey=33cb3254
}