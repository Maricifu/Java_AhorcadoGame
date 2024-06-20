package com.ahorcadogame;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // menu principal del juego
        boolean salir = false;
        while (!salir) {
            limpiarPantalla(); 
            System.out.println("♨");
            System.out.println("♨");
            System.out.println("♨");
            System.out.println("✧˚ ༘ Bienvenido al juego del Gato Ahorcado ༘ ⋆");
            System.out.println(" ---------------------------------------------- ");
            System.out.println(" | La tematica del juego son alimentos dulces |");
            System.out.println(" |--------------------------------------------| ");
            System.out.println(" |            | ---/|                         |");
            System.out.println(" |            | ,_, |                         |");
            System.out.println(" |              _`_/-..----.                  |");
            System.out.println(" |            _/ `   ' ,                      |");
            System.out.println(" |           (__...'   __     |`.___.';       |");
            System.out.println(" |             (_,...'(_,.`__)/'.....+        |");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("♨");
            System.out.println("♨");
            System.out.println("♨");
            System.out.println("|OPCIONES: -------------");
            System.out.println("|  1. Iniciar juego    |");
            System.out.println("|  2. Salir            |");
            System.out.println("------------------------");
            System.out.println("♨");
            System.out.print("✧˚ ༘ ⋆｡˚ Seleccione una opción: "); 
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    jugar(scanner);
                    break;
                case 2:
                    salir = true;
                    limpiarPantalla();
                    System.out.println("♨");
                    System.out.println("✧˚ ༘ ⋆｡˚ Gracias por jugar. Hasta luego :D");
                    System.out.println("              /\\_____/\\\n " );
                    System.out.println("             /  o   o  \\\n"  );
                    System.out.println("            ( ==  ^  == )\n" );
                    System.out.println("             )         (\n" );
                    System.out.println("            (           )\n" );
                    System.out.println("           ( (  )   (  ) )\n" );
                    System.out.println("          (__(__)___(__)__)");
                    break;
                default:
                    System.out.println("♨");
                    System.out.println("✧˚ ༘ ⋆｡˚ Opción no válida. Intente de nuevo :c");
                    System.out.println("♨");
            }
        }

        scanner.close();
    }

    private static void iniciarJuego(Scanner scanner) {
        // array de palabras secretas
        String[] palabrasSecretas = {
            "helado", 
            "brownie", 
            "caramelo", 
            "chocolate", 
            "bocadillo", 
            "oblea", 
            "arequipe",
            "galleta"
        };
        
        // elecccion random de palabras secretas
        String palabraSecreta = palabrasSecretas[new Random().nextInt(palabrasSecretas.length)];
        char[] palabra = palabraSecreta.toCharArray();
        char[] guiones = new char[palabra.length];
        
        // iniciar el arreglo por los guiones 
        for (int i = 0; i < palabra.length; i++) {
            guiones[i] = '_';
        }
        
        int intentos = 0;
        boolean palabraAdivinada = false;
        Set<Character> letrasIngresadas = new HashSet<>();

        while (intentos < 3 && !palabraAdivinada) {
            System.out.println("Palabra: " + mostrarGuionesSeparados(guiones));
            System.out.print("Ingrese una letra: ");
            System.out.println("✧˚ ༘ ⋆｡˚");
            char letra = scanner.next().charAt(0);

            if (letrasIngresadas.contains(letra)) {
                System.out.println("♨");
                System.out.println("Ya has ingresado esa letra. Intenta con otra.");
                System.out.println("♨");
                continue;
            }

            letrasIngresadas.add(letra);

            boolean acierto = false;
            for (int i = 0; i < palabra.length; i++) {
                if (palabra[i] == letra) {
                    guiones[i] = letra;
                    acierto = true;
                }
            }

            if (!acierto) {
                intentos++;
                dibujarAhorcado(intentos);
            }

            palabraAdivinada = String.valueOf(guiones).equals(palabraSecreta);
        }

        if (palabraAdivinada) {
            limpiarPantalla(); 
            System.out.println("✧˚ ༘ ⋆｡˚");
            System.out.println(" ---------------------------------------------- ");
            System.out.println(" |   ¡Felicidades! Adivinaste la palabra :D   |");
            System.out.println(" |--------------------------------------------| ");
            System.out.println(" |            | ---/|     " +  palabraSecreta +" <-----------------{{{");
            System.out.println(" |            | >_< |                         |");
            System.out.println(" |              _U_/-..----.                  |");
            System.out.println(" |            _/ `   ' ,                      |");
            System.out.println(" |           (__...'   __     |`.___.';       |");
            System.out.println(" |             (_,...'(_,.`__)/'.....+        |");
            System.out.println(" ---------------------------------------------- ");
            System.out.println("✧˚ ༘ ⋆｡˚");
        } else {
            System.out.println("✧˚ ༘ ⋆｡˚");
            System.out.println("Haz matado a el gato :C. La palabra era: " + palabraSecreta);
            System.out.println("✧˚ ༘ ⋆｡˚");
        }
    }

    // método para mostrar guiones separados
    private static String mostrarGuionesSeparados(char[] guiones) {
        StringBuilder sb = new StringBuilder();
        for (char c : guiones) {
            sb.append(c).append(' ');
        }
        return sb.toString().trim();
    }

    // metodo de eleccion al terminar el juego
    private static void jugar(Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            iniciarJuego(scanner);
    
            System.out.println("♨");
            System.out.println("¿Desea continuar jugando? (S/N): ");
            char respuesta = scanner.next().charAt(0);
            if (respuesta == 'N' || respuesta == 'n') {
                continuar = false;
            } else {
                limpiarPantalla(); 
            }
        }
    }

    // limpiar pantalla
    private static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    

    // dibujo del ahorcado dependiendo de los intentos fallidos
    private static void dibujarAhorcado(int intentos) {
        limpiarPantalla(); 
        System.out.println("Intentos fallidos: " + intentos);
        switch (intentos) {
            case 1:
                System.out.println("✧˚ ༘ ⋆｡˚");
                System.out.println(" |--------------------------------------------| ");
                System.out.println(" |            | ---/|               (1)       |");
                System.out.println(" |            | ,_, |                         |");
                System.out.println(" |-------->      o`_/-..----.                 |");
                System.out.println(" |            _/ `   ' ,                      |");
                System.out.println(" |           (__...'   __     |`.___.';       |");
                System.out.println(" |             (_,...'(_,.`__)/'.....+        |");
                System.out.println(" ---------------------------------------------- ");
                break;
            case 2:
                System.out.println("✧˚ ༘ ⋆｡˚");
                System.out.println(" |--------------------------------------------| ");
                System.out.println(" |            | ---/|               (2)       |");
                System.out.println(" |            | u_u |                         |");
                System.out.println(" |------------------------->                  |");
                System.out.println(" |            _/ `   ' ,                      |");
                System.out.println(" |           (__...'   __     |`.___.';       |");
                System.out.println(" |             (_,...'(_,.`__)/'.....+        |");
                System.out.println(" ---------------------------------------------- ");
                break;
            case 3:
                System.out.println("✧˚ ༘ ⋆｡˚");
                System.out.println(" |--------------------------------------------| ");
                System.out.println(" |            | ---/|            WASTED       |");
                System.out.println(" |            | x_x |                         |");
                System.out.println(" |----------------------------------------->  |");
                System.out.println(" |            _/ `   ' ,                      |");
                System.out.println(" |           (__...'   __     |`.___.';       |");
                System.out.println(" |             (_,...'(_,.`__)/'.....+        |");
                System.out.println(" ---------------------------------------------- ");
                break;
            default:
                break;
        }
    }
}
