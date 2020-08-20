package com.example.teste_redeindustrial.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.teste_redeindustrial.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText editEmail;
    private EditText editPassword;
    private Button btnEntrar;
    private TextView txtCadUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.edit_cad_email);
        editPassword = findViewById(R.id.edit_password);
        btnEntrar = findViewById(R.id.btn_entrar);
        txtCadUser = findViewById(R.id.txt_CadUser);

        mAuth = FirebaseAuth.getInstance();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();

                mAuth.signInWithEmailAndPassword(email, password).
                        addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }else{
                            AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                            alert.setTitle("Login");
                            alert.setMessage("E-mail ou senha incorretos!");
                            alert.setNeutralButton("OK", null);
                            alert.show();
                        }
                    }
                });
            }
        });

        txtCadUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastrarUserActivity.class);
                startActivity(intent);
            }
        });
    }
}