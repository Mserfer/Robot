package org.iesalandalus.programacion.robot.modelo;

public record Zona(int ancho, int alto) {

    public static int ANCHO_MINIMO = 10;
    public static int ANCHO_MAXIMO = 100;
    public static int ALTO_MINIMO = 10;
    public static int ALTO_MAXIMO = 100;

    public Zona(int ancho, int alto){
        validarAlto(alto);
        validarAncho(ancho);
        this.alto = alto;
        this.ancho = ancho;
    }

    public Zona(){
        this(10, 10);
    }



    private void validarAncho(int ancho){
        if(ancho > 100 || ancho < 10){
            throw new IllegalArgumentException("Ancho no válido.");
        }

    }
    private void validarAlto(int alto){
        if(alto > 100 || alto < 10){
            throw new IllegalArgumentException("Alto no válido.");
        }
    }

    public Coordenada getCentro(){
        int centroX = ancho /2;
        int centroY = alto /2;
        return new Coordenada(centroX, centroY);
    }

    public boolean pertenece(Coordenada coordenada){
        if(coordenada == null) {
            throw new NullPointerException("La coordenada no puede ser nula.");
        }else if(!perteneceY(coordenada.y())|| !perteneceX(coordenada.x())){
            return false;
        }
        return true;
    }

    private boolean perteneceX(int x){
        return  x >= 0 && x < ancho;
    }

    private boolean perteneceY(int y){
        return y >= 0 && y < alto;
    }
}
