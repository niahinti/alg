/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Listas.ListaPasajero;
import java.util.Calendar;

public class Vuelo {

    int numeroVuelo;
    String aerolinea;
    String ciudadOrigen;
    String ciudadDestino;
    int estrellas;
    int cupo;
    Calendar fechaHoraSalida;
    int duracion;
    ListaPasajero lp;

    public Vuelo(int numeroVuelo, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int cupo, Calendar fechaHoraSalida, int duracion) {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.estrellas = estrellas;
        this.cupo = cupo;
        this.fechaHoraSalida = fechaHoraSalida;
        this.duracion = duracion;
        this.lp = new ListaPasajero(cupo);
    }

    public int getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(int numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

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

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public Calendar getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Calendar fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
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
}
