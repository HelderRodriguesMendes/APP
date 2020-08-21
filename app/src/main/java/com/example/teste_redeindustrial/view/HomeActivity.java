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

import java.util.ArrayList;
import java.util.List;

//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private EditText editTitulo;
    private EditText editID;
    private Button btn_pesquisar;
    //private Retrofit retrofit;

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

        /*retrofit = new Retrofit.Builder().baseUrl("http://www.omdbapi.com/?")
                .addConverterFactory(GsonConverterFactory.create()).build();*/

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
                    movieController.buscarFilme(HomeActivity.this, titulo, id);
                }
            }
        });
    }
    public  void request_result(List<Movie> list){
        movieList = new ArrayList<>();
        movieList = list;
        for (Movie m : movieList){
            System.out.println("TITLE: " + m.getTitle());
        }
    }
}