
package Listas;

public class NodoPasajero {
    int dato;
    String Nombre;
    NodoPasajero siguiente;

    public NodoPasajero(int dato, String Nombre) {
        this.dato = dato;
        this.Nombre = Nombre;
        this.siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoPasajero getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPasajero siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    
    
}
