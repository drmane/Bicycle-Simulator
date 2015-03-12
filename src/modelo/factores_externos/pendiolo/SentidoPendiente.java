/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factores_externos.pendiolo;

/**
 * El sentido de la pendiente
 *
 * @author Daniel
 */
public enum SentidoPendiente {

    ASCENDENTE(-1), DESCENDENTE(1), LLANO(0), NULO(0);
    //ascendente es negativo por que la aceleracion producida cuando asciendes es negativa
    int factor;

    /**
     * El constructor del enumerado.
     * El constructor debe ser privado
     * @param factorViento un entero indicatorio del enumerado
     */
    private SentidoPendiente(int factorViento) //*constructor del enumerado, el modificador de acceso del constructor debe ser privado
    {
        factor = factorViento;
    }

    public int getFactor() {
        return factor;
    }

    /**
     * Devuelve el enumerado en funcion del string
     * @param sentido el string que se quiere pasar a enumerado
     * @return el enumerado correspondiente al string
     */
    public static SentidoPendiente getEnum(String sentido)
    {
        SentidoPendiente sentidoAuxiliar = NULO; //se inicializa a nulo

        if (sentido != null) //si el nombre de la pendiente no es nulo
        {
            for (SentidoPendiente elementoPendiente : SentidoPendiente.values()) {
                if (sentido.equalsIgnoreCase(elementoPendiente.name())) {
                    sentidoAuxiliar = elementoPendiente;
                }
            }
        }

        return sentidoAuxiliar;
    }

    /**
     * calcula el sentido de la pendiente en funcion del sentido como entero
     * @param n el entero que se quiere calcular el sentido
     * @return el sentido como enumerado
     */
    public static SentidoPendiente calcularEnum(double n) {
        SentidoPendiente sentido;

        if (n < 0) {
            sentido = ASCENDENTE;
        } else if (n == 0) {
            sentido = LLANO;
        } else {
            sentido = DESCENDENTE;
        }

        return sentido;
    }
}
