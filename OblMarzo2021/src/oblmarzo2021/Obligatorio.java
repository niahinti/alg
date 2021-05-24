package oblmarzo2021;

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

    @Override
    //Crea la estructura necesaria para representar el sistema de reservas.
    // no hay errores posibles
    public Retorno crearSistemaReservas() {
        //Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        //inicio listas
        this.aerolineas = new Lista();
        this.ciudades = new Lista();

        //precarga aerolineas Aerolinea(String codigo)
        Aerolinea AA = new Aerolinea("AA");
        Aerolinea LA = new Aerolinea("LA");
        Aerolinea IB = new Aerolinea("IB");

        aerolineas.agregarFinal(new TDato<>(AA));
        aerolineas.agregarFinal(new TDato<>(LA));
        aerolineas.agregarFinal(new TDato<>(IB));

        //precarga ciudades Ciudad(int numero, String nombre)
        //esta parte va a pasar por registrarCiudad antes
        Ciudad MVD = new Ciudad(1, "MVD");
        Ciudad MIA = new Ciudad(1, "MIA");//miami non stop
        Ciudad NYC = new Ciudad(1, "NYC");//new york 1 stop
        Ciudad SCL = new Ciudad(1, "SCL");//santiago non stop
        Ciudad UIO = new Ciudad(1, "UIO");//quito 1 stop
        Ciudad MAD = new Ciudad(1, "MAD");//madrid non stop
        Ciudad FCO = new Ciudad(1, "FCO");//roma 1 stop
        Ciudad FLR = new Ciudad(1, "FLR");//florencia 2 stops, no debe aparecer en 2.16

        ciudades.agregarFinal(new TDato<>(MVD));
        ciudades.agregarFinal(new TDato<>(MIA));
        ciudades.agregarFinal(new TDato<>(NYC));
        ciudades.agregarFinal(new TDato<>(SCL));
        ciudades.agregarFinal(new TDato<>(UIO));
        ciudades.agregarFinal(new TDato<>(MAD));
        ciudades.agregarFinal(new TDato<>(FCO));
        ciudades.agregarFinal(new TDato<>(FLR));

        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        this.aerolineas = null;
        this.ciudades = null;

        return ret;
    }

    @Override
    public Retorno registrarCiudad(int NroCiudad, String Ciudad) {

        //Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        ret.valorString = "ciudad ya existe";

        Ciudad nuevaCiudad = new Ciudad(NroCiudad, Ciudad);
        TDato<Ciudad> n = new TDato<>(nuevaCiudad);
        // recorrer lista ciudades
        ciudades.mostrarDato(n);
        // si encuentra ciudad retornar error y valorString con error
        if (!ciudades.existe(n)) {

            ciudades.agregarFinal(n);
            ret.resultado = OK;
            ret.valorString = "Ciudad " + Ciudad + " agregada con exito";
        }
        return ret;

    }

    @Override
    public Retorno eliminarCiudad(int NroCiudad, String Ciudad) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno registrarVuelo(int numero, String aerolinea, String ciudadOrigen, String ciudadDestino, int estrellas, int capacidad, Calendar fechaHoraSalida, int duracion) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

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
