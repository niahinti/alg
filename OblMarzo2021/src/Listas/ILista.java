package Listas;

public interface ILista {

    //POS: Constructor, crea una lista vacía
    void Lista();

    //POS: Retorna true si la lista no tiene nodos
    boolean esVacia();

    //POS: Inserta un nodo al principio de la lista
    boolean agregarInicio(TDato n);

    //POS: Inserta un nodo al final de la lista
    boolean agregarFinal(TDato n);

    //POS: Borra el primer nodo
    boolean borrarInicio();

    //POS: Borra el último nodo
    boolean borrarUltimo();

    //POS: Muestra los datos de la lista
    void mostrar();

    public boolean buscarelemento(TDato n);

    public NodoLista obtenerElemento(TDato n);

    //POS: Elimina todos los nodos de la lista
    void vaciar();

    //POS: checkea si nodo existe en lista
    boolean existe(TDato n);

    //POS: Muestra un dato de la lista
    TDato mostrarDato(TDato n);

    public void eliminarelemento(TDato dato);

    public void agregarOrdenado(NodoVuelo nuevoVuelo);

    public void mostrardelultimoalprimero();

    public void mostrardelprimeroalultimo();

    public void mostrarRec();
}
