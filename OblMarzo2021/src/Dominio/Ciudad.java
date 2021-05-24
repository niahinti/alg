/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Camila
 */
public class Ciudad implements Comparable<Ciudad> {

    int numero;
    String nombre;
//    boolean tieneVuelos;

    public Ciudad(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
        //tieneVuelos = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Ciudad c) {
        return this.getNombre().compareTo(c.getNombre()); // -> Por String ascendente
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Ciudad)) {
            return false;
        } else {
            Ciudad c = (Ciudad) obj;
            return c.getNombre().equals(this.getNombre());
        }
    }
}
