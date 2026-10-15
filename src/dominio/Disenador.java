/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/*
*Juan Pablo Doncel 320505
*Victor Silva
*/

import java.util.ArrayList;

public class Disenador {
    
    private String Nombre;
    private String Direccion;
    private String Mail;
    private ArrayList<Mural> listaMurales;

    public Disenador() {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Mail = Mail;
        this.listaMurales = new ArrayList<>();
    }
    
    

    public Disenador(String unNombre, String unaDireccion, String unMail) {
        this.Nombre = unNombre;
        this.Direccion = unaDireccion;
        this.Mail = unMail;
        this.listaMurales = new ArrayList<>();
        
        
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

    public void setNombre(String unNombre) {
        this.Nombre = unNombre;
    }

    public void setDireccion(String unaDireccion) {
        this.Direccion = unaDireccion;
    }

    public void setMail(String unMail) {
        this.Mail = unMail;
    }

    public ArrayList<Mural> getListaMurales() {
        return listaMurales;
    }

    public void setListaMurales(ArrayList<Mural> listaMurales) {
        this.listaMurales = listaMurales;
    }
    
    
    
}
