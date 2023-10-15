package com.example.login_usuario.DB.entidades;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login_usuario.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    ArrayList<Usuarios> listaUser;

    public UserAdapter( ArrayList<Usuarios> listaUser){
        this.listaUser = listaUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_user,null,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.viewID.setText(String.valueOf(listaUser.get(position).getId()));
        holder.viewUser.setText(listaUser.get(position).getUser());
        holder.viewEmail.setText(listaUser.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return listaUser.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView viewID,viewUser,viewEmail;
        ImageView btnEditar, btnEliminar;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            viewID = itemView.findViewById(R.id.txtID);
            viewUser = itemView.findViewById(R.id.txtUser);
            viewEmail = itemView.findViewById(R.id.txtEmail);
            btnEditar = itemView.findViewById(R.id.btneditar);
            btnEliminar = itemView.findViewById(R.id.btneliminar);
        }
    }
}
