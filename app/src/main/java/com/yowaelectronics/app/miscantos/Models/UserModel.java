package com.yowaelectronics.app.miscantos.Models;

public class UserModel {
    private String nombre, apellido, email, password;

    //----- GETTERS ----//
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCorreo() {
        return email;
    }
    public String getClave() {
        return password;
    }

    //----- SETTERS ----//
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public UserModel(String nombre, String apellido, String email, String password){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }
}
