/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

public class Disenador {
    
    private String Nombre;
    private String Direccion;
    private String Mail;

    public Disenador(String Nombre, String Direccion, String Mail) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Mail = Mail;
        
        
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getMail() {
        return Mail;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }
    
    
    
}
