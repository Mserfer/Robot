package org.iesalandalus.programacion.robot.modelo;

public class ControladorRobot {

    private Robot robot;

    public ControladorRobot(Robot robot){
        this.robot = robot;
    }
    public Robot getRobot(){
        return this.robot;
    }

    public void ejecutar(char comando){
        boolean isValido;
        char comandoMayusculas = (Character.toUpperCase(comando));
        isValido = (comandoMayusculas!= 'A'||comandoMayusculas != 'D'|| comandoMayusculas != 'I' )? false:true;
        if(!isValido){
            throw new IllegalArgumentException("ERROR: El comando no es valido");
        }
        switch (comandoMayusculas){
            case 'A':
                robot.avanzar();
                break;
            case 'D':
                robot.girarALaDerecha();
                break;
            case 'I':
                robot.girarALaIzquierda();
                break;
        }
    }
}
