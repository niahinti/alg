package oblmarzo2021;

import java.util.Calendar;
//import Dominio.Aerolinea;
//import Dominio.Ciudad;

public class Obligatorio implements IObligatorio {

    //int ciudades[] = {1, 2, 3, 4};
    @Override
    public Retorno crearSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno registrarCiudad(int NroCiudad, String Ciudad) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

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
