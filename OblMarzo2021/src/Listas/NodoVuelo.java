package Listas;

import java.util.Calendar;

public class NodoVuelo {

    int dato;
    String aerolinea;
    String ciudadOrigen;
    String ciudadDestino;
    int estrellas;
    int cupo;
    Calendar fechaHoraSalida;
    int duracion;
    ListaPasajero lp;
    //Cola ce;
    NodoVuelo siguiente;
    NodoVuelo anterior;

    public NodoVuelo(int dato, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int cupo, Calendar fechaHoraSalida, int duracion) {
        this.dato = dato;
        this.aerolinea = aerolinea;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.estrellas = estrellas;
        this.cupo = cupo;
        this.fechaHoraSalida = fechaHoraSalida;
        this.duracion = duracion;
        this.lp = new ListaPasajero(cupo);
        //this.ce=new Cola(5);// defino cola de espera de 5 personas
        this.siguiente = null;
        this.anterior = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoVuelo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoVuelo siguiente) {
        this.siguiente = siguiente;
    }

    public NodoVuelo getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoVuelo anterior) {
        this.anterior = anterior;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public ListaPasajero getLp() {
        return lp;
    }

    public void setLp(ListaPasajero lp) {
        this.lp = lp;
    }

    /*
    public Cola getCe() {
        return ce;
    }

    public void setCe(Cola ce) {
        this.ce = ce;
    }
     */
    //// ESTOS SE VAN CUANDO ARREGLEMOS EL TEMA GENERICS
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

}
