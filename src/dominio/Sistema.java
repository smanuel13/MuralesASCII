/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * Juan Pablo Doncel 320505 Victor Silva 344919
 */
public class Sistema {

    private ArrayList<Disenador> listaDisenadores;
    private ArrayList<Ficha> listaFichas;
    private ArrayList<Mural> listaMurales;

    public Sistema() {
        this.listaDisenadores = new ArrayList<>();
        this.listaFichas = new ArrayList<>();
        this.listaMurales = new ArrayList<>();

        precargarFichas();
    }

    public void precargarFichas() {

        Ficha unaFicha = new Ficha("VACIA", "B",
                ".........",
                ".........................");

        registrarFicha(unaFicha);

        unaFicha = new Ficha("SOL", "M",
                "\\|/-*-/|\\",
                "..|...\\|/.--*--./|\\...|..");

        registrarFicha(unaFicha);

        unaFicha = new Ficha("CUADRADO", "N",
                "+-+|.|+-+",
                "+---+|...||...||...|+---+");

        registrarFicha(unaFicha);

        unaFicha = new Ficha("CORAZON", "R",
                "*.****.*.",
                "**.************.***...*..");

        registrarFicha(unaFicha);

        unaFicha = new Ficha("COPA", "C",
                "\\./.|./_\\",
                "\\.../.\\./...|....|.../_\\.");

        registrarFicha(unaFicha);

        unaFicha = new Ficha("ARBOL", "V",
                ".^.^^^.|.",
                "..^...^^^.^^^^^..|.../.\\.");

        registrarFicha(unaFicha);

        unaFicha = new Ficha("GATO", "A",
                "^.^o.o=^=",
                "/\\_/\\(o.o).>^<../|\\../.\\.");

        registrarFicha(unaFicha);

        unaFicha = new Ficha("DIAMANTE", "G",
                ".*.*.*.*.",
                "..*...*.*.*...*.*.*...*..");

        registrarFicha(unaFicha);

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

    public Disenador buscarDisenador(String unNombre) {

        Disenador unDisenador = null;

        for (int i = 0; i < listaDisenadores.size(); i++) {

            if (listaDisenadores.get(i).getNombre().equals(unNombre)) {
                unDisenador = listaDisenadores.get(i);
            }
        }

        return unDisenador;
    }

    public boolean existeMural(String nombre) {

        boolean encontrado = false;

        for (int i = 0; i < listaMurales.size(); i++) {

            Mural unMural = listaMurales.get(i);

            if (unMural.getNombre().equals(nombre)) {
                encontrado = true;
            }
        }

        return encontrado;
    }

    public Mural buscarMural(String unNombre) {

        Mural unMural = null;

        for (int i = 0; i < listaMurales.size(); i++) {

            if (listaMurales.get(i).getNombre().equals(unNombre)) {
                unMural = listaMurales.get(i);
            }
        }

        return unMural;
    }

    public void mostrarMurales() {

        for (int i = 0; i < listaMurales.size(); i++) {

            Mural unMural = listaMurales.get(i);

            System.out.println(unMural.getNombre()
                    + " - Diseñador: "
                    + unMural.getDisenador().getNombre());
        }
    }

    public void mostrarDisenadores() {

        for (int i = 0; i < listaDisenadores.size(); i++) {
            System.out.println(listaDisenadores.get(i).getNombre());
        }
    }

    public void mostrarMuralesDe(Disenador unDisenador) {

        for (int i = 0; i < listaMurales.size(); i++) {

            Mural unMural = listaMurales.get(i);

            if (unMural.getDisenador() == unDisenador) {
                System.out.println(unMural.getNombre());
            }
        }
    }

    public void mostrarTodasLasFichas() {

        for (int i = 0; i < listaFichas.size(); i++) {

            Ficha unaFicha = listaFichas.get(i);

            System.out.println("Ficha: " + unaFicha.getNombre());
            System.out.println("Color: " + unaFicha.getColor());

            String codigo = "";

            if (unaFicha.getColor().equals("R")) {
                codigo = "\u001B[31m";
            } else if (unaFicha.getColor().equals("A")) {
                codigo = "\u001B[34m";
            } else if (unaFicha.getColor().equals("B")) {
                codigo = "\u001B[37m";
            } else if (unaFicha.getColor().equals("N")) {
                codigo = "\u001B[30m";
            } else if (unaFicha.getColor().equals("M")) {
                codigo = "\u001B[33m";
            } else if (unaFicha.getColor().equals("V")) {
                codigo = "\u001B[32m";
            } else if (unaFicha.getColor().equals("G")) {
                codigo = "\u001B[35m";
            } else if (unaFicha.getColor().equals("C")) {
                codigo = "\u001B[36m";
            }

            for (int tam = 3; tam <= 5; tam = tam + 2) {

                String diseno = unaFicha.getDisenoChico();

                if (tam == 5) {
                    diseno = unaFicha.getDisenoGrande();
                }

                System.out.println("Tamaño " + tam + "x" + tam + ":");

                for (int fila = 0; fila < tam; fila++) {

                    System.out.print(codigo);

                    for (int columna = 0; columna < tam; columna++) {

                        char caracter = diseno.charAt(fila * tam + columna);

                        if (caracter == '.') {
                            System.out.print(" ");
                        } else {
                            System.out.print(caracter);
                        }
                    }

                    System.out.println("\u001B[0m");
                }
            }

            System.out.println();
        }
    }

    public boolean registrarMural(Mural unMural) {

        boolean agregado = false;

        if (!existeMural(unMural.getNombre())
                && unMural.getDisenador() != null
                && listaDisenadores.contains(unMural.getDisenador())) {

            listaMurales.add(unMural);
            agregado = true;
        }

        return agregado;
    }

    public boolean registrarDisenador(Disenador unDisenador) {

        boolean agregado = false;

        if (!existeDisenador(unDisenador.getNombre())) {
            listaDisenadores.add(unDisenador);
            agregado = true;
        }

        return agregado;
    }

    public void listadoDisenadores() {

        ArrayList<Disenador> pendientes = new ArrayList<>();

        for (int i = 0; i < listaDisenadores.size(); i++) {
            pendientes.add(listaDisenadores.get(i));
        }

        while (pendientes.size() > 0) {

            Disenador actual = pendientes.get(0);

            for (int i = 1; i < pendientes.size(); i++) {
                if (pendientes.get(i).getNombre().compareTo(
                        actual.getNombre()) < 0) {
                    actual = pendientes.get(i);
                }
            }

            int cantidadMurales = 0;
            ArrayList<Ficha> fichasUsadas = new ArrayList<>();
            ArrayList<String> coloresUsados = new ArrayList<>();

            for (int i = 0; i < listaMurales.size(); i++) {

                Mural unMural = listaMurales.get(i);

                if (unMural.getDisenador() == actual) {

                    cantidadMurales++;

                    Ficha[][] matriz = unMural.getMatrizFichas();

                    for (int f = 0; f < Mural.FILAS; f++) {
                        for (int c = 0; c < Mural.COLUMNAS; c++) {

                            Ficha unaFicha = matriz[f][c];

                            if (unaFicha != null) {

                                if (!fichasUsadas.contains(unaFicha)) {
                                    fichasUsadas.add(unaFicha);
                                }

                                if (!coloresUsados.contains(
                                        unaFicha.getColor())) {
                                    coloresUsados.add(unaFicha.getColor());
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("Nombre: " + actual.getNombre());
            System.out.println("Direccion: " + actual.getDireccion());
            System.out.println("Mail: " + actual.getMail());
            System.out.println("Murales: " + cantidadMurales);
            System.out.println("Fichas diferentes: " + fichasUsadas.size());
            System.out.println("Colores diferentes: " + coloresUsados.size());
            System.out.println();

            pendientes.remove(actual);
        }
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

    public void mostrarFichas() {

        for (int i = 0; i < listaFichas.size(); i++) {

            Ficha unaFicha = listaFichas.get(i);

            System.out.println(unaFicha.getNombre()
                    + " - Color: " + unaFicha.getColor());
        }
    }

    public Ficha buscarFicha(String unNombre) {

        Ficha unaFicha = null;

        for (int i = 0; i < listaFichas.size(); i++) {

            if (listaFichas.get(i).getNombre().equals(unNombre)) {
                unaFicha = listaFichas.get(i);
            }
        }

        return unaFicha;
    }

    public boolean colorValido(String color) {

        boolean valido = false;

        if (color.equals("R") || color.equals("A")
                || color.equals("B") || color.equals("N")
                || color.equals("M") || color.equals("V")
                || color.equals("G") || color.equals("C")) {

            valido = true;
        }

        return valido;
    }

    public boolean registrarFicha(Ficha unaFicha) {

        boolean agregado = false;

        if (!existeFicha(unaFicha.getNombre())) {

            if (colorValido(unaFicha.getColor())) {

                if (unaFicha.getDisenoChico().length() == 9
                        && unaFicha.getDisenoGrande().length() == 25) {

                    if (!unaFicha.getNombre().equals("")
                            && unaFicha.getNombre().equals(unaFicha.getNombre().toUpperCase())) {

                        listaFichas.add(unaFicha);
                        agregado = true;
                    }
                }
            }
        }

        return agregado;
    }

    public void compararSimilitud(Mural original, int fila,
            int columna, int alto, int ancho) {

        boolean encontrado = false;

        Ficha[][] origen = original.getMatrizFichas();

        for (int m = 0; m < listaMurales.size(); m++) {

            Mural otro = listaMurales.get(m);

            if (otro != original) {

                Ficha[][] destino = otro.getMatrizFichas();

                boolean encontradoEnEste = false;

                for (int i = 0; i <= Mural.FILAS - alto
                        && !encontradoEnEste; i++) {

                    for (int j = 0; j <= Mural.COLUMNAS - ancho
                            && !encontradoEnEste; j++) {

                        boolean iguales = true;

                        for (int f = 0; f < alto; f++) {

                            for (int c = 0; c < ancho; c++) {

                                if (origen[fila - 1 + f][columna - 1 + c]
                                        != destino[i + f][j + c]) {
                                    iguales = false;
                                }
                            }
                        }

                        if (iguales) {

                            System.out.println("Coincidencia en mural: "
                                    + otro.getNombre());

                            System.out.println("Fila: " + (i + 1)
                                    + ", columna: " + (j + 1));

                            encontrado = true;
                            encontradoEnEste = true;
                        }
                    }
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron coincidencias.");
        }
    }

}
