package com.example;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Ingreso de Datos del Tiro Parabólico ---");
        System.out.print("Ingrese el ángulo (en grados): ");
        float angulo = scanner.nextFloat();
        System.out.print("Ingrese la velocidad en X: ");
        float velocidad_X = scanner.nextFloat();
        System.out.print("Ingrese la velocidad en Y: ");
        float velocidad_Y = scanner.nextFloat();
        System.out.print("Ingrese la gravedad: ");
        float gravedad = scanner.nextFloat();

        FisicaTiroParabolico tiro = new FisicaTiroParabolico(angulo, velocidad_X, velocidad_Y, gravedad);

        int opcion;

        do {
            System.out.println("\n--- Menú de Cálculos de Tiro Parabólico ---");
            System.out.println("1. Ingresar Nuevos Datos del Constructor");
            System.out.println("2. Calcular Altura Máxima");
            System.out.println("3. Calcular Tiempo de Vuelo");
            System.out.println("4. Calcular Alcance Máximo");
            System.out.println("5. Calcular Altura en un Tiempo Específico");
            System.out.println("6. Calcular Tiempo en X para una Distancia Dada");
            System.out.println("7. Calcular Distancia en X para un Tiempo Dado");
            System.out.println("8. Modificar Lógica de Cálculo con Groovy");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("--- Ingreso de Nuevos Datos del Constructor ---");
                    System.out.print("Ingrese el ángulo (en grados): ");
                    angulo = scanner.nextFloat();
                    System.out.print("Ingrese la velocidad en X: ");
                    velocidad_X = scanner.nextFloat();
                    System.out.print("Ingrese la velocidad en Y: ");
                    velocidad_Y = scanner.nextFloat();
                    System.out.print("Ingrese la gravedad: ");
                    gravedad = scanner.nextFloat();
                    tiro = new FisicaTiroParabolico(angulo, velocidad_X, velocidad_Y, gravedad);
                    System.out.println("Datos actualizados correctamente.");
                    break;
                case 2:
                    System.out.println("Altura Máxima: " + tiro.calcularAlturaMaxima());
                    break;
                case 3:
                    System.out.println("Tiempo de Vuelo: " + tiro.calcularTiempoDeVuelo());
                    break;
                case 4:
                    System.out.println("Alcance Máximo: " + tiro.calcularAlcanceMaximo());
                    break;
                case 5:
                    System.out.print("Ingrese el tiempo en segundos: ");
                    float tiempoAltura = scanner.nextFloat();
                    System.out.println("Altura en " + tiempoAltura + " segundos: " + tiro.calcularAlturaEnTiempo(tiempoAltura));
                    break;
                case 6:
                    System.out.print("Ingrese la distancia en metros: ");
                    float distanciaX = scanner.nextFloat();
                    System.out.println("Tiempo en X para " + distanciaX + " metros: " + tiro.calcularTiempoEnX(distanciaX));
                    break;
                case 7:
                    System.out.print("Ingrese el tiempo en segundos: ");
                    float tiempoDistancia = scanner.nextFloat();
                    System.out.println("Distancia en X en " + tiempoDistancia + " segundos: " + tiro.calcularDistanciaEnX(tiempoDistancia));
                    break;
                case 8:
                    // Modificar lógica de cálculo con Groovy
                    GroovyShell shell = new GroovyShell();
                    Binding binding = new Binding();
                    binding.setVariable("tiro", tiro); // Pasar la instancia de FisicaTiroParabolico
                    String groovyCode = """
                        // Redefinir el método calcularAlturaMaxima
                        tiro.metaClass.calcularAlturaMaxima = { ->
                            return (float) (Math.pow(velocidad_Y, 2) / (2 * gravedad)) * 1.5 // Modificación de la lógica
                        }

                        // Redefinir el método calcularAlcanceMaximo
                        tiro.metaClass.calcularAlcanceMaximo = { ->
                            return velocidad_X * calcularTiempoDeVuelo() * 1.1 // Modificación de la lógica
                        }
                    """;
                    shell.evaluate(groovyCode);
                    System.out.println("Lógica de cálculo modificada con Groovy.");
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el programa! Adiós.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}