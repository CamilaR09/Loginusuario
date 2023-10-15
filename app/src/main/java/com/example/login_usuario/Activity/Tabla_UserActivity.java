package com.example.login_usuario.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.login_usuario.DB.DbUser;
import com.example.login_usuario.DB.entidades.UserAdapter;
import com.example.login_usuario.DB.entidades.Usuarios;
import com.example.login_usuario.R;

import java.util.ArrayList;

public class Tabla_UserActivity extends AppCompatActivity {

    RecyclerView listaUser;
    ArrayList<Usuarios> listaArrayUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_user);
        listaUser = findViewById(R.id.listausuario);

        listaUser.setLayoutManager(new LinearLayoutManager(this));
        DbUser dbUser = new DbUser(Tabla_UserActivity.this);

        listaArrayUser = new ArrayList<>() ;

        UserAdapter adapter = new UserAdapter(dbUser.mostraruser());
        listaUser.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}