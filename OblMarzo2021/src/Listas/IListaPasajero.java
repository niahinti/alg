
package Listas;

public interface IListaPasajero {
  public boolean esVacia();
  public boolean esLlena();
  public void agregarFinal(int dato,String Nombre); 
  public void borrarUltimo(); 
  public void agregarInicio(int dato,String Nombre);   
  public void borrarInicio();     
  public int cantidad();    
  public void mostrar();  
  public boolean buscarelemento(int dato);
  public NodoPasajero obtenerelemento(int dato); 
  public void eliminarelemento(int dato); 
  public void agregarOrdenado(int dato,String Nombre);
  public void mostrarRec();
}
