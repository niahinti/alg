/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Listas.*;

/**
 *
 * @author Camila
 */
public class Aerolinea {

    String codigo;
    int ranking;
    Lista vuelos;

    public Aerolinea(String codigo) {
        this.codigo = codigo;
        this.ranking = 0;
        this.vuelos = new Lista();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Lista getVuelos() {
        return vuelos;
    }

    public void setVuelos(Lista vuelos) {
        this.vuelos = vuelos;
    }

}
