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

        // Ejecutar el SQL para crear la estructura de las tablas
        db.execSQL(createTable_Usuarios);
        // sql: segunda
        // sql: tercera
        // vistas, triggers, etc.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // borrar las tablas
        db.execSQL("DROP TABLE IF EXISTS CLIENTES");

        // SQL  para crear la tabla o tablas con la nueva estructura
        db.execSQL(createTable_Usuarios);
    }
}
