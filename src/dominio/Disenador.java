/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dominio;

/*
 * Juan Pablo Doncel 320505
 * Victor Silva 344919
 */

public class Disenador {

    private String nombre;
    private String direccion;
    private String mail;

    public Disenador() {
        this.nombre = "Sin nombre";
        this.direccion = "Sin direccion";
        this.mail = "Sin mail";
    }

    public Disenador(String unNombre, String unaDireccion, String unMail) {
        this.nombre = unNombre;
        this.direccion = unaDireccion;
        this.mail = unMail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String unaDireccion) {
        this.direccion = unaDireccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String unMail) {
        this.mail = unMail;
    }

    @Override
    public String toString() {
        return this.getNombre() + " (" + this.getMail() + ")";
    }
}


