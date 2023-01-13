package compartida;

import java.util.Random;
import java.util.Scanner;
import static compartida.Utils.*;

public class Proyecto10UF2 {

    public static void main(String[] args) {
        
    }

    public static void ShowTable(int[][] tablero) {
        for (int i = 0; i < tablero.length; ++i) {
            for (int j = 0; j < tablero[i].length; ++j) {
                switch (tablero[i][j]) {
                    case 1:
                        System.out.print(RED_BACKGROUND + tablero[i][j] + RESET);
                        break;
                    case 2:
                        System.out.print(PURPLE_BACKGROUND + tablero[i][j] + RESET);
                        break;
                    case 3:
                        System.out.print(GREEN_BACKGROUND + tablero[i][j] + RESET);
                        break;
                    case 4:
                        System.out.print(BLUE_BACKGROUND + tablero[i][j] + RESET);
                        break;
                    default:
                        System.out.print(tablero[i][j]);
                        break;
                }

            }
            System.out.println("");
        }
    }

    static void square(int[][] tablero) {
        tablero[0][tablero.length / 2] = 1;
        tablero[0][tablero.length / 2 + 1] = 1;
        tablero[1][tablero.length / 2] = 1;
        tablero[1][tablero.length / 2 + 1] = 1;
    }

    static void primeraL(int[][] tablero) {
        tablero[0][tablero.length / 2 - 1] = 2;
        tablero[1][tablero.length / 2 - 1] = 2;
        tablero[1][tablero.length / 2] = 2;
        tablero[1][tablero.length / 2 + 1] = 2;
    }

    static void segundaL(int[][] tablero) {
        tablero[0][tablero.length / 2] = 3;
        tablero[1][tablero.length / 2] = 3;
        tablero[2][tablero.length / 2] = 3;
        tablero[2][tablero.length / 2 - 1] = 3;
    }

    static void larga(int[][] tablero) {
        tablero[0][tablero.length / 2] = 4;
        tablero[1][tablero.length / 2] = 4;
        tablero[2][tablero.length / 2] = 4;
        tablero[3][tablero.length / 2] = 4;
    }

    static void Ficha(int randomnum, int[][] tablero) {
        switch (randomnum) {
            case 0:
                square(tablero);
                break;
            case 1:
                primeraL(tablero);
                break;
            case 2:
                segundaL(tablero);
                break;
            case 3:
                larga(tablero);
                break;
        }

    }

    static void Game(int[][] tablero) {
        Random r = new Random();
        boolean corte=false;
        while(!corte){
            int fichaElegida = r.nextInt(4);
            Ficha(fichaElegida, tablero);
        }

    }

}
