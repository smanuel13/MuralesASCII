/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dominio.Sistema;
import dominio.Disenador;
import dominio.Ficha;
import dominio.Mural;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * Juan Pablo Doncel 320505 Victor Silva 344919
 */
public class Main {

    public static void main(String[] args) {

        Sistema sistema = new Sistema();
        Scanner input = new Scanner(System.in);

        int opcion = -1;

        while (opcion != 0) {

            System.out.println();
            System.out.println("MENU PRINCIPAL");
            System.out.println("0 - Terminar");
            System.out.println("1 - Informacion de autores");
            System.out.println("2 - Registrar diseñador");
            System.out.println("3 - Registrar ficha");
            System.out.println("4 - Crear mural");
            System.out.println("5 - Modificar mural");
            System.out.println("6 - Visualizar mural");
            System.out.println("7 - Listado de diseñadores");
            System.out.println("8 - Comparar similitud de murales");
            System.out.println("9 - Visualizar todas las fichas");

            System.out.print("Ingrese una opcion: ");
            opcion = input.nextInt();
            input.nextLine();

            if (opcion == 0) {

                System.out.println("Fin del programa");

            } else if (opcion == 1) {

                System.out.println("Juan Pablo Doncel - 320505");
                System.out.println("Victor Silva - 344919");

            } else if (opcion == 2) {

                System.out.println("Ingrese nombre:");
                String nombre = input.nextLine();

                System.out.println("Ingrese direccion:");
                String direccion = input.nextLine();

                System.out.println("Ingrese mail:");
                String mail = input.nextLine();

                Disenador unDisenador = new Disenador(nombre, direccion, mail);

                if (sistema.registrarDisenador(unDisenador)) {
                    System.out.println("Diseñador registrado correctamente");
                } else {
                    System.out.println("Ya existe un diseñador con ese nombre");
                }

            } else if (opcion == 3) {

                System.out.println("Ingrese nombre de la ficha:");
                String nombre = input.nextLine();

                System.out.println("Ingrese color (R,A,B,N,M,V,G,C):");
                String color = input.nextLine();

                System.out.println("Ingrese diseño chico (9 caracteres):");
                String disenoChico = input.nextLine();

                System.out.println("Ingrese diseño grande (25 caracteres):");
                String disenoGrande = input.nextLine();

                Ficha unaFicha = new Ficha(nombre, color, disenoChico, disenoGrande);

                if (sistema.registrarFicha(unaFicha)) {
                    System.out.println("Ficha registrada correctamente");
                } else {
                    System.out.println("No se pudo registrar la ficha");
                }
            } else if (opcion == 4) {

                System.out.println("Ingrese el nombre del mural:");
                String nombreMural = input.nextLine();

                if (nombreMural.equals("") || sistema.existeMural(nombreMural)) {
                    System.out.println("Nombre de mural inválido o repetido.");
                } else {

                    System.out.println("Ingrese el nombre del diseñador:");
                    String nombreDisenador = input.nextLine();

                    Disenador unDisenador = sistema.buscarDisenador(nombreDisenador);

                    if (unDisenador == null) {
                        System.out.println("El diseñador no existe.");
                    } else {
                        System.out.println("Diseñador seleccionado: "
                                + unDisenador.getNombre());

                        System.out.println("Ingrese el nombre de la primera ficha:");
                        String nombreFicha1 = input.nextLine();

                        Ficha unaFichaInicial1 = sistema.buscarFicha(nombreFicha1);

                        if (unaFichaInicial1 == null) {
                            System.out.println("La ficha no existe.");
                        } else {

                            System.out.println("Primera ficha seleccionada: "
                                    + unaFichaInicial1.getNombre());

                            System.out.println("Ingrese el nombre de la segunda ficha:");
                            String nombreFicha2 = input.nextLine();

                            Ficha unaFichaInicial2 = sistema.buscarFicha(nombreFicha2);

                            if (unaFichaInicial2 == null) {
                                System.out.println("La segunda ficha no existe.");
                            } else {

                                if (unaFichaInicial1.getNombre().equals(unaFichaInicial2.getNombre())) {
                                    System.out.println("Las dos fichas deben ser diferentes.");
                                } else {

                                    System.out.println("Segunda ficha seleccionada: "
                                            + unaFichaInicial2.getNombre());

                                    System.out.println("Ingrese el formato del mural:");
                                    System.out.println("D - Damero");
                                    System.out.println("R - Aleatorio");
                                    System.out.println("F - Filas");
                                    System.out.println("B - Borde");
                                    System.out.println("M - Manual");

                                    String formato = input.nextLine().toUpperCase();

                                    if (formato.equals("D") || formato.equals("R")
                                            || formato.equals("F") || formato.equals("B")) {

                                        Ficha unaFichaVacia = sistema.buscarFicha("VACIA");

                                        Mural unMural = new Mural(formato, nombreMural,
                                                unaFichaInicial1, unaFichaInicial2,
                                                unDisenador, unaFichaVacia);

                                        if (sistema.registrarMural(unMural)) {

                                            System.out.println("Mural registrado correctamente.");

                                            System.out.println("Mural en tamaño grande:");
                                            unMural.mostrarGrande();

                                            System.out.println("Mural en tamaño chico:");
                                            unMural.mostrarChico();

                                        } else {
                                            System.out.println("No se pudo registrar el mural.");
                                        }
                                    } else {

                                        if (formato.equals("M")) {

                                            Ficha unaFichaVacia = sistema.buscarFicha("VACIA");

                                            Mural unMural = new Mural(formato, nombreMural,
                                                    unaFichaInicial1, unaFichaInicial2,
                                                    unDisenador, unaFichaVacia);

                                            String continuar = "S";

                                            while (continuar.equals("S")) {

                                                System.out.println("Ingrese la fila (1 a 10):");
                                                int fila = input.nextInt();

                                                System.out.println("Ingrese la columna (1 a 12):");
                                                int columna = input.nextInt();

                                                System.out.println("Seleccione la ficha:");
                                                System.out.println("1 - " + unaFichaInicial1.getNombre());
                                                System.out.println("2 - " + unaFichaInicial2.getNombre());

                                                int numeroFicha = input.nextInt();
                                                input.nextLine();

                                                if (fila >= 1 && fila <= 10
                                                        && columna >= 1 && columna <= 12) {

                                                    if (numeroFicha == 1) {
                                                        unMural.cambiarPosicion(fila, columna, unaFichaInicial1);
                                                    } else if (numeroFicha == 2) {
                                                        unMural.cambiarPosicion(fila, columna, unaFichaInicial2);
                                                    } else {
                                                        System.out.println("Ficha inválida.");
                                                    }

                                                } else {
                                                    System.out.println("Fila o columna inválida.");
                                                }

                                                System.out.println("¿Desea colocar otra ficha? (S/N)");
                                                continuar = input.nextLine().toUpperCase();

                                                while (!continuar.equals("S") && !continuar.equals("N")) {
                                                    System.out.println("Ingrese S o N:");
                                                    continuar = input.nextLine().toUpperCase();
                                                }
                                            }

                                            unMural.guardarOriginal();

                                            if (sistema.registrarMural(unMural)) {

                                                System.out.println("Mural registrado correctamente.");

                                                System.out.println("Mural grande:");
                                                unMural.mostrarGrande();

                                                System.out.println("Mural chico:");
                                                unMural.mostrarChico();

                                            } else {
                                                System.out.println("No se pudo registrar el mural.");
                                            }
                                        } else {
                                            System.out.println("Formato inválido.");
                                        }
                                    }
                                }

                            }
                        }

                    }

                }
            } else if (opcion == 5) {

                System.out.println("Murales registrados:");
                sistema.mostrarMurales();

                System.out.println("Ingrese el nombre del mural a modificar:");
                String nombreMural = input.nextLine();

                Mural unMural = sistema.buscarMural(nombreMural);

                if (unMural == null) {
                    System.out.println("El mural no existe.");
                } else {

                    System.out.println("Mural seleccionado: "
                            + unMural.getNombre());

                    int subOpcion = -1;

                    while (subOpcion != 0) {

                        System.out.println();
                        System.out.println("MENU MODIFICAR MURAL");
                        System.out.println("0 - Volver");
                        System.out.println("1 - Modificar posición");
                        System.out.println("2 - Reemplazar ficha");
                        System.out.println("3 - Restaurar");

                        System.out.println("Ingrese una opción:");
                        subOpcion = input.nextInt();
                        input.nextLine();

                        if (subOpcion == 0) {
                            System.out.println("Volviendo al menú principal.");

                        } else if (subOpcion == 1) {

                            System.out.println("Ingrese la fila (1 a 10):");
                            int fila = input.nextInt();

                            System.out.println("Ingrese la columna (1 a 12):");
                            int columna = input.nextInt();
                            input.nextLine();

                            if (fila >= 1 && fila <= 10
                                    && columna >= 1 && columna <= 12) {

                                System.out.println("Fichas disponibles:");
                                sistema.mostrarFichas();

                                System.out.println("Ingrese el nombre de la nueva ficha:");
                                String nombreFicha = input.nextLine();

                                Ficha unaFicha = sistema.buscarFicha(nombreFicha);

                                if (unaFicha == null) {
                                    System.out.println("La ficha no existe.");
                                } else {

                                    unMural.cambiarPosicion(fila, columna, unaFicha);

                                    System.out.println("Posición modificada correctamente.");

                                    System.out.println("Mural grande:");
                                    unMural.mostrarGrande();

                                    System.out.println("Mural chico:");
                                    unMural.mostrarChico();
                                }

                            } else {
                                System.out.println("Fila o columna inválida.");
                            }

                        } else if (subOpcion == 2) {

                            ArrayList<Ficha> fichasUsadas = unMural.obtenerFichasUsadas();

                            System.out.println("Fichas presentes en el mural:");

                            for (int i = 0; i < fichasUsadas.size(); i++) {
                                System.out.println(fichasUsadas.get(i).getNombre());
                            }

                            System.out.println("Ingrese la ficha que desea reemplazar:");
                            String nombreOriginal = input.nextLine();

                            Ficha unaFichaOriginal = sistema.buscarFicha(nombreOriginal);

                            if (unaFichaOriginal == null
                                    || !fichasUsadas.contains(unaFichaOriginal)) {

                                System.out.println("Esa ficha no está presente en el mural.");

                            } else {

                                System.out.println("Fichas disponibles:");
                                sistema.mostrarFichas();

                                System.out.println("Ingrese el nombre de la ficha nueva:");
                                String nombreNueva = input.nextLine();

                                Ficha unaFichaNueva = sistema.buscarFicha(nombreNueva);

                                if (unaFichaNueva == null) {
                                    System.out.println("La ficha nueva no existe.");
                                } else {

                                    unMural.reemplazarFicha(unaFichaOriginal, unaFichaNueva);

                                    System.out.println("Ficha reemplazada correctamente.");

                                    System.out.println("Mural grande:");
                                    unMural.mostrarGrande();

                                    System.out.println("Mural chico:");
                                    unMural.mostrarChico();
                                }
                            }
                        } else if (subOpcion == 3) {

                            unMural.restaurar();

                            System.out.println("Mural restaurado correctamente.");

                            System.out.println("Mural grande:");
                            unMural.mostrarGrande();

                            System.out.println("Mural chico:");
                            unMural.mostrarChico();

                        } else {
                            System.out.println("Opción incorrecta.");
                        }
                    }
                }

            } else if (opcion == 6) {

                System.out.println("Diseñadores:");
                sistema.mostrarDisenadores();

                System.out.println("Ingrese el nombre del diseñador:");
                String nombreDisenador = input.nextLine();

                Disenador unDisenador = sistema.buscarDisenador(nombreDisenador);

                if (unDisenador == null) {
                    System.out.println("El diseñador no existe.");
                } else {

                    System.out.println("Murales del diseñador:");
                    sistema.mostrarMuralesDe(unDisenador);

                    System.out.println("Ingrese el nombre del mural:");
                    String nombreMural = input.nextLine();

                    Mural unMural = sistema.buscarMural(nombreMural);

                    if (unMural == null
                            || unMural.getDisenador() != unDisenador) {

                        System.out.println("El mural no pertenece al diseñador.");

                    } else {

                        System.out.println("C - Chico / G - Grande:");
                        String tamano = input.nextLine().toUpperCase();

                        if (tamano.equals("C") || tamano.equals("G")) {

                            String comando = "";

                            while (!comando.equals("S")) {

                                if (tamano.equals("C")) {
                                    unMural.mostrarChico();
                                } else {
                                    unMural.mostrarGrande();
                                }

                                System.out.println(
                                        "ENTER para alternar tamaño, S para salir:");

                                comando = input.nextLine().toUpperCase();

                                if (comando.equals("")) {

                                    if (tamano.equals("C")) {
                                        tamano = "G";
                                    } else {
                                        tamano = "C";
                                    }
                                } else if (!comando.equals("S")) {
                                    System.out.println("Ingrese ENTER o S.");
                                }
                            }

                        } else {
                            System.out.println("Tamaño inválido.");
                        }
                    }
                }

            } else if (opcion == 7) {

                sistema.listadoDisenadores();

            } else if (opcion == 8) {

                System.out.println("Murales registrados:");
                sistema.mostrarMurales();

                System.out.println("Ingrese el nombre del mural original:");
                String nombreMural = input.nextLine();

                Mural unMural = sistema.buscarMural(nombreMural);

                if (unMural == null) {

                    System.out.println("El mural no existe.");

                } else {

                    System.out.println("Fila inicial:");
                    int fila = input.nextInt();

                    System.out.println("Columna inicial:");
                    int columna = input.nextInt();

                    System.out.println("Cantidad de filas:");
                    int alto = input.nextInt();

                    System.out.println("Cantidad de columnas:");
                    int ancho = input.nextInt();
                    input.nextLine();

                    if (fila < 1 || columna < 1
                            || alto < 1 || ancho < 1
                            || fila + alto - 1 > Mural.FILAS
                            || columna + ancho - 1 > Mural.COLUMNAS) {

                        System.out.println("Área inválida.");

                    } else {

                        sistema.compararSimilitud(
                                unMural, fila, columna, alto, ancho);
                    }
                }

            } else if (opcion == 9) {

                sistema.mostrarTodasLasFichas();

            } else {

                System.out.println("Opcion incorrecta");
            }
        }
    }
}
