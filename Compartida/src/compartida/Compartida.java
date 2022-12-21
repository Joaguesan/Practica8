package compartida;
import java.util.Scanner;
import static utilidades.Utils.pedirnumE;
public class Compartida {
static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int fila= s.nextInt();
        int columna = s.nextInt();
        int[][] tauler= new int[fila][columna];
        System.out.println(Jugada(tauler, 3, 1));
        System.out.println(Jugada(tauler, 3, 1));
        System.out.println(Jugada(tauler, 3, 1));
        System.out.println(Jugada(tauler, 3, 1));
        System.out.println(Jugada(tauler, 3, 1));
        System.out.println(Jugada(tauler, 3, 1));
        System.out.println(Jugada(tauler, 1, 2));
        Dibuja(tauler);
        boolean tres =EnRatlla(tauler, 4,2);
        System.out.println(tres);
    }
    public static int Jugada(int[][] tablero, int columna, int jugador){
        int fila=-1;
        boolean corte=true;
        try{        
            for(int i=tablero.length-1;i>=0 && corte;--i){
                if(tablero[i][columna-1]==0){
                    tablero[i][columna-1]=jugador;
                    fila=i+1;
                    corte=false;
                }
            }
        }
        catch(Exception e){
            fila=-1;
        }
        return fila;
    }
    public static boolean EnRatlla(int[][] tablero, int fila, int columna){
        boolean ganador;
        int jugador = tablero[fila-1][columna-1];
        int contador = 0;
        int contador1 = 0;
        boolean corte = true;
        if(jugador==0){
            ganador=false;
        }
        else{
            for(int i=0;i<tablero.length;++i){
                    if(tablero[fila-1][i]==jugador){
                        contador++;
                    }
                    if(tablero[i][columna-1]==jugador){
                        contador1++;
                    }
                    if(contador==4 || contador1==4){
                        corte=false;
                    }
                
            }
            ganador=contador==4 || contador1==4;
        }
        return ganador;
    }
    public static void Dibuja(int[][] tablero){
        for(int i=0;i<tablero.length;++i){
            for(int j=0;j<tablero[i].length;++j){
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
    }
    public static void Juego(int jugador1, int jugador2){
        int valor1 = jugador1;
        int valor2 = jugador2;
        System.out.println("-Tamaño del tablero-");
        int fila=pedirnumE("Número de filas: ");
        int columnas=pedirnumE("Número de columnas: ");
        
        
    }
    
}
