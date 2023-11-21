package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;

public class Robot {
    private Coordenada coordenada;
    private Zona zona;
    private Orientacion orientacion;

    public Robot(){
        zona = new Zona();
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;

    }
    public Robot(Zona zona){
        setZona(zona);
        coordenada = zona.getCentro();
        orientacion = Orientacion.NORTE;
    }

    public Robot(Zona zona, Orientacion orientacion){

        setZona(zona);
        coordenada = zona.getCentro();
        setOrientacion(orientacion);

    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada){
        setZona(zona);
        setCoordenada(coordenada);
        setOrientacion(orientacion);
    }

    public Robot(Robot robot){
        if(robot == null){
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        setZona(robot.getZona());
        setOrientacion(robot.getOrientacion());
        setCoordenada(robot.getCoordenada());

    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) {
        if(coordenada == null){
            throw new NullPointerException("La coordenada no puede ser nula.");
        }else if(!zona.pertenece(coordenada)){
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        if(zona == null){
            throw new NullPointerException("La zona no puede ser nula.");
        }
        this.zona = zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        if(orientacion == null){
            throw new NullPointerException("La orientación no puede ser nula.");
        }
        this.orientacion = orientacion;
    }

    public void avanzar() throws OperationNotSupportedException {

        int nuevaX;
        int nuevaY;
        Coordenada nuevaCoordenada = null;

        switch (orientacion){
            case NORTE :
                nuevaY = getCoordenada().y() + 1;
                nuevaCoordenada = new Coordenada(getCoordenada().x(), nuevaY);
                break;
            case NORESTE:
                nuevaX = getCoordenada().x() + 1;
                nuevaY = getCoordenada().y() + 1;
                nuevaCoordenada = new Coordenada(nuevaX, nuevaY);
                break;
            case ESTE:
                nuevaX = getCoordenada().x() + 1;
                nuevaCoordenada = new Coordenada(nuevaX, getCoordenada().y());
                break;
            case SURESTE:
                nuevaX = getCoordenada().x() + 1;
                nuevaY = getCoordenada().y() - 1;
                nuevaCoordenada = new Coordenada(nuevaX, nuevaY);
                break;
            case SUR:
                nuevaY = getCoordenada().y() - 1;
                nuevaCoordenada = new Coordenada(getCoordenada().x(), nuevaY);
                break;
            case SUROESTE:
                nuevaX = getCoordenada().x() - 1;
                nuevaY = getCoordenada().y() -1 ;
                nuevaCoordenada = new Coordenada(nuevaX, nuevaY);
                break;
            case OESTE:
                nuevaX = getCoordenada().x() - 1;
                nuevaCoordenada = new Coordenada(nuevaX, getCoordenada().y());
                break;
            case NOROESTE:
                nuevaX = getCoordenada().x() - 1;
                nuevaY = getCoordenada().y() + 1;
                nuevaCoordenada = new Coordenada(nuevaX, nuevaY);
                break;

        }

        if(!zona.pertenece(nuevaCoordenada)){
            throw new OperationNotSupportedException("No se puede avanzar, ya que se sale de la zona.");
        }
        coordenada = nuevaCoordenada;


    }

    public void girarALaDerecha(){

        switch (getOrientacion()){
            case NORTE:
                setOrientacion(Orientacion.NORESTE);
                break;
            case NORESTE:
                setOrientacion(Orientacion.ESTE);
                break;
            case ESTE:
                setOrientacion(Orientacion.SURESTE);
                break;
            case SURESTE:
                setOrientacion(Orientacion.SUR);
                break;
            case SUR:
                setOrientacion(Orientacion.SUROESTE);
                break;
            case SUROESTE:
                setOrientacion(Orientacion.OESTE);
                break;
            case OESTE:
                setOrientacion(Orientacion.NOROESTE);
                break;
            case NOROESTE:
                setOrientacion(Orientacion.NORTE);
                break;
        }



    }

    public void girarALaIzquierda(){

        switch (getOrientacion()){
            case NORTE:
                setOrientacion(Orientacion.NOROESTE);
                break;
            case NORESTE:
                setOrientacion(Orientacion.NORTE);
                break;
            case ESTE:
                setOrientacion(Orientacion.NORESTE);
                break;
            case SURESTE:
                setOrientacion(Orientacion.ESTE);
                break;
            case SUR:
                setOrientacion(Orientacion.SURESTE);
                break;
            case SUROESTE:
                setOrientacion(Orientacion.SUR);
                break;
            case OESTE:
                setOrientacion(Orientacion.SUROESTE);
                break;
            case NOROESTE:
                setOrientacion(Orientacion.OESTE);
                break;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (coordenada != null ? !coordenada.equals(robot.coordenada) : robot.coordenada != null) return false;
        if (zona != null ? !zona.equals(robot.zona) : robot.zona != null) return false;
        return orientacion == robot.orientacion;
    }

    @Override
    public int hashCode() {
        int result = coordenada != null ? coordenada.hashCode() : 0;
        result = 31 * result + (zona != null ? zona.hashCode() : 0);
        result = 31 * result + (orientacion != null ? orientacion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "coordenada=" + coordenada +
                ", zona=" + zona +
                ", orientacion=" + orientacion +
                '}';
    }
}
