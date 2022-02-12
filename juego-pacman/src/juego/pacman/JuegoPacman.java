package juego.pacman;
import java.util.Scanner; // Importa la libreria Scanner
import java.util.Random; // Importa la libreria Random
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
        int filas, columnas, contador = 0;
        String movimiento;
        boolean exit = false;
        
        Random rand = new Random();
        
//      Posicion inicial de pacman
        int PosX, PosY;
//      Generador de paredes        
        int columnaRandom, filaRandom;
//      Para guardar el historial
        int contador_datos = 0;
//      Fruta de 10 puntos
        int contador_fruta_1 = 0; // @
//      Fruta de 15 puntos
        int contador_fruta_2 = 0; // $
//      Fruta de -10 puntos        
        int contador_fruta_3 = 0; // #
        
        int minimoFilas = 1;
        int minimoColumnas = 1;


//      Arreglos para el historial.
        String[] nombre = new String[50];
        int[] edad = new int[50];
        int[] puntaje = new int[50];
        int[] movimientos = new int[50];
        while(true)
        {
//      Muestra el menu.
        System.out.println("**********************\n"
                + "*1. Jugar            *\n"
                + "*2. Historial        *\n"
                + "*3. Salir            *\n"
                + "**********************"); 
        
        Scanner Scn = new Scanner(System.in);
        int menu_opcion = Scn.nextInt();
        
        if(exit == true)
            {
                exit = false;
                contador = 0;
            }
        if(menu_opcion == 1)
        {
//          Se ingresa el nombre.
            System.out.println("Ingrese su nombre:  ");
            nombre[contador_datos] = Scn.next();
            for(int i = 0; i <= 50; i++)
                {
                    if(nombre[i] != null){
                        break;
                    }else{
                        nombre[i] = Scn.next();
                    }
                }
            
//          Se ingresa la edad.
            System.out.println("Ingrese su edad: ");
            edad[contador_datos] = Scn.nextInt();
            
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
            
            int maximoFilas = filas - 2;
            int maximoColumnas = columnas - 2;
            
            while(exit != true){
//          Decide la posicion inicial de pacman               
            PosX = rand.nextInt(maximoFilas + minimoFilas) + minimoFilas;//filas = 10 | 0, 1, 2,...,9
            PosY = rand.nextInt(maximoColumnas + minimoColumnas) + minimoColumnas;
            
            while(exit != true)
            {
//              Parte de arriba    
                for(int fila = 0; fila < filas; fila++)
                {
                    tablero[fila][0] = "*"; 
                }
//              Columnas y espacios en blanco    
                for(int columna = 1; columna < columnas; columna++)
                {
//                  Espacio para el portal en las columnas (columna izquierda)                    
                    if(columna != (columnas / 2))
                    {
//                      Hace simetricas las columnas
                        if(columnas % 2 == 0)
                        {
                            tablero[0][columnas/2 - 1] = " ";
                        }else{
                            tablero[0][columnas/2 - 1] = " ";
                            tablero[0][columnas/2 + 1] = " ";
                        }
                        tablero[0][columna] = "*"; 
                    }else{
                        tablero[0][columna] = " "; 
                    }
                    
//                  Espacios en blanco    
                    for (int fila = 1; fila < filas; fila++)
                    {
                        if(PosX == fila && PosY == columna)
                        {
                            if(PosX != filas -1 && columnas != filas -1){
                            tablero[fila][columna] = "V";   
                            }else{
                                tablero[fila][columna] = "*";
                            }
                        }else{
                            tablero[fila][columna] = " ";
                            if(fila == filas - 1)
                            {
//                              Espacio para el portal en las columnas (columna derecha)    
                                if(columna != (columnas / 2))
                                {
//                                  Hace simetrica las columnas                                    
                                    if(columnas % 2 == 0){
                                        tablero[filas - 1][columnas/2 - 1] = " ";
                                    }else{
                                        tablero[filas - 1][columnas/2 - 1] = " ";
                                        tablero[filas - 1][columnas/2 + 1] = " ";
                                    }
                                    tablero[filas - 1][columna] = "*";
                                }else{
                                    tablero[filas - 1][columna] = " ";
                                }
                            }
                        }
                    }
                }
//              Parte de abajo    
                for(int fila = 0; fila < filas; fila++)
                {
                    tablero[fila][tablero[0].length - 1] = "*"; 
                }
//              Revisa si el pacman aparece dentro de una celda con valor *
                if(tablero[PosX][PosY] == "*"){
                    break;
                }
//              Añade la fruta de 15 puntos                
                do{
                    columnaRandom = rand.nextInt(maximoColumnas + minimoColumnas) + minimoColumnas;
                    filaRandom = rand.nextInt(maximoFilas + minimoFilas) + minimoFilas;
                    if(!"#".equals(tablero[filaRandom][columnaRandom]) && 
                            !"*".equals(tablero[filaRandom][columnaRandom]) &&
                            !"$".equals(tablero[filaRandom][columnaRandom]) &&
                            !"#".equals(tablero[filaRandom][columnaRandom]) &&
                            !"@".equals(tablero[filaRandom][columnaRandom]) &&
                            !"V".equals(tablero[filaRandom][columnaRandom]))
                    {
                        tablero[filaRandom][columnaRandom] = "$";
                        contador_fruta_2++;
                    }
                }while(contador_fruta_2 <= 0);
            
//              Añade la fruta de 10 puntos
                do{
                    columnaRandom = rand.nextInt(maximoColumnas + minimoColumnas) + minimoColumnas;
                    filaRandom = rand.nextInt(maximoFilas + minimoFilas) + minimoFilas;
                    if(!"#".equals(tablero[filaRandom][columnaRandom]) && 
                            !"*".equals(tablero[filaRandom][columnaRandom]) &&
                            !"$".equals(tablero[filaRandom][columnaRandom]) &&
                            !"#".equals(tablero[filaRandom][columnaRandom]) &&
                            !"@".equals(tablero[filaRandom][columnaRandom]) &&
                            !"V".equals(tablero[filaRandom][columnaRandom]))
                    {
                        tablero[filaRandom][columnaRandom] = "@";
                        contador_fruta_1++;
                    }
                }while(contador_fruta_1 <= 0);
                
//              Añade la fruta que quita 10 puntos                
                do{
                    columnaRandom = rand.nextInt(maximoColumnas + minimoColumnas) + minimoColumnas;
                    filaRandom = rand.nextInt(maximoFilas + minimoFilas) + minimoFilas;
                    if(!"#".equals(tablero[filaRandom][columnaRandom]) && 
                            !"*".equals(tablero[filaRandom][columnaRandom]) &&
                            !"$".equals(tablero[filaRandom][columnaRandom]) &&
                            !"#".equals(tablero[filaRandom][columnaRandom]) &&
                            !"@".equals(tablero[filaRandom][columnaRandom]) &&
                            !"V".equals(tablero[filaRandom][columnaRandom]))
                    {
                        tablero[filaRandom][columnaRandom] = "#";
                        contador_fruta_3++;
                    }
                }while(contador_fruta_3 <= 0);

//              Genera paredes dependiendo de cuantas filas y columnas hayan           
                do{
                    columnaRandom = rand.nextInt(maximoColumnas + minimoColumnas) + minimoColumnas;
                    filaRandom = rand.nextInt(maximoFilas + minimoFilas) + minimoFilas;
                    if(!"#".equals(tablero[filaRandom][columnaRandom]) && 
                            !"*".equals(tablero[filaRandom][columnaRandom]) &&
                            !"$".equals(tablero[filaRandom][columnaRandom]) &&
                            !"#".equals(tablero[filaRandom][columnaRandom]) &&
                            !"@".equals(tablero[filaRandom][columnaRandom]) &&
                            !"V".equals(tablero[filaRandom][columnaRandom]))
                    {
                        tablero[filaRandom][columnaRandom] = "*";
                        contador++;
                    }
                }while(contador<=columnas);
                while(exit != true)
                {
                    
//              Impresión de la tabla                
                for(int columna = 0; columna < columnas; columna++){
                    for(int fila = 0; fila < filas; fila++){
                        System.out.print(tablero[fila][columna] + " ");
                    }
                    System.out.println("");
                }

//                  Ingresa el movimiento    
                    System.out.println("Ingrese el movimiento [WASD][M para salir]: ");
                    movimiento = Scn.next();
  
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

//                  Mueve hacia arriba                    
                    if("w".equals(movimiento) || "W".equals(movimiento))
                    {
                        if(tablero[PosX][PosY - 1] == "*")
                        {
                            PosY = PosY;
                            movimientos[contador_datos] += 1;
                        }else if(tablero[PosX][PosY - 1] == "#")
                        {
                            tablero[PosX][PosY] = " ";
                            PosY -= 1;
                            tablero[PosX][PosY] = "V";
                            movimientos[contador_datos] += 1;
                            puntaje[contador_datos] -= 10;
                            contador_fruta_3 = 0;
                        }else if(tablero[PosX][PosY - 1] == "$")
                        {
                            tablero[PosX][PosY] = " ";
                            PosY -= 1;
                            tablero[PosX][PosY] = "V";
                            movimientos[contador_datos] += 1;
                            puntaje[contador_datos] += 15;
                            contador_fruta_2 = 0;
                        }else if(tablero[PosX][PosY - 1] == "@")
                        {
                            tablero[PosX][PosY] = " ";
                            PosY -= 1;
                            tablero[PosX][PosY] = "V";
                            movimientos[contador_datos] += 1;
                            puntaje[contador_datos] += 10;
                            contador_fruta_1 = 0;
                        }else{
                            tablero[PosX][PosY] = " ";
                            PosY -= 1;
                            tablero[PosX][PosY] = "V";
                            movimientos[contador_datos] += 1;
                        }

                    }
//                  Mueve hacia abajo
                    else if("s".equals(movimiento) || "S".equals(movimiento))
                    {
                        if(tablero[PosX][PosY + 1] == "*")
                        {
                            PosY = PosY;
                            movimientos[contador_datos] += 1;
                        }else if(tablero[PosX][PosY + 1] == "#")
                        {
                            tablero[PosX][PosY] = " ";
                            PosY += 1;
                            tablero[PosX][PosY] = "V";
                            movimientos[contador_datos] += 1;
                            puntaje[contador_datos] -= 10;
                            contador_fruta_3 = 0;
                        }else if(tablero[PosX][PosY + 1] == "$")
                        {
                            tablero[PosX][PosY] = " ";
                            PosY += 1;
                            tablero[PosX][PosY] = "V";
                            movimientos[contador_datos] += 1;
                            puntaje[contador_datos] += 15;
                            contador_fruta_2 = 0;
                        }else if(tablero[PosX][PosY + 1] == "@")
                        {
                            tablero[PosX][PosY] = " ";
                            PosY += 1;
                            tablero[PosX][PosY] = "V";
                            movimientos[contador_datos] += 1;
                            puntaje[contador_datos] += 10;
                            contador_fruta_1 = 0;
                        }else{
                            tablero[PosX][PosY] = " ";
                            PosY += 1;
                            tablero[PosX][PosY] = "V";
                            movimientos[contador_datos] += 1;
                        }
                    }
//                  Mueve a la izquierda
                    else if("a".equals(movimiento) || "A".equals(movimiento))
                    {
//                      Teletransportación del lado izquierdo
                        if(PosX == 0)
                        {
                            if(tablero[filas - 1][PosY] == "*")
                            {
                                PosX = PosX;
                                movimientos[contador_datos] += 1;
                            }else{
                            tablero[PosX][PosY] = " ";
                            PosX = filas - 1;
                            tablero[PosX][PosY] = "V";
                            }
                        }
                        else if(tablero[PosX - 1][PosY] == "*")
                        {
                            PosX = PosX;
                            movimientos[contador_datos] += 1;

                        }else if(tablero[PosX - 1][PosY] == "#")
                        {
                            tablero[PosX][PosY] = " ";
                            PosX -= 1;
                            tablero[PosX][PosY] = "V";
                            puntaje[contador_datos] -= 10;
                            contador_fruta_3 = 0;
                        }else if(tablero[PosX - 1][PosY] == "$")
                        {
                            tablero[PosX][PosY] = " ";
                            PosX -= 1;
                            tablero[PosX][PosY] = "V";
                            puntaje[contador_datos] += 15;
                            contador_fruta_2 = 0;
                        }else if(tablero[PosX - 1][PosY] == "@")
                        {
                            tablero[PosX][PosY] = " ";
                            PosX -= 1;
                            tablero[PosX][PosY] = "V";
                            puntaje[contador_datos] += 10;
                            contador_fruta_1 = 0;
                        }else{
                            tablero[PosX][PosY] = " ";
                            PosX -= 1;
                            tablero[PosX][PosY] = "V";
                            movimientos[contador_datos] += 1;
                        }
                    }
//                  Mueve a la derecha
                    else if("d".equals(movimiento) || "D".equals(movimiento))
                    {
//                      Teletransportación del lado derecho
                        if(PosX == filas - 1)
                            {
                            if(tablero[0][PosY] == "*")
                            {
                                PosX = PosX;
                                movimientos[contador_datos] += 1;
                            }else{
                                tablero[PosX][PosY] = " ";
                                PosX = 0;
                                tablero[PosX][PosY] = "V";
                            }
                        }
                        else if(tablero[PosX + 1][PosY] == "*")
                        {
                            PosX = PosX;
                            movimientos[contador_datos] += 1;

                        }else if(tablero[PosX + 1][PosY] == "#")
                        {
                            tablero[PosX][PosY] = " ";
                            PosX += 1;
                            tablero[PosX][PosY] = "V";
                            puntaje[contador_datos] -= 10;
                            contador_fruta_3 = 0;
                        }else if(tablero[PosX + 1][PosY] == "$")
                        {
                            tablero[PosX][PosY] = " ";
                            PosX += 1;
                            tablero[PosX][PosY] = "V";
                            puntaje[contador_datos] += 15;
                            contador_fruta_2 = 0;
                        }else if(tablero[PosX + 1][PosY] == "@")
                        {
                            tablero[PosX][PosY] = " ";
                            PosX += 1;
                            tablero[PosX][PosY] = "V";
                            puntaje[contador_datos] += 10;
                            contador_fruta_1 = 0;
                        }else{
                            tablero[PosX][PosY] = " ";
                            PosX += 1;
                            tablero[PosX][PosY] = "V";
                            movimientos[contador_datos] += 1;
                        }
                    
                    }
//                  Cierra la partida actual    
                    else if("m".equals(movimiento) || "M".equals(movimiento))
                    {
                        exit = true;
                        contador_datos++;
                    }else{
                        System.out.println("Ingrese una tecla valida!");
                    }
                if(contador_fruta_3 == 0)
                {
//              Añade la fruta que quita 10 puntos                
                do{
                    columnaRandom = rand.nextInt(maximoColumnas + minimoColumnas) + minimoColumnas;
                    filaRandom = rand.nextInt(maximoFilas + minimoFilas) + minimoFilas;
                    if(!"#".equals(tablero[filaRandom][columnaRandom]) && 
                            !"*".equals(tablero[filaRandom][columnaRandom]) &&
                            !"$".equals(tablero[filaRandom][columnaRandom]) &&
                            !"#".equals(tablero[filaRandom][columnaRandom]) &&
                            !"@".equals(tablero[filaRandom][columnaRandom]) &&
                            !"V".equals(tablero[filaRandom][columnaRandom]))
                    {
                        tablero[filaRandom][columnaRandom] = "#";
                        contador_fruta_3++;
                    }
                }while(contador_fruta_3 <= 0);
                }
                if(contador_fruta_2 == 0)
                {
//              Añade la fruta de 15 puntos
                do{
                    columnaRandom = rand.nextInt(maximoColumnas + minimoColumnas) + minimoColumnas;
                    filaRandom = rand.nextInt(maximoFilas + minimoFilas) + minimoFilas;
                    if(!"#".equals(tablero[filaRandom][columnaRandom]) && 
                            !"*".equals(tablero[filaRandom][columnaRandom]) &&
                            !"$".equals(tablero[filaRandom][columnaRandom]) &&
                            !"#".equals(tablero[filaRandom][columnaRandom]) &&
                            !"@".equals(tablero[filaRandom][columnaRandom]) &&
                            !"V".equals(tablero[filaRandom][columnaRandom]))
                    {
                        tablero[filaRandom][columnaRandom] = "$";
                        contador_fruta_2++;
                    }
                }while(contador_fruta_2 <= 0);
                }
                if(contador_fruta_1 == 0)
                {
//              Añade la fruta de 10 puntos                
                do{
                    columnaRandom = rand.nextInt(maximoColumnas + minimoColumnas) + minimoColumnas;
                    filaRandom = rand.nextInt(maximoFilas + minimoFilas) + minimoFilas;
                    if(!"#".equals(tablero[filaRandom][columnaRandom]) && 
                            !"*".equals(tablero[filaRandom][columnaRandom]) &&
                            !"$".equals(tablero[filaRandom][columnaRandom]) &&
                            !"#".equals(tablero[filaRandom][columnaRandom]) &&
                            !"@".equals(tablero[filaRandom][columnaRandom]) &&
                            !"V".equals(tablero[filaRandom][columnaRandom]))
                    {
                        tablero[filaRandom][columnaRandom] = "@";
                        contador_fruta_1++;
                    }
                }while(contador_fruta_1 <= 0);
                }
                
                }
            }
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
                    System.out.println("Puntaje: "+ puntaje[i]);
                    System.out.println("Movimientos: "+ movimientos[i]);
                    System.out.println("");
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
}