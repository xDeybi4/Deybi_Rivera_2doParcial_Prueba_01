package com.example.deybi_rivera_2doparcial_prueba_01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuariosHelp extends SQLiteOpenHelper {

    private String createTable_Usuarios="CREATE TABLE USUARIOS(CODIGO INTEGER PRIMARY KEY AUTOINCREMENT," +
            "USUARIO TEXT," +
            "CONTRASENA TEXT)";
    public UsuariosHelp(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createTable_Usuarios);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
