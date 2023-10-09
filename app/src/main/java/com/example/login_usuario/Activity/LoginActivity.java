package com.example.login_usuario.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.example.login_usuario.R;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUser;
    private EditText editTextPassword;
    private AppCompatButton buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUser = findViewById(R.id.editTextUser);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.btnCrear);

        TextView txtSingUp = findViewById(R.id.textViewSingUp);
        txtSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SingupActivity.class);
                startActivity(intent);
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCredenciales()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private boolean validarCredenciales() {
        String usuario = editTextUser.getText().toString();
        String contraseña = editTextPassword.getText().toString();

        if (usuario.equals("Cami") && contraseña.equals("123")) {
            return true;
        } else {
            return false;
        }
    }
}