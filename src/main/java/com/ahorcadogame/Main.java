package com.ahorcadogame;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar el mensaje de bienvenida y el menú inicial
        boolean salir = false;
        while (!salir) {
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
                    iniciarJuego(scanner);
                    break;
                case 2:
                    salir = true;
                    System.out.println("♨");
                    System.out.println("✧˚ ༘ ⋆｡˚ Gracias por jugar. Hasta luego :D");
                    System.out.println("♨");
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
            System.out.println("Palabra: " + String.valueOf(guiones));
            System.out.print("Ingrese una letra: ");
            char letra = scanner.next().charAt(0);

            if (letrasIngresadas.contains(letra)) {
                System.out.println("Ya has ingresado esa letra. Intenta con otra.");
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
            System.out.println("¡Felicidades! Adivinaste la palabra: " + palabraSecreta);
        } else {
            System.out.println("Lo siento, has perdido. La palabra era: " + palabraSecreta);
        }
    }

    // dibujo del ahorcado dependiendo de los intentos fallios
    private static void dibujarAhorcado(int intentos) {
        System.out.println("Intentos fallidos: " + intentos);
        switch (intentos) {
            case 1:
                System.out.println(" O ");
                break;
            case 2:
                System.out.println(" O ");
                System.out.println(" | ");
                break;
            case 3:
                System.out.println(" O ");
                System.out.println(" | ");
                System.out.println("/ \\");
                break;
            default:
                break;
        }
    }
}