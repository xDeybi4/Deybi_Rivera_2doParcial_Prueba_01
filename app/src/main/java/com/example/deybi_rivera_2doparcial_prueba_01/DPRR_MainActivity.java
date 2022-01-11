package com.example.deybi_rivera_2doparcial_prueba_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DPRR_MainActivity extends AppCompatActivity {
    private UsuariosHelp usuarioHelp; // crear la BD

    private Context context;
    private SQLiteDatabase sql;

    private EditText editTextUsuario;
    private EditText editTextContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dprr_main);

        editTextUsuario=findViewById(R.id.editText_Usuario);
        editTextContrasena=findViewById(R.id.editText_Contrasena);
    }

    public void open(){
        usuarioHelp=new UsuariosHelp(context, "Usuarios", null, 1);
        sql=usuarioHelp.getWritableDatabase();
    }


    public void onClickValidarLogin(View view){
        UsuarioDML dml=new UsuarioDML(this);

        String username=editTextUsuario.getText().toString();
        String contrasena=editTextContrasena.getText().toString();


        Usuarios usuario = new Usuarios();
        usuario = dml.selectByUsername(username);

        if (username.matches(usuario.getUsuario()) && contrasena.matches(usuario.getContrasena())) {
            Toast.makeText(this, "Login exitoso.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Contraseña incorrect.", Toast.LENGTH_SHORT).show();
        }
    }
}