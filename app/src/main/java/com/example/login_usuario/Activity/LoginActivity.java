package com.example.login_usuario.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.example.login_usuario.DB.DbUser;
import com.example.login_usuario.DB.entidades.Usuarios;
import com.example.login_usuario.R;

import java.util.ArrayList;

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
                String username = editTextUser.getText().toString();
                String password = editTextPassword.getText().toString();

                DbUser dbUser = new DbUser(LoginActivity.this);
                boolean credencialesValidas = dbUser.verificarCredenciales(username, password);

                if (credencialesValidas) {
                    // Las credenciales son válidas, puedes redirigir al usuario a la pantalla principal o realizar otras acciones.
                    Toast.makeText(LoginActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Las credenciales no son válidas, muestra un mensaje de error.
                    Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}