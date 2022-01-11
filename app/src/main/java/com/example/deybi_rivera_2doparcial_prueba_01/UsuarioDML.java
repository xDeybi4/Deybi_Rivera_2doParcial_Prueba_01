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
        usuarioHelper=new UsuariosHelp(context, "clientesDB", null, 1);
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
            values.put("Nombre", usuario.getUsuario());
            values.put("Apellido", usuario.get());
            values.put("Correo", usuario.getCorreo());

            count=sql.insert("Clientes", null, values);


        }catch(Exception e){
            throw e;
        }
        finally{
            sql.close();
        }

        return count;
    }

    public Cliente selectByCodigo(String codigo){
        Cliente cliente=null;

        try{
            open();
            String select="SELECT Nombre, Apellido, Correo " +
                    "FROM Clientes " +
                    "WHERE Codigo="+codigo;

            Cursor cursor=sql.rawQuery(select, null);

            if(cursor.moveToFirst()){
                cliente=new Cliente();
                cliente.setNombre(cursor.getString(0));
                cliente.setApellido(cursor.getString(1));
                cliente.setCorreo(cursor.getString(2));
            }
        }catch (Exception e){
            throw e;
        }
        finally{
            sql.close();
        }

        return cliente;
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

    public int update(Cliente cliente){
        int count=0;

        try{
            open();
            ContentValues values=new ContentValues();

            values.put("Nombre", cliente.getNombre());
            values.put("Apellido", cliente.getApellido());
            values.put("Correo", cliente.getCorreo());

            count= sql.update("Clientes", values, "Codigo="+cliente.getCodigo(), null);
        }catch(Exception e){
            throw e;
        }finally{
            sql.close();
        }

        return count;
    }
}
