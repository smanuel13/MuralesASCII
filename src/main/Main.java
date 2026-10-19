/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dominio.Sistema;
import dominio.Disenador;
import dominio.Ficha;
import java.util.Scanner;

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
                        }
                    }

                }

            } else if (opcion >= 5 && opcion <= 9) {

                System.out.println("pendiente");

            } else {

                System.out.println("Opcion incorrecta");
            }
        }
    }
}
