package com.yowaelectronics.app.miscantos.Models;

public class UserModel {
    private String nombre, apellido, email, password, foto;

    //----- GETTERS ----//
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCorreo() { return email; }
    public String getClave() { return password; }
    public String getFoto() { return foto; }

    //----- SETTERS ----//
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setFoto(String urlFoto) { this.foto = urlFoto; }

    public UserModel(String nombre, String apellido, String email, String password, String foto){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.foto = foto;
    }
}
