import com.example.FisicaTiroParabolico

class Main {
    static void main(String[] args) {

        def fisica = new FisicaTiroParabolico(30, 20, 25, 9.81)


        println "Altura máxima original: ${fisica.calcularAlturaMaxima()}"
        println "Tiempo de vuelo original: ${fisica.calcularTiempoDeVuelo()}"
        println "Alcance máximo original: ${fisica.calcularAlcanceMaximo()}"


        fisica.metaClass.calcularAlturaMaxima = { ->
            // Nueva lógica, por ejemplo, multiplicar el resultado original por 2
            return (float) (Math.pow(velocidad_Y, 2) / (2 * gravedad)) * 2
        }


        fisica.metaClass.calcularAlcanceMaximo = { ->
            // Nueva lógica para el alcance
            return velocidad_X * calcularTiempoDeVuelo() + 10 // Agregamos un offset de 10
        }


        println "Altura máxima modificada: ${fisica.calcularAlturaMaxima()}"
        println "Alcance máximo modificado: ${fisica.calcularAlcanceMaximo()}"
    }
}