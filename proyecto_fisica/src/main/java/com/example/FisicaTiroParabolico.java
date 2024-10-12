package com.example;

public class FisicaTiroParabolico {
    private float angulo;
    private float velocidad_X;
    private float velocidad_Y;
    private float gravedad;

    public FisicaTiroParabolico(float angulo, float velocidad_X, float velocidad_Y, float gravedad) {
        setAngulo(angulo);
        setVelocidad_X(velocidad_X);
        setVelocidad_Y(velocidad_Y);
        setGravedad(gravedad);
    }


    public float getAngulo()
    {
        return angulo;
    }

    public void setAngulo(float angulo) {
        if (angulo>0){
            this.angulo = angulo;
        }else{
            this.angulo = 0;
        }
    }

    public float getVelocidad_X() {
        return velocidad_X;
    }

    public void setVelocidad_X(float velocidad_X) {
        if(velocidad_X>0){
            this.velocidad_X = velocidad_X;
        }else{
            this.velocidad_X = 0;
        }
    }

    public float getVelocidad_Y() {
        return velocidad_Y;
    }

    public void setVelocidad_Y(float velocidad_Y) {
        if(velocidad_Y>0){
            this.velocidad_Y = velocidad_Y;
        }else{
            this.velocidad_Y = 0;
        }
    }

    public float getGravedad() {
        return gravedad;
    }

    public void setGravedad(float gravedad) {
        if(gravedad>0){
            this.gravedad = gravedad;
        }else{
            this.gravedad = 0;
        }
    }




    public float calcularAlturaMaxima() {
        return (float) (Math.pow(velocidad_Y, 2) / (2 * gravedad));
    }


    public float calcularTiempoDeVuelo() {
        return (2 * velocidad_Y) / gravedad;
    }


    public float calcularAlcanceMaximo() {
        return velocidad_X * calcularTiempoDeVuelo();
    }


    public float calcularAlturaEnTiempo(float tiempo) {
        return (velocidad_Y * tiempo) - (0.5f * gravedad * (float)Math.pow(tiempo, 2));
    }


    public float calcularTiempoEnX(float distancia) {
        if (velocidad_X > 0) {
            return distancia / velocidad_X;
        } else {
            throw new IllegalArgumentException("La velocidad en X debe ser mayor que 0");
        }
    }


    public float calcularDistanciaEnX(float tiempo) {
        return velocidad_X * tiempo;
    }


}
