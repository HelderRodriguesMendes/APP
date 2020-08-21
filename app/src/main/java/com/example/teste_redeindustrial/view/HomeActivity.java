package com.example.teste_redeindustrial.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.teste_redeindustrial.R;

public class HomeActivity extends AppCompatActivity {

    private EditText editTitulo;
    private EditText editID;
    private Button btn_pesquisar;

    String titulo = "";
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTitulo = findViewById(R.id.edit_titulo);
        editID = findViewById(R.id.edit_id);
        btn_pesquisar = findViewById(R.id.btnpesquisar);

        titulo = editTitulo.getText().toString();
        id = editID.getText().toString();
    }
}