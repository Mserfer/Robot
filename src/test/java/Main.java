
import org.iesalandalus.programacion.robot.modelo.Consola;
import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.modelo.Zona;

import javax.naming.OperationNotSupportedException;

public class Main {
    private static ControladorRobot controladorRobot;
    private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
        switch (opcion){
            case 1:
                controlarRobotDefecto();
                break;
            case 2:
                controladorRobotZona();
                break;
            case 3:
                controladorRobotZonaOrientacion();
                break;
            case 4:
                controladorRobotZonaOrientacionCoordenada();
                break;
            case 5:
                ejecutarComando();
            case 6:
                Consola.despedirse();
                break;
        }
    }
    private static void controlarRobotDefecto(){
        Robot robotDefecto = new Robot();
        controladorRobot = new ControladorRobot(robotDefecto);
        Consola.mostrarRobot(controladorRobot);
    }
    private static void controladorRobotZona(){
        Robot robotZona = new Robot(Consola.elegirZona());
        controladorRobot = new ControladorRobot(robotZona);
        Consola.mostrarRobot(controladorRobot);
    }

    private static void controladorRobotZonaOrientacion(){
        Robot robotZonaOrientacion = new Robot(Consola.elegirZona(),Consola.elegirOrientacion());
        controladorRobot = new ControladorRobot(robotZonaOrientacion);
        Consola.mostrarRobot(controladorRobot);
    }
    private static void controladorRobotZonaOrientacionCoordenada(){
        Robot robotZonaOrientacionCoordenada = new Robot(Consola.elegirZona(),Consola.elegirOrientacion(),Consola.elegirCoordenada());
        controladorRobot = new ControladorRobot(robotZonaOrientacionCoordenada);
        Consola.mostrarRobot(controladorRobot);
    }
    private static void ejecutarComando() throws OperationNotSupportedException {
        controladorRobot.ejecutar(Consola.elegirComando());
        Consola.mostrarRobot(controladorRobot);
    }

    public static void main(String[] args) throws OperationNotSupportedException {
        int opcion;
        do{
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
            System.out.println();
        }while(opcion !=6);


    }

}
