package com.example.deybi_rivera_2doparcial_prueba_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class DPRR_MainActivity extends AppCompatActivity {
    private UsuariosHelp usuarioHelp; // crear la BD

    private Context context;
    private SQLiteDatabase sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dprr_main);
    }

    public void open(){
        usuarioHelp=new UsuariosHelp(context, "Usuarios", null, 1);
        sql=usuarioHelp.getWritableDatabase();
    }


}