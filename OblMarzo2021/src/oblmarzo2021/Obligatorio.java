package oblmarzo2021;

import Listas.NodoVuelo;
import Dominio.*;
import Listas.*;
//import Listas.Lista;
//import Listas.TDato;
import java.util.Calendar;
import static oblmarzo2021.Retorno.Resultado.OK;
//import Dominio.Aerolinea;
//import Dominio.Ciudad;

//clase sistema
public class Obligatorio implements IObligatorio {

    //int ciudades[] = {1, 2, 3, 4};
    Lista aerolineas;
    Lista ciudades;
    ListaVuelo lv;

    @Override
    //Crea la estructura necesaria para representar el sistema de reservas.
    // no hay errores posibles
    public Retorno crearSistemaReservas() {
        //Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        //inicio listas
        this.aerolineas = new Lista();
        this.ciudades = new Lista();
        this.lv = new ListaVuelo();

        //precarga aerolineas Aerolinea(String codigo)
        Aerolinea AA = new Aerolinea("AA");
        Aerolinea LA = new Aerolinea("LA");
        Aerolinea IB = new Aerolinea("IB");

        aerolineas.agregarFinal(new TDato<>(AA));
        aerolineas.agregarFinal(new TDato<>(LA));
        aerolineas.agregarFinal(new TDato<>(IB));

        //precarga ciudades Ciudad(int numero, String nombre)
        registrarCiudad(1, "MVD");
        registrarCiudad(1, "MIA");//miami non stop
        registrarCiudad(1, "NYC");//new york 1 stop
        registrarCiudad(1, "SCL");//santiago non stop
        registrarCiudad(1, "UIO");//quito 1 stop
        registrarCiudad(1, "MAD");//madrid non stop
        registrarCiudad(1, "FCO");//roma 1 stop
        registrarCiudad(1, "FLR");//florencia 2 stops, no debe aparecer en 2.16

        //registrarVuelo(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int capacidad, Calendar fechaHoraSalida, int duracion)
        registrarVuelo();

        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        this.aerolineas = null;
        this.ciudades = null;
        this.lv = null;

        return ret;
    }

    @Override
    public Retorno registrarCiudad(int NroCiudad, String Ciudad) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        Ciudad nuevaCiudad = new Ciudad(NroCiudad, Ciudad);
        TDato n = new TDato(nuevaCiudad);
        // recorre lista ciudades
        if (!ciudades.existe(n)) {
            ciudades.agregarFinal(n);
            ret.resultado = OK;
        }
        return ret;
    }

    @Override

    public Retorno eliminarCiudad(int NroCiudad, String Ciudad) {
        if (ciudades.esVacia()) {
            return new Retorno(Retorno.Resultado.ERROR);
        } else {
            Ciudad nuevaCiudad = new Ciudad(NroCiudad, Ciudad);
            TDato n = new TDato(nuevaCiudad);
            if (!ciudades.existe(n)) {
                // no existe la ciudad
                return new Retorno(Retorno.Resultado.ERROR);
            } else {
                if (!lv.esVacia()) {
                    //si lv incluye ciudad en destino u origen
                    //boolean estaAsociada = aerolineas.buscarelemento(n); //lista vuelos capaz deberia ir en aerolinea no en Obligatorio
                    boolean ciudadEncontrada = false;
                    NodoVuelo auxvuelo = lv.getPrimero();

                    while (!ciudadEncontrada || auxvuelo != null) {
                        if (auxvuelo.getCiudadOrigen().equals(Ciudad) || auxvuelo.getCiudadDestino().equals(Ciudad)) {
                            ciudadEncontrada = true;
                        }
                        auxvuelo = auxvuelo.getSiguiente();
                    }

                    if (!ciudadEncontrada) {
                        ciudades.eliminarelemento(n);
                        return new Retorno(Retorno.Resultado.OK);
                    } else {
                        return new Retorno(Retorno.Resultado.ERROR);
                    }
                }
                ciudades.eliminarelemento(n);
                return new Retorno(Retorno.Resultado.OK); //este return esta repetido pero por ahora ta.
            }
        }
    }

    @Override
    public Retorno registrarVuelo(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int capacidad, Calendar fechaHoraSalida, int duracion) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);

        NodoVuelo vuelo = new NodoVuelo(numero, aerolinea, ciudadOrigen, ciudadDestino, estrellas, capacidad, fechaHoraSalida, duracion);
        if (estrellas < 1 || estrellas > 5) {
            return ret;
        }
        if (capacidad < 0 || duracion < 0) {
            return ret;
        }
//        if (!ciudades.existe(ciudadOrigen)) {
//          TODO
//        }

        lv.agregarFinal(vuelo);
        ret.resultado = OK;
        return ret;
    }

    /*
    @Override
    public Retorno registrarVuelo(int numero, String aerolinea,
            String ciudadOrigen, String ciudadDestino,
            int estrellas, int capacidad, Calendar fechaHoraSalida,
            int duracion
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);

        Aerolinea aeroAux = new Aerolinea(aerolinea);
        // TDato n = new TDato(aeroAux);
        //NodoLista aero = aerolineas.obtenerElemento(n);

        Lista vuelosAerolinea = aeroAux.getVuelos();

        Vuelo nuevoVuelo = new Vuelo(numero, aerolinea, ciudadOrigen, ciudadDestino, estrellas, capacidad, fechaHoraSalida, duracion);
        TDato vueloDato = new TDato(nuevoVuelo);
        NodoLista vuelo = new NodoLista(vueloDato);
        if (vuelosAerolinea.buscarelemento(vueloDato)) {
// esto no resuelve pq si le pasas mismo numero y distintas estrellas te lo agrega creo
            return ret;
        }
        if (estrellas < 1 || estrellas > 5) {
            return ret;
        }
        if (capacidad < 0 || duracion < 0) {
            return ret;
        }
//        if (!ciudades.existe(ciudadOrigen)) {
//          TODO
//        }

        vuelosAerolinea.agregarFinal(vueloDato);
        aeroAux.setVuelos(vuelosAerolinea);
        ret.resultado = OK;
        return ret;
    }
     */
    @Override
    public Retorno ingresarServicio(String aerolinea, int numero, String servicio) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno borrarServicio(String aerolinea, int numero, String servicio) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno ingresarComentario(String aerolinea, int numero, String comentario, int ranking) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno realizarReserva(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno cancelarReserva(int cliente, int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno listarServicios(int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno listarVuelosAerolinea(String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno listarAerolineasRanking() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno listarComentarios(int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno listarEspera(int numero, String aerolinea) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno mostrarDuraciones() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno CargarDistancias(int[][] Mapa, String ciudadOrigen, String Ciudaddestino, int duracion) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno BuscarCamino(int[][] Mapa, String origen, String destino) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }
}
