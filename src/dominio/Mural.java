/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/*
* Juan Pablo Doncel 320505
* Victor Silva 344919
 */
public class Mural {

    //el final es para que no pueda cambiar el valor
    public static final int FILAS = 10;
    public static final int COLUMNAS = 12;
    private String formato;
    private String nombre;
    private Ficha[][] matrizFichas;
    private Ficha fichaInicial1;
    private Ficha fichaInicial2;
    private Disenador disenador;

    public Mural() {
        this.nombre = "sin nombre";
        this.formato = "M";
        this.disenador = null;
        this.fichaInicial1 = null;
        this.fichaInicial2 = null;
        this.matrizFichas = new Ficha[FILAS][COLUMNAS];
    }

    public Mural(String unFormato, String unNombre, Ficha[][] matrizFichas, Ficha f1, Ficha f2, Disenador unDisenador) {
        this.formato = (unFormato);
        this.nombre = (unNombre);
        this.matrizFichas = matrizFichas;
        this.fichaInicial1 = f1;
        this.fichaInicial2 = f2;
        this.disenador = (unDisenador);

        //iniciar matriz con el formato que se elija
        this.restaurar();
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ficha[][] getMatrizFichas() {
        return matrizFichas;
    }

    public void setMatrizFichas(Ficha[][] matrizFichas) {
        this.matrizFichas = matrizFichas;
    }

    public Ficha getFichaInicial1() {
        return fichaInicial1;
    }

    public void setFichaInicial1(Ficha fichaInicial1) {
        this.fichaInicial1 = fichaInicial1;
    }

    public Ficha getFichaInicial2() {
        return fichaInicial2;
    }

    public void setFichaInicial2(Ficha fichaInicial2) {
        this.fichaInicial2 = fichaInicial2;
    }

    public Disenador getDisenador() {
        return disenador;
    }

    public void setDisenador(Disenador disenador) {
        this.disenador = disenador;
    }

    //cambia ficha de posición 
    public void cambiarPosicion(int fila, int col, Ficha f) {
        if (fila >= 1 && fila <= FILAS && col >= 1 && col <= COLUMNAS) {
            this.matrizFichas[fila - 1][col - 1] = f;
        }
    }
    // modificarficha

    public void reemplazarFicha(Ficha fOriginal, Ficha fNueva) {

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (this.matrizFichas[i][j] != null && this.matrizFichas[i][j].equals(fOriginal)) {
                    this.matrizFichas[i][j] = fNueva;
                }
            }
        }
    }

    //restaurar el patron inical del mural
    public void restaurar() {
        String formt = this.getFormato().toUpperCase();

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (formt.equals("D")) {
                    if ((i + j) % 2 == 0) {
                        this.matrizFichas[i][j] = this.fichaInicial1;
                    } else {
                        this.matrizFichas[i][j] = this.fichaInicial2;
                    }
                } else if (formt.equals("F")) {
                    if (i % 2 == 0) {
                        this.matrizFichas[i][j] = this.fichaInicial1;
                    } else {
                        this.matrizFichas[i][j] = this.fichaInicial2;
                    }
                } else if (formt.equals("B")) {
                    if (i == 0 || i == FILAS - 1 || j == 0 || j == COLUMNAS - 1) {
                        this.matrizFichas[i][j] = this.fichaInicial1;
                    } else {
                        this.matrizFichas[i][j] = this.fichaInicial2;
                    }
                } else if (formt.equals("R")) {
                    if (Math.random() < 0.5) {
                        this.matrizFichas[i][j] = this.fichaInicial1;
                    } else {
                        this.matrizFichas[i][j] = this.fichaInicial2;
                    }
                } else {
                    this.matrizFichas[i][j] = this.fichaInicial1;
                }
            }
        }
    }

    @Override
    public String toString() {
        String nomDis = "sin autor";
        if (this.getDisenador() != null) {
            nomDis = this.getDisenador().getNombre();
        }
        String res = this.getNombre() + " (Diseñador: " + nomDis + ")";
        return res;
    }
}
    

