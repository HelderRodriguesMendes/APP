package com.example.teste_redeindustrial.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teste_redeindustrial.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastrarUserActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editPassword;
    private Button btn_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_user);

        editEmail = findViewById(R.id.edit_cad_email);
        editPassword = findViewById(R.id.edit_cad_password);
        btn_cadastrar = findViewById(R.id.btn_cadastrar);

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadUsuario();
            }
        });
    }

    private void cadUsuario() {
        String email = editEmail.getText().toString();
        String senha = editPassword.getText().toString();

        if(email.equals("") || senha.equals("")){
            Toast.makeText(this, "O campus e-mail e senha devem ser preenchidos", Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("Teste", task.getResult().getUser().getUid());

                    AlertDialog.Builder alert = new AlertDialog.Builder(CadastrarUserActivity.this);
                    alert.setTitle("Cadastro de Usuário");
                    alert.setMessage("O cadastro foi realizado com sucesso!");
                    alert.setNeutralButton("OK", null);
                    alert.show();

                    editEmail.setText("");
                    editPassword.setText("");
                    editEmail.requestFocus();

                    //Intent intent = new Intent(CadastrarUserActivity.this, LoginActivity.class);
                    //startActivity(intent);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {   //exibe as falhas que foram ocorridas no cadastro
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("Teste", e.getMessage());
                Toast.makeText(CadastrarUserActivity.this, "Falha na altenticação.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}