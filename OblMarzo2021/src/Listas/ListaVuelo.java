package Listas;

public class ListaVuelo implements IListaVluelo {

    NodoVuelo primero;
    NodoVuelo ultimo;
    int cantidad;

    public ListaVuelo() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
    }

    public NodoVuelo getPrimero() {
        return primero;
    }

    public void setPrimero(NodoVuelo primero) {
        this.primero = primero;
    }

    public NodoVuelo getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoVuelo ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean esVacia() {
        return this.getCantidad() == 0;
    }

    @Override
    public void agregarFinal(NodoVuelo nuevoVuelo) {
        if (this.esVacia()) {
            this.setPrimero(nuevoVuelo);
            this.setUltimo(nuevoVuelo);
        } else {
            this.ultimo.setSiguiente(nuevoVuelo);
            nuevoVuelo.setAnterior(this.ultimo);
            this.setUltimo(nuevoVuelo);
        }
        this.cantidad++;
    }

    @Override
    public void borrarUltimo() {
        if (!this.esVacia()) {
            if (this.cantidad == 1) {
                this.setPrimero(null);
                this.setUltimo(null);
            } else {
                this.ultimo = this.ultimo.anterior;
                this.ultimo.siguiente = null;
            }
            this.cantidad--;
        }
    }

    @Override
    public void agregarInicio(NodoVuelo nuevoVuelo) {
        if (this.esVacia()) {
            this.setPrimero(nuevoVuelo);
            this.setUltimo(nuevoVuelo);
        } else {
            nuevoVuelo.setSiguiente(this.getPrimero());
            this.getPrimero().setAnterior(nuevoVuelo);
            this.setPrimero(nuevoVuelo);
        }
        this.cantidad++;
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (this.cantidad == 1) {
                this.setPrimero(null);
                this.setUltimo(null);
            } else {
                this.setPrimero(this.primero.getSiguiente());
                this.getPrimero().setAnterior(null);
            }
            this.cantidad--;
        }

    }

    @Override
    public void agregarOrdenado(NodoVuelo nuevoVuelo) {
        if (this.esVacia() || nuevoVuelo.dato<this.getPrimero().getDato()){
            this.agregarInicio(nuevoVuelo);
        }else{
            if (nuevoVuelo.dato > this.getUltimo().getDato()){
                this.agregarFinal(nuevoVuelo);
            }else{
                NodoVuelo aux= this.getPrimero();
                while (aux!=null && nuevoVuelo.dato > aux.getDato()){
                    aux=aux.getSiguiente();
                }
                nuevoVuelo.setSiguiente(aux);
                nuevoVuelo.setAnterior(aux.getAnterior());
                aux.setAnterior(nuevoVuelo);   
                nuevoVuelo.getAnterior().setSiguiente(nuevoVuelo);
                this.cantidad++;
            }
        }
    }

    @Override
    public int cantidad() {
        return this.getCantidad();
    }

    @Override
    public void mostrar() {
        NodoVuelo aux = this.getPrimero();
        while (aux != null) {
            System.out.print(aux.getDato() + " -  aerolinea : "+ aux.aerolinea +" con cupo "+aux.cupo+ "\n" );
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    @Override
    public boolean buscarelemento(int dato) {
        NodoVuelo aux = this.getPrimero();
        if (this.primero.getDato() == dato || this.ultimo.getDato() == dato) {
            return true;
        }
        while (aux != null && aux.getDato() != dato) {
            aux = aux.getSiguiente();
        }
        if (aux == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public NodoVuelo obtenerelemento(int dato) {
        NodoVuelo aux = this.getPrimero();
        while (aux != null && aux.getDato() != dato) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    @Override
    public void eliminarelemento(int dato) {
        if (!this.esVacia()) {
            NodoVuelo aux = this.obtenerelemento(dato);
            if (aux != null) {
                if (aux == this.getPrimero()) {
                    this.borrarInicio();
                } else {
                    if (aux == this.getUltimo()) {
                        this.borrarUltimo();
                    }else{
                        aux.anterior.setSiguiente(aux.getSiguiente());
                        aux.siguiente.setAnterior(aux.getAnterior());
                        this.cantidad--;                         
                    }
                }
            }
        }
    }

    @Override
    public void mostrardelultimoalprimero() {
        NodoVuelo aux = this.getPrimero();
        while (aux != null) {
            System.out.print(aux.getDato() + " - ");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    @Override
    public void mostrardelprimeroalultimo() {
     NodoVuelo aux = this.getUltimo();
        while (aux != null) {
            System.out.print(aux.getDato() + " - ");
            aux = aux.getAnterior();
        }
        System.out.println();
    }

    @Override
    public void mostrarRec() {
        System.out.println(mostrarRec(this.getPrimero(),this.getUltimo()));

    }
    
    public String mostrarRec(NodoVuelo primero, NodoVuelo ultimo) {
        if (primero==ultimo)
            return " "+ primero.getDato();
       return     mostrarRec(primero.getSiguiente(),ultimo) +  " - " + primero.getDato()   ;
            

    }    
    

}
