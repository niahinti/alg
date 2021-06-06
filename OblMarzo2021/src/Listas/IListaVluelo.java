
package Listas;

public interface IListaVluelo {
  public boolean esVacia();
  public void agregarFinal(NodoVuelo nuevoVuelo); 
  public void borrarUltimo(); 
  public void agregarInicio(NodoVuelo nuevoVuelo);   
  public void borrarInicio();     
  public int cantidad();    
  public void mostrar();  
  public boolean buscarelemento(int dato);
  public NodoVuelo obtenerelemento(int dato); 
  public void eliminarelemento(int dato); 
  public void agregarOrdenado(NodoVuelo nuevoVuelo);
  public void mostrardelultimoalprimero();
  public void mostrardelprimeroalultimo();
  public void mostrarRec();   
}

