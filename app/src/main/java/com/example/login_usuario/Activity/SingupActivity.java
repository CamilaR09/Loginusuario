package com.example.login_usuario.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_usuario.DB.DbHelper;
import com.example.login_usuario.R;

public class SingupActivity extends AppCompatActivity {

    AppCompatButton btncrear, btnGuardar;
    EditText txtNombre,txtEmail,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        TextView txtLogin = findViewById(R.id.textViewLogin);
        btncrear = findViewById(R.id.btnCrear);

        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper =new DbHelper(SingupActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(SingupActivity.this,"BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(SingupActivity.this,"ERROR BASE DE DATOS",Toast.LENGTH_LONG).show();
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
}