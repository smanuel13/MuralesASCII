/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * Juan Pablo Doncel 320505
 * Victor Silva 55555
 */
public class Ficha {
    
    private String nombre;
    private String color;
    private String disenoChico;
    private String disenoGrande;

    public Ficha() {
        this.nombre = "Sin nombre";
        this.color = "";
        this.disenoChico = ".........";
        this.disenoGrande = ".........................";
    }

    public Ficha(String unNombre, String unColor, String unDisenoChico, String unDisenoGrande) {
        this.nombre = unNombre;
        this.color = unColor;
        this.disenoChico = unDisenoChico;
        this.disenoGrande = unDisenoGrande;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String unColor) {
        this.color = unColor;
    }

    public String getDisenoChico() {
        return disenoChico;
    }

    public void setDisenoChico(String unDisenoChico) {
        this.disenoChico = unDisenoChico;
    }

    public String getDisenoGrande() {
        return disenoGrande;
    }

    public void setDisenoGrande(String unDisenoGrande) {
        this.disenoGrande = unDisenoGrande;
    }
    

    @Override
    public String toString (){
        return this.getNombre() + " (" + this.getColor() +")";
    }

            
            
            
}
