package com.example.teste_redeindustrial.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teste_redeindustrial.R;
import com.example.teste_redeindustrial.controller.MovieController;
import com.example.teste_redeindustrial.model.Movie;
import com.example.teste_redeindustrial.request.BuscarFilmeService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private EditText editTitulo;
    private EditText editID;
    private Button btn_pesquisar;
    private Retrofit retrofit;

    MovieController movieController;
    List<Movie> movieList;

    String titulo = "";
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTitulo = findViewById(R.id.edit_titulo);
        editID = findViewById(R.id.edit_id);
        btn_pesquisar = findViewById(R.id.btnpesquisar);

        retrofit = new Retrofit.Builder().baseUrl("http://www.omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create()).build();

        btn_pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTitulo.getText().toString().equals("") && !editID.getText().toString().equals("")){
                    Toast.makeText(HomeActivity.this, "Faça apenas 1 tipo de pesquisa", Toast.LENGTH_SHORT).show();
                }else if(editTitulo.getText().toString().equals("") && editID.getText().toString().equals("")){
                    Toast.makeText(HomeActivity.this, "Informe um tipo de pesquisa", Toast.LENGTH_SHORT).show();
                }else{
                    titulo = editTitulo.getText().toString();
                    id = editID.getText().toString();
                    movieController = new MovieController();
                    buscarFilme(id, titulo);


                }
            }
        });
    }

    public void buscarFilme(String id, String titulo){
        System.out.println("AQUI1");
        BuscarFilmeService filmeService = retrofit.create(BuscarFilmeService.class);
        Call<Movie> call = filmeService.buscarfilmeTitulo();

        call.enqueue(new Callback<Movie>() {
            Movie movie = new Movie();
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful()){
                    movie = response.body();
                    System.out.println("TITULO: " + movie.getTitle());
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
}