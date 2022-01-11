package com.example.deybi_rivera_2doparcial_prueba_01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UsuarioDML {
    private UsuariosHelp usuarioHelper; // crear la BD
    private SQLiteDatabase sql;
    private Context context;

    public UsuarioDML(Context context){
        this.context=context;
    }

    public void open(){
        usuarioHelper=new UsuariosHelp(context, "UsuariosDB", null, 1);
        sql=usuarioHelper.getWritableDatabase();
    }

    public void close(){
        sql.close();
    }



    public long insert(Usuarios usuario){
        long count=0;

        try{
            open();
            ContentValues values=new ContentValues();

            ContentValues listaValores=new ContentValues();
            values.put("Usuario", usuario.getUsuario());
            values.put("Contrasena", usuario.getContrasena());

            count=sql.insert("Usuarios", null, values);


        }catch(Exception e){
            throw e;
        }
        finally{
            sql.close();
        }

        return count;
    }

    public Usuarios selectByUsername(String username){
        Usuarios usuario=null;

        try{
            open();
            String select="SELECT Usuario, Contrasena " +
                    "FROM Usuarios " +
                    "WHERE usuario="+username;

            Cursor cursor=sql.rawQuery(select, null);

            if(cursor.moveToFirst()){
                usuario=new Usuarios();
                usuario.setUsuario(cursor.getString(0));
                usuario.setContrasena(cursor.getString(1));
            }
        }catch (Exception e){
            throw e;
        }
        finally{
            sql.close();
        }

        return usuario;
    }

    public ArrayList<String> select(){
        ArrayList<String> list=null;

        try {
            open();
            String select="SELECT Codigo, Nombre, Apellido, Correo" +
                    "FROM Clientes";

            Cursor cursor=sql.rawQuery(select, null);

            if(cursor.moveToFirst()){
                list=new ArrayList<>();

                do{
                    list.add(cursor.getString(0) + " " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3));
                }while(cursor.moveToNext());
            }
        }catch (Exception e){
            throw e;
        }
        finally {
            sql.close();
        }

        return list;
    }

    public int delete(int codigo){
        int count=0;

        try{
            open();
            count=sql.delete("Clientes", "Codigo="+codigo, null);
        }catch(Exception e){
            throw e;
        }finally{
            sql.close();
        }

        return count;
    }

    public int update(Usuarios usuario){
        int count=0;

        try{
            open();
            ContentValues values=new ContentValues();

            values.put("Nombre", usuario.getUsuario());
            values.put("Apellido", usuario.getContrasena());

            count= sql.update("Clientes", values, "Codigo="+usuario.getCodigo(), null);
        }catch(Exception e){
            throw e;
        }finally{
            sql.close();
        }

        return count;
    }
}
