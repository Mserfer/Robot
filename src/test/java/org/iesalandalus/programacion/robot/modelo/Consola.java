package org.iesalandalus.programacion.robot.modelo;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola(){};

    public static void mostrarMenuPrincipal(){
        System.out.println("----MENU----");
        System.out.println("1.Controlar robot por defecto");
        System.out.println("2.Controlar robot indicando su zona");
        System.out.println("3.Controlar robot indicando su zona  y orientación.");
        System.out.println("4.Controlar robot indicando su zona, orientación y coordenada inicial.");
        System.out.println("5.Ejecutar comando.");
        System.out.println("6.Salir");
    }

    public static int elegirOpcion(){

        int opcion;

        do{
            mostrarMenuPrincipal();
            System.out.println();
            System.out.print("Elija una opción indicando su numero: ");
            opcion = Entrada.entero();

        }while(opcion < 1 || opcion > 6);

        return opcion;

    }

    public static Zona elegirZona(){
        Zona zona;
        do{
            System.out.print("Introduzca el ancho de la zona: ");
            int ancho = Entrada.entero();
            System.out.println();
            System.out.print("Introduzca el alto de la zona: ");
            int alto = Entrada.entero();
            zona = new Zona(ancho, alto);


        }while(zona == null);
        return zona;
    }

    public static void mostrarMenuOrientación(){
        System.out.println("---MENU ORIENTACIÓN---");
        System.out.println("En este menu podrá ver todas las orientaciones disponibles.");
        for (int i = 0; i < Orientacion.values().length; i++) {
            System.out.println(i+1+"."+Orientacion.values()[i]);
        }

    }

    public static Orientacion elegirOrientacion(){
        int opcion;
        do{
            mostrarMenuOrientación();
            System.out.print("Elija una opción indicando su numero: ");
            opcion = Entrada.entero();

        }while(opcion > Orientacion.values().length+1|| opcion < 1);
        return Orientacion.values()[opcion-1];
    }
    public static Coordenada elegirCoordenada(){
        System.out.print("Elija el valor de la X: ");
        int x = Entrada.entero();
        System.out.print("Elija el valor de la Y: ");
        int y = Entrada.entero();
        return new Coordenada(x,y);
    }
    public static char elegirComando(){
        System.out.println("Elija el comando a ejecutar[Avanzar(A), girar derecha(D), girar izquierda(I)");
        System.out.print("Comando: ");
        char comando = Entrada.caracter();
        return comando;
    }

    public static void mostrarRobot(ControladorRobot controladorRobot){
        if(controladorRobot == null){
            throw new NullPointerException("El robot es nulo.");
        }
        System.out.println(controladorRobot.getRobot().toString());

    }
    public static void despedirse(){
        System.out.println("Qué la fuerza te acompañe");
    }
}
