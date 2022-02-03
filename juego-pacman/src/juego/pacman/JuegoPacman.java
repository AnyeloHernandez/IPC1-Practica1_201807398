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
/*      Estructura base para el movimiento de Pacman      
        int fila = 8;
        int columna = 8;
        int[][] pacman = new [fila][columna];
      
        pacman[0][0] = 0;
*/          
//      Arreglos para el historial
        String[] nombre = new String[50];
        int[] edad = new int[50];
        int[] puntaje = new int[50];
        int[] movimientos = new int[50];
        
//      Muestra el menu
        System.out.println("**********************\n"
                + "*1. Jugar            *\n"
                + "*2. Historial        *\n"
                + "*3. Salir            *\n"
                + "**********************"); 
        
        Scanner Scn = new Scanner(System.in);
        int menu_opcion = Scn.nextInt();
        
        if(menu_opcion == 1)
        {
            System.out.println("Ingrese su nombre:  ");
            nombre[0] = Scn.next();
            
            System.out.println("Ingrese su edad: ");
            edad[0] = Scn.nextInt();
            
            System.out.println("Ingrese las dimensiones del tablero"
                    + "(Tamaño mínimo 8*8): ");
            
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