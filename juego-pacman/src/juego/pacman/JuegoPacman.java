/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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
        // TODO code application logic here
        System.out.println("**********************\n"
                + "*1. Jugar            *\n"
                + "*2. Historial        *\n"
                + "*3. Salir            *\n"
                + "**********************"); //Muestra el menu
        Scanner MyObj = new Scanner(System.in);
        int menu_opcion = MyObj.nextInt();
        
        if(menu_opcion == 1){
            System.out.println("Ingrese su nombre: ");
            String nombre = MyObj.nextLine();
            
            System.out.println("Ingrese su edad: ");
            int edad = MyObj.nextInt();
            
            System.out.println("Ingrese las dimensiones del tablero"
                    + "(Tamaño mínimo 8*8): ");
            
        }
            
    }
    
}