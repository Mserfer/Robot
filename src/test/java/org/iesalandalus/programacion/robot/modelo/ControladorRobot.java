package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;

public class ControladorRobot {

    private Robot robot;

    public ControladorRobot(Robot robot){
        if(robot == null){
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        this.robot = robot;
    }
    public Robot getRobot(){
        return this.robot;
    }

    public void ejecutar(char comando) throws OperationNotSupportedException {
        boolean isValido;
        char comandoMayusculas = (Character.toUpperCase(comando));
        isValido = (comandoMayusculas == 'A'||comandoMayusculas == 'D'|| comandoMayusculas == 'I' );
        if(!isValido){
            throw new OperationNotSupportedException("Comando desconocido.");
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
