package com.example.deybi_rivera_2doparcial_prueba_01;

public class Usuarios {
    private int codigo;
    private String usuario;
    private String contrasena;

    public Usuarios(int codigo, String nombre, String contrasena) {
        this.codigo = codigo;
        this.usuario = nombre;
        this.contrasena = contrasena;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return apellido;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
