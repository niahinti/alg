package Listas;

//import java.util.Iterator;
public class ListaOrd implements ILista {

    private NodoLista inicio;
    private NodoLista fin;
    private int limite;
    private int actual;

    //Constructor
    @Override
    public void Lista() {
        this.inicio = null;
        this.fin = null;
        this.actual = 0;
        this.limite = 0;
    }

    //Inicio
    public void setInicio(NodoLista i) {
        inicio = i;
    }

    public NodoLista getInicio() {
        return inicio;
    }

    //Fin
    public void setFin(NodoLista f) {
        fin = f;
    }

    public NodoLista getFin() {
        return fin;
    }

    /**
     * ***Métodos Básicos****
     */
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al principio de la lista
    @Override
    public boolean agregarInicio(TDato n) {
        if (puedoInsertar()) {
            this.actual++;
            NodoLista nuevo = new NodoLista(n);
            nuevo.getSiguiente(inicio);
            this.inicio = nuevo;
            if (this.fin == null)//estoy insertando el primer nodo
            {
                this.fin = nuevo;
            }
            return true;
        }
        return false;
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    @Override
    public boolean agregarFinal(TDato n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.agregarInicio(n);
            } else {
                NodoLista aux = this.inicio;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                NodoLista nuevo = new NodoLista(n);
                aux.getSiguiente(nuevo);
                this.fin = nuevo;
                return true;
            }
        }
        return false;
    }

    //PRE:
    //POS: Borra el primer nodo
    @Override
    public boolean borrarInicio() {
        this.actual--;
        if (!this.esVacia()) {
            this.inicio = this.inicio.getSiguiente();
        }
        return true;
    }

    //PRE:
    //POS: Borra el último nodo
    @Override
    public boolean borrarUltimo() {
        this.actual--;
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();
            } else {
                NodoLista aux = this.inicio;
                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                this.fin = aux;
                this.fin.getSiguiente(null);
            }
        }
        return true;
    }

    //PRE:
    //POS: elimina todos los nodos de una lista dada
    @Override
    public void vaciar() {
        this.actual = 0;
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;
        while (inicio != null) {
            borrarInicio();
        }
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    @Override
    public void mostrar() {
        if (this.esVacia()) {
            System.out.println("Lista es vacía");
        } else {
            NodoLista aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getDato());
                aux = aux.getSiguiente();
            }
        }
    }

    /**
     * ***Otros Métodos (iterativos)****
     */
    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public boolean agregarOrd(TDato n) {
        if (puedoInsertar()) {
            this.actual++;
            //lista vacía o primer elemento es mayor o igual => agrego al ppio
            if (this.esVacia() || this.inicio.getDato().CompareTo(n.getO()) == 1) {
                this.agregarInicio(n);
                return true;
            }
            //último elemento es menor o igual => agrego al final
            if (this.fin.getDato().CompareTo(n.getO()) == -1) {
                this.agregarFinal(n);
                return true;
            }
            NodoLista aux = this.inicio;
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato().CompareTo(n.getO()) == 1) {
                aux = aux.getSiguiente();
            }
            NodoLista nuevo = new NodoLista(n);
            nuevo.getSiguiente(aux.getSiguiente());
            aux.getSiguiente(nuevo);
            return true;
        }
        return false;
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean borrarElemento(Object n) {
        this.actual--;
        if (this.esVacia()) {
            return true;
        }
        if (this.inicio.getDato() == n) {
            this.borrarInicio();
        } else {
            NodoLista aux = this.inicio;
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato() != n) {
                aux = aux.getSiguiente();
            }
            //lo encontré o llegué al final de la lista
            if (aux.getSiguiente() != null) {
                NodoLista borrar = aux.getSiguiente();
                aux.getSiguiente(borrar.getSiguiente());
                borrar.getSiguiente(null);
                return true;
            }
        }
        return false;
    }

    //PRE:
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos() {
        int cont = 0;
        if (!this.esVacia()) {
            NodoLista aux = this.inicio;
            while (aux != null) {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        return cont;
    }

    //PRE: //POS:
    public NodoLista obtenerElemento(Object n) {
        NodoLista aux = this.inicio;
        while (aux != null && aux.getDato() != n) {
            aux = aux.getSiguiente();
        }
        //encontré dato o llegué al final
        return aux;
    }

    /**
     * *** Métodos RECURSIVOS ****
     */
    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoLista l) {
        if (l != null) {
            System.out.println(l.getDato());
            mostrarREC(l.getSiguiente());
        }
    }

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(NodoLista l) {
        if (l != null) {
            mostrarInversoREC(l.getSiguiente());
            System.out.println(l.getDato());
        }
    }

    //PRE:
    //POS: retorna true si el elemento pertenece a la lista
    public boolean existeDatoREC(NodoLista l, Object n) {
        if (l != null) {
            if (l.getDato().CompareTo(n) == 0) {
                return true;
            } else {
                return existeDatoREC(l.getSiguiente(), n);
            }
        } else {
            return false;
        }
    }

    //PRE: Posicion de la lista
    //POS: Object en posicion i.
    public TDato datoEnPos(int i) {
        int contador = 0;
        if (i == 0) {
            return this.inicio.getDato();
        }
        NodoLista ptr = this.inicio;
        while (contador < i) {
            ptr = ptr.getSiguiente();
            contador++;
        }
        return ptr.getDato();
    }

    /**
     * Si actual < a limite, inserto //PRE: -- //POS: True si actualmente no
     * paso el limite de la lista. @return T/F
     */
    public boolean puedoInsertar() {
        if (this.limite == 0) {
            return true;
        }
        return this.limite > this.actual;
    }

    /**
     * @return the limite
     */
    public int getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(int limite) {
        this.limite = limite;
    }

    /**
     * @return the actual
     */
    public int getActual() {
        return actual;
    }

    /**
     * @param actual the actual to set
     */
    public void setActual(int actual) {
        this.actual = actual;
    }

    @Override
    public boolean existe(TDato n) {
        return mostrarDato(n) != null;
    }

    @Override
    public TDato mostrarDato(TDato n) {
        NodoLista aux = inicio;
        while (aux != null) {
            if (aux.getDato().equals(n)) {
                return aux.getDato();
            } else {
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public boolean buscarelemento(TDato n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarOrdenado(NodoVuelo nuevoVuelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrardelultimoalprimero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrardelprimeroalultimo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarRec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodoLista obtenerElemento(TDato n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarelemento(TDato dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
