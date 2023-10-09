package com.example.login_usuario.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbUser extends DbHelper {
    Context context;
    public dbUser(@Nullable Context context) {
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
}
