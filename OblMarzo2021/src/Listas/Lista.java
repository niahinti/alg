package Listas;

public class Lista implements ILista {

    private NodoLista primero;
    private NodoLista ultimo;
    private int limite;
    private int cantidad;

    //Constructor
    @Override
    public void Lista() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
        this.limite = 0;
    }

    //Inicio
    public void setPrimero(NodoLista i) {
        primero = i;
    }

    public NodoLista getPrimero() {
        return primero;
    }

    //Fin
    public void setUltimo(NodoLista f) {
        ultimo = f;
    }

    public NodoLista getUltimo() {
        return ultimo;
    }

    /**
     * ***Métodos Básicos****
     */
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    @Override
    public boolean esVacia() {
        return this.primero == null;
    }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    @Override
    public boolean agregarInicio(TDato n) {
        if (puedoInsertar()) {
            this.cantidad++;
            NodoLista nuevo = new NodoLista(n);
            nuevo.getSiguiente(primero);
            this.primero = nuevo;
            if (this.ultimo == null)//estoy insertando el primer nodo
            {
                this.ultimo = nuevo;
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
            this.cantidad++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.agregarInicio(n);
            } else {
                NodoLista aux = this.primero;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                NodoLista nuevo = new NodoLista(n);
                aux.getSiguiente(nuevo);
                this.ultimo = nuevo;
                return true;
            }
        }
        return false;
    }

    //PRE:
    //POS: Borra el primer nodo
    @Override
    public boolean borrarInicio() {
        this.cantidad--;
        if (!this.esVacia()) {
            this.primero = this.primero.getSiguiente();
        }
        return true;
    }

    //PRE:
    //POS: Borra el último nodo
    @Override
    public boolean borrarUltimo() {
        this.cantidad--;
        if (!this.esVacia()) {
            if (this.primero == this.ultimo) {
                this.borrarInicio();
            } else {
                NodoLista aux = this.primero;
                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                this.ultimo = aux;
                this.ultimo.getSiguiente(null);
            }
        }
        return true;
    }

    //PRE:
    //POS: elimina todos los nodos de una lista dada
    @Override
    public void vaciar() {
        this.cantidad = 0;
        //en java alcanza con apuntar primero y ultimo a null
        //inicio=ultimo=null;
        while (primero != null) {
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
            NodoLista aux = this.primero;
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
            this.cantidad++;
            //lista vacía o primer elemento es mayor o igual => agrego al ppio
            if (this.esVacia() || this.primero.getDato().CompareTo(n.getO()) == 1) {
                this.agregarInicio(n);
                return true;
            }
            //último elemento es menor o igual => agrego al final
            if (this.ultimo.getDato().CompareTo(n.getO()) == -1) {
                this.agregarFinal(n);
                return true;
            }
            NodoLista aux = this.primero;
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
        this.cantidad--;
        if (this.esVacia()) {
            return true;
        }
        if (this.primero.getDato() == n) {
            this.borrarInicio();
        } else {
            NodoLista aux = this.primero;
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
            NodoLista aux = this.primero;
            while (aux != null) {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        return cont;
    }

    /**
     * *** Metodos RECURSIVOS ****
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
            return this.primero.getDato();
        }
        NodoLista ptr = this.primero;
        while (contador < i) {
            ptr = ptr.getSiguiente();
            contador++;
        }
        return ptr.getDato();
    }

    /**
     * Si cantidad < a limite, inserto //PRE: -- //POS: True si actualmente no
     * paso el limite de la lista. @return T/F
     */
    public boolean puedoInsertar() {
        if (this.limite == 0) {
            return true;
        }
        return this.limite > this.cantidad;
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
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean existe(TDato n) {
        return mostrarDato(n) != null;
    }

    @Override
    public TDato mostrarDato(TDato n) {
        NodoLista aux = primero;
        while (aux != null) {
//            System.out.println(aux.getDato());
//            System.out.println("------------");
//            System.out.println(n);

            if (aux.getDato().getO().equals(n.getO())) {
                return aux.getDato();
            } else {
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    //PRE: //POS:
    public NodoLista obtenerElemento(TDato n) {
        NodoLista aux = this.primero;
        while (aux != null && aux.getDato() != n) {
            aux = aux.getSiguiente();
        }
        //encontré dato o llegué al final
        return aux;
    }

    @Override
    public boolean buscarelemento(TDato n) {
        NodoLista aux = this.getPrimero();
        if (this.primero.getDato() == n || this.ultimo.getDato() == n) {
            return true;
        }
        while (aux != null && aux.getDato() != n) {
            aux = aux.getSiguiente();
        }
        if (aux == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void eliminarelemento(TDato dato) {
        if (!this.esVacia()) {
            NodoLista aux = this.obtenerElemento(dato);
            if (aux != null) {
                if (aux == this.getPrimero()) {
                    this.borrarInicio();
                } else {
                    if (aux == this.getUltimo()) {
                        this.borrarUltimo();
                    } else {
                        aux.anterior.setSiguiente(aux.getSiguiente());
                        aux.siguiente.setAnterior(aux.getAnterior());
                        this.cantidad--;
                    }
                }
            }
        }
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

}
