package compartida;

import java.util.Scanner;
import static utilidades.Utils.pedirnumE;
import java.util.Random;

public class Compartida {

    static Scanner s = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {
        int jugador = s.nextInt();
        int jugador2 = s.nextInt();
        Juego(jugador,jugador2);
       
    }

    public static int Jugada(int[][] tablero, int columna, int jugador) {
        int fila = -1;
        boolean corte = true;
        try {
            for (int i = tablero.length - 1; i >= 0 && corte; --i) {
                if (tablero[i][columna - 1] == 0) {
                    tablero[i][columna - 1] = jugador;
                    fila = i + 1;
                    corte = false;
                }
            }
        } catch (Exception e) {
            fila = -1;
        }
        return fila;
    }

    public static boolean EnRatlla(int[][] tablero, int fila, int columna) {
        boolean ganador;
        int jugador = tablero[fila - 1][columna - 1];
        int contador = 0;
        int contador1 = 0;
        boolean corte = true;
        if (jugador == 0) {
            ganador = false;
        } else {
            for (int i = 0; i < tablero.length && corte; ++i) {
                if (tablero[fila - 1][i] == jugador) {
                    contador++;
                } else {
                    contador = 0;
                }
                if (tablero[i][columna - 1] == jugador) {
                    contador1++;
                } else {
                    contador1 = 0;
                }
                if (contador == 4 || contador1 == 4) {
                    corte = false;
                }

            }
            ganador = contador == 4 || contador1 == 4;
        }
        return ganador;
    }

    public static void Dibuja(int[][] tablero) {
        for (int i = 0; i < tablero.length; ++i) {
            for (int j = 0; j < tablero[i].length; ++j) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }

    public static void Juego(int jugador1, int jugador2) {

        boolean corte = false;
        System.out.println("-Tamaño del tablero-");
        int filas = pedirnumE("Número de filas: ");
        int columnas = pedirnumE("Número de columnas: ");
        int[][] tablero = new int[filas][columnas];
        int primero = r.nextInt(2);
        int jugador;
        if (primero == 0) {
            jugador = jugador1;
        } else {
            jugador = jugador2;
        }
        System.out.println("Empieza el jugador " + jugador);
        int ultimo;
        while (!corte) {
            Dibuja(tablero);
            if (jugador == jugador1) {
                System.out.println("-Jugador "+jugador+"-");
                int column = pedirnumE("Columna a poner la ficha: ");
                ultimo = Jugada(tablero, column, jugador);
                corte = EnRatlla(tablero, ultimo,column);
                jugador++;
            } else if (jugador == jugador2) {
                System.out.println("-Jugador "+jugador+"-");
                int column = pedirnumE("Columna a poner la ficha: ");
                ultimo = Jugada(tablero, column, jugador);
                corte = EnRatlla(tablero, ultimo,column);
                jugador--;
            }
        }

    }

}
