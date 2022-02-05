package juego.pacman;
import java.util.Scanner; // Importa la clase Scanner
/**
 *
 * @author anyelo
 */
public class JuegoPacman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//      Estructura base para el movimiento de Pacman.   
        int filas = 8, columnas = 8;
        
        int[][] pacman = new int[filas][columnas];
        
        pacman[0][0] = 0;

//      Arreglos para el historial.
        String[] nombre = new String[50];
        int[] edad = new int[50];
        int[] puntaje = new int[50];
        int[] movimientos = new int[50];
        
//      Muestra el menu.
        System.out.println("**********************\n"
                + "*1. Jugar            *\n"
                + "*2. Historial        *\n"
                + "*3. Salir            *\n"
                + "**********************"); 
        
        Scanner Scn = new Scanner(System.in);
        int menu_opcion = Scn.nextInt();
        
        if(menu_opcion == 1)
        {
//          Se ingresa el nombre.
            System.out.println("Ingrese su nombre:  ");
            nombre[0] = Scn.next();
            
//          Se ingresa la edad.
            System.out.println("Ingrese su edad: ");
            edad[0] = Scn.nextInt();
            
            System.out.println("Ingrese las dimensiones del tablero"
                    + "(Tamaño mínimo 8*8): ");
//          Revisa si las dimensiones no son menores a 8.
            while(true)
            {
//          Se ingresa la dimension del tablero.            
                System.out.println("Filas: ");
                filas = Scn.nextInt();
                
                System.out.println("Columnas: ");
                columnas = Scn.nextInt();
                
                if(filas < 8 || columnas < 8)
                {
                    System.out.println("Por favor seleccione una dimension mayor"
                            + "o igual a 8");
                }else{
                    break;
                }
            }
//          Creacion del tablero
            String[][] tablero = new String[filas][columnas];
            
//          Parte de arriba
            for(int fila = 0; fila < tablero.length; fila++)
            {
                tablero[fila][0] = " *"; 
                System.out.print(tablero[fila][0]);
            }
            System.out.println(""); //solo para darle forma
            for(int columna = 1; columna < tablero[0].length; columna++)
            {
//              Espacio para el portal en las columnas                
                if(columna != (columnas / 2)){
                    tablero[0][columna] = "*"; 
                    System.out.print(tablero[0][columna]);
                }else{
                    tablero[0][columna] = " "; 
                    System.out.print(tablero[0][columna]);
                }
                
                for (int j = 1; j < tablero[0].length; j++)
                {
                    tablero[j][columna] = "  ";
                    System.out.print(tablero[j][columna]);
                    if(j == tablero[0].length -1)
                    {
                        if(columna != (columnas / 2))
                        {
                            tablero[tablero.length - 1][columna] = "*"; 
                            System.out.println(tablero[tablero.length - 1][columna]);
                        }else{
                            tablero[tablero.length - 1][columna] = " "; 
                            System.out.println(tablero[tablero.length - 1][columna]);
                        }
                    }
                }
                

            }
//          Parte de abajo
            for(int fila = 0; fila < tablero[0].length; fila++)
            {
                tablero[fila][tablero.length - 1] = " *"; 
                System.out.print(tablero[fila][tablero.length - 1]);
            }
        }
    
        else if(menu_opcion == 2)
        {
//          Impresion del historial
            for(int i = 0; i <= nombre.length -1; i++)
            {
                if(nombre[i] != null) //Solo muestra los valores que no sean cero.
                { 
                    System.out.println("Nombre del jugador: "+ nombre[i]);
                    System.out.println("Edad: "+ edad[i]);
                    System.out.println(puntaje[i]);
                    System.out.println(movimientos[i]);   
                }
            }
            System.out.println("MOSTRAR HISTORIAL"); // Se mostrara el historial (pendiente)
        }
        else if(menu_opcion == 3)
        {
            System.out.println("Se salió del programa.");
            System.exit(0);
        }
            
    }
    
}