/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import java.util.ArrayList;

/**
 *
 * Juan Pablo Doncel 320505
 * Victor Silva 344919
 */
public class Sistema {
   

    private ArrayList<Disenador> listaDisenadores;
    private ArrayList<Ficha> listaFichas;

    public Sistema() {
        this.listaDisenadores = new ArrayList<>();
        this.listaFichas = new ArrayList<>();
    }

    public boolean existeDisenador(String nombre) {

    boolean encontrado = false;

    for (int i = 0; i < listaDisenadores.size(); i++) {

        if (listaDisenadores.get(i).getNombre().equals(nombre)) {
            encontrado = true;
        }
    }

    return encontrado;
}
    
    
public boolean registrarDisenador(Disenador unDisenador) {

    boolean agregado = false;

    if (!existeDisenador(unDisenador.getNombre())) {
        listaDisenadores.add(unDisenador);
        agregado = true;
    }

    return agregado;
}

    
    public boolean existeFicha(String nombre) {

    boolean encontrado = false;

    for (int i = 0; i < listaFichas.size(); i++) {

        if (listaFichas.get(i).getNombre().equals(nombre)) {
            encontrado = true;
        }
    }

    return encontrado;
}
    
    public boolean colorValido(String color) {

    boolean valido = false;

    if (color.equals("R") || color.equals("A") ||
        color.equals("B") || color.equals("N") ||
        color.equals("M") || color.equals("V") ||
        color.equals("G") || color.equals("C")) {

        valido = true;
    }

    return valido;
}
    public boolean registrarFicha(Ficha unaFicha) {

    boolean agregado = false;

    if (!existeFicha(unaFicha.getNombre())) {

        if (colorValido(unaFicha.getColor())) {

            if (unaFicha.getDisenoChico().length() == 9 &&
                unaFicha.getDisenoGrande().length() == 25) {

                if (!unaFicha.getNombre().equals("") &&
                    unaFicha.getNombre().equals(unaFicha.getNombre().toUpperCase())) {

                    listaFichas.add(unaFicha);
                    agregado = true;
                }
            }
        }
    }

    return agregado;
}
}

