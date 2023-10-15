package com.example.login_usuario.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.login_usuario.DB.entidades.Usuarios;

import java.util.ArrayList;

public class DbUser extends DbHelper {
    Context context;
    public DbUser(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long crearUser(String username,String email, String password) {
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("username", username);
            values.put("email", email);
            values.put("password", password);

            id = db.insert(TABLE_USER, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;

    }
    public int actualizarUser(long userId, String newUsername, String newEmail, String newPassword) {
        int rowsUpdated = 0;
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("username", newUsername);
            values.put("email", newEmail);
            values.put("password", newPassword);

            String whereClause = "id = ?";
            String[] whereArgs = {String.valueOf(userId)};

            rowsUpdated = db.update(TABLE_USER, values, whereClause, whereArgs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rowsUpdated;
    }
    public int eliminarUser(long userId) {
        int rowsDeleted = 0;
        try {
            SQLiteDatabase db = getWritableDatabase();
            String whereClause = "id = ?";
            String[] whereArgs = {String.valueOf(userId)};

            rowsDeleted = db.delete(TABLE_USER, whereClause, whereArgs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rowsDeleted;
    }

    public ArrayList<Usuarios> mostraruser(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Usuarios> listauser = new ArrayList<>();
        Usuarios user = null;
        Cursor cursoruser = null;

        cursoruser = db.rawQuery("SELECT * FROM "+TABLE_USER,null);

        if(cursoruser.moveToFirst()){
            do{
                user = new Usuarios();
                user.setId(cursoruser.getInt(0));
                user.setUser(cursoruser.getString(1));
                user.setEmail(cursoruser.getString(2));
                listauser.add(user);
            }while (cursoruser.moveToNext());
        }
        cursoruser.close();

        return listauser;
    }
    public boolean verificarCredenciales(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {"id"};
        String selection = "username = ? AND password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_USER, projection, selection, selectionArgs, null, null, null);

        boolean credencialesValidas = cursor.moveToFirst();
        cursor.close();

        return credencialesValidas;
    }
}
