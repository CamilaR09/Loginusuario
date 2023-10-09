package com.example.login_usuario.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.login_usuario.Adapter.FilmListAdapter;
import com.example.login_usuario.Domain.ListFilm;
import com.example.login_usuario.R;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adaterNewMovie , adaterUpComming;
    private RecyclerView recyclerViewMovies, recyclerViewUpComming;
    private RequestQueue mRequesQueue;
    private StringRequest mStringRequest, mStringRequest2;
    private ProgressBar loading1, loading2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        sendRequest1();
        sendRequest2();
    }

    private void sendRequest1() {
        mRequesQueue = Volley.newRequestQueue(this);
        loading1.setVisibility(View.VISIBLE);
        mStringRequest = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies?page=1", response -> {
            Gson gson = new Gson();
            loading1.setVisibility(View.GONE);

            ListFilm items= gson.fromJson(response, ListFilm.class);
            adaterNewMovie = new FilmListAdapter(items);
            recyclerViewMovies.setAdapter(adaterNewMovie);


        }, error -> {
            loading1.setVisibility(View.GONE);

        });
        mRequesQueue.add(mStringRequest);
    }
    private void sendRequest2() {
        mRequesQueue = Volley.newRequestQueue(this);
        loading2.setVisibility(View.VISIBLE);
        mStringRequest2 = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies?page=3", response -> {
            Gson gson = new Gson();
            loading2.setVisibility(View.GONE);

            ListFilm items= gson.fromJson(response, ListFilm.class);
            adaterUpComming = new FilmListAdapter(items);
            recyclerViewUpComming.setAdapter(adaterUpComming);


        }, error -> {
            loading2.setVisibility(View.GONE);

        });
        mRequesQueue.add(mStringRequest2);
    }

    private void initView() {
        recyclerViewMovies=findViewById(R.id.View);
        recyclerViewMovies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerViewUpComming=findViewById(R.id.View1);
        recyclerViewUpComming.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        loading1 =findViewById(R.id.loading1);
        loading2 =findViewById(R.id.loading2);

    }
}