package modelo;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
    private String cod;
    private String username;
    private String password;
    private String rol;
     
     
    public Usuario() {        
    }    
    

    //Métodos Getters & Setters
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
     
     
     
    
    
}
