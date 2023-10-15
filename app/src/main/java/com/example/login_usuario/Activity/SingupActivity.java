package com.example.login_usuario.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_usuario.DB.DbHelper;
import com.example.login_usuario.DB.DbUser;
import com.example.login_usuario.R;

import java.io.File;

public class SingupActivity extends AppCompatActivity {

    AppCompatButton btnGuardar;
    EditText txtuser,txtEmail,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        TextView txtLogin = findViewById(R.id.textViewLogin);

        txtuser = findViewById(R.id.editTextUser);
        txtEmail =findViewById(R.id.editTextEmail);
        txtPassword =findViewById(R.id.editTextPassword);
        btnGuardar =findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbUser bduser = new DbUser(SingupActivity.this);
                long id = bduser.crearUser(txtuser.getText().toString(),txtEmail.getText().toString(),txtPassword.getText().toString());

                if(id > 0){
                    Toast.makeText(SingupActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                }else {
                    Toast.makeText(SingupActivity.this, "ERROR AL GUARDAr REGISTRO", Toast.LENGTH_LONG).show();
                }


            }
        });


        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void  limpiar(){
        txtuser.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
    }

}