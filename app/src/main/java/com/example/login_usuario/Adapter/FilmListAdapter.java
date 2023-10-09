package com.example.login_usuario.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.login_usuario.Activity.DetalleActivity;
import com.example.login_usuario.Domain.ListFilm;
import com.example.login_usuario.R;


public class FilmListAdapter  extends RecyclerView.Adapter<FilmListAdapter.ViewHolder> {
   ListFilm items;
    Context context;

 public FilmListAdapter(ListFilm items) {
  this.items = items;
 }

 @NonNull
    @Override
    public FilmListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

  View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_film , parent ,false);
  context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmListAdapter.ViewHolder holder, int position) {
     holder.titleTxt.setText(items.getData().get(position).getTitle());
     holder.ScoreTxt.setText(""+items.getData().get(position).getImdbRating());

        Glide.with(holder.itemView.getContext())
                .load(items.getData().get(position).getPoster())
                .into(holder.pic);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetalleActivity.class);
            intent.putExtra("id",items.getData().get(position).getId());
            holder.itemView.getContext().startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        if (items != null && items.getData() != null) {
            return items.getData().size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView titleTxt,ScoreTxt;
    ImageView pic;
     public ViewHolder(@NonNull View itemView) {
      super(itemView);
      titleTxt = itemView.findViewById(R.id.titleTxt);
      ScoreTxt = itemView.findViewById(R.id.scoreTxt);
      pic = itemView.findViewById(R.id.pic);
     }
    }
}
