/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/*
* Juan Pablo Doncel 320505
* Victor Silva 55555
*/

import java.util.ArrayList;

public class Disenador {
    
    private String nombre;
    private String direccion;
    private String mail;
    private ArrayList<Mural> listaMurales;

    public Disenador() {
        this.nombre = "Sin nombre";
        this.direccion = "Sin direccion";
        this.mail = "sin mail";
        this.listaMurales = new ArrayList<>();
    }
    
    

    public Disenador(String unNombre, String unaDireccion, String unMail) {
        this.nombre = unNombre;
        this.direccion = unaDireccion;
        this.mail = unMail;
        this.listaMurales = new ArrayList<>();
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ArrayList<Mural> getListaMurales() {
        return listaMurales;
    }

    public void setListaMurales(ArrayList<Mural> listaMurales) {
        this.listaMurales = listaMurales;
    }

    @Override
    public String toString() {
        return this.getNombre()+ " ("+ this.getMail() + ")"; 
    }

    
    
}
    
    
    

