package oblmarzo2021;

import Dominio.*;
import Listas.*;

public class OblMarzo2021 {

    public static void main(String[] args) {
        // TODO code application logic here
        Prueba p = new Prueba();
        Obligatorio o = new Obligatorio();
        juegodeprueba(p, o);
    }

    public static void juegodeprueba(Prueba p, Obligatorio o) {
        p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "se creo el sistema de reservas");
        p.ver(o.registrarCiudad(1, "Monevideo").resultado, Retorno.Resultado.OK, "Se registro Montevideo");
        p.ver(o.registrarCiudad(1, "Monevideo").resultado, Retorno.Resultado.ERROR, "Se intenta registrar Montevideo que ya existe");

        p.inicializarResultadosPrueba();
    }

}
