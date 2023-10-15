package com.example.login_usuario.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

import com.example.login_usuario.DB.DbHelper;
import com.example.login_usuario.R;

import java.io.File;

public class Intro_btnActivity extends AppCompatActivity {
    AppCompatButton btncrear , btnlogin, btnsingup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_btn);
        btncrear = findViewById(R.id.btnCrear);
        btnlogin = findViewById(R.id.btnLogin);
        btnsingup = findViewById(R.id.btnSingUP);

        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper =new DbHelper(Intro_btnActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    // prueba si la base de datos ya existe
                    if (databaseExists(dbHelper)) {
                        Toast.makeText(Intro_btnActivity.this, "BASE DE DATOS YA EXISTE", Toast.LENGTH_LONG).show();
                    } else {
                        // La base de datos no existe, así que la crea
                        dbHelper.onCreate(db);
                        Toast.makeText(Intro_btnActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(Intro_btnActivity.this, "ERROR BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }

        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intro_btnActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        btnsingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intro_btnActivity.this, SingupActivity.class);
                startActivity(intent);
            }
        });

        TextView tablausuario = findViewById(R.id.txtTablaUser);
        tablausuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intro_btnActivity.this, Tabla_UserActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean databaseExists(DbHelper dbHelper) {
        String dbPath = Intro_btnActivity.this.getDatabasePath(dbHelper.getDatabaseName()).getAbsolutePath();
        File dbFile = new File(dbPath);
        return dbFile.exists();
    }
}