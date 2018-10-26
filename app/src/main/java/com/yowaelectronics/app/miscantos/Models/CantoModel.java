package com.yowaelectronics.app.miscantos.Models;

public class CantoModel {
    private String nombre;
    private String userModelUrl;

    //----- GETTERS -----//
    public String getNombre() {
        return nombre;
    }
    public String getUserModelUrl() {
        return userModelUrl;
    }

    //----- SETTERS -----//
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setUserModelUrl(String userModelUrl) {
        this.userModelUrl = userModelUrl;
    }

    public CantoModel(String nombre, String userModelUrl){
        this.nombre = nombre;
        this.userModelUrl = userModelUrl;
    }
}
