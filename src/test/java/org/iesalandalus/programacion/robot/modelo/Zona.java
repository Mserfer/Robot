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
            throw new IllegalArgumentException("ERROR: El ancho es incorrecto");
        }

    }
    private void validarAlto(int alto){
        if(alto > 100 || alto < 10){
            throw new IllegalArgumentException("ERROR: El alto es incorrecto");
        }
    }

    public Coordenada getCentro(){
        int centroX = ancho /2;
        int centroY = alto /2;
        return new Coordenada(ancho, alto);
    }

    public boolean pertenece(Coordenada coordenada){
        if(perteneceX(coordenada.x())&& perteneceY(coordenada.y())){
            return  true;
        }
        return  false;
    }

    private boolean perteneceX(int x){
        return x >= 10 && x <= 100;
    }

    private boolean perteneceY(int y){
        return y >= 10 && y <= 100;
    }
}
