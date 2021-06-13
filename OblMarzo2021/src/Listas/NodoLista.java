package Listas;

public class NodoLista {

    private TDato dato;
    NodoLista siguiente;
    NodoLista anterior;

    public NodoLista(TDato n) {
        this.dato = n;
        this.siguiente = null;
    }

    //set y get
    public TDato getDato() {
        return this.dato;
    }

    public void setDato(TDato d) {
        this.dato = d;
    }

    public NodoLista getSiguiente() {
        return this.siguiente;
    }

    public void setSiguiente(NodoLista s) {
        this.siguiente = s;
    }

    public NodoLista getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoLista anterior) {
        this.anterior = anterior;
    }

    NodoLista getSiguiente(NodoLista primero) { // siguiente al primero
        return primero.siguiente;
    }
}
