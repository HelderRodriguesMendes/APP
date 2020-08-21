package com.example.teste_redeindustrial.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teste_redeindustrial.R;
import com.example.teste_redeindustrial.controller.MovieController;
import com.example.teste_redeindustrial.model.Movie;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTitulo = findViewById(R.id.edit_titulo);
        editID = findViewById(R.id.edit_id);
        btn_pesquisar = findViewById(R.id.btnpesquisar);

        btn_pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTitulo.getText().toString().equals("") && !editID.getText().toString().equals("")){
                    Toast.makeText(HomeActivity.this, "Faça apenas 1 tipo de pesquisa", Toast.LENGTH_SHORT).show();
                }else{
                    titulo = editTitulo.getText().toString();
                    id = editID.getText().toString();
                    Movie movie = new Movie();
                    movie = movieController.buscarFilme(titulo, id);
                }
            }
        });
    }
}