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
    boolean borrarFin();

    //POS: Muestra los datos de la lista
    void mostrar();

    //POS: Elimina todos los nodos de la lista
    void vaciar();
}
