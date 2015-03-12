/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.factores_externos.eolo;

/**
 *
 * @author usuario_local
 */
public enum SentidoViento {
    AFAVOR(1), ENCONTRA(-1), LATERAL(0), NULO(0); //son doubles

	int factor;
	
	/**
	 * Constructor privado del enumerado Viento
	 * @param factorViento
	 */
	private SentidoViento(int factorViento) //*constructor del enumerado, el modificador de acceso del constructor debe ser privado
	{
		factor = factorViento;      
	}

	/**
	 * Permite coger el atributo factor
	 * @return el factor del enumerado
	 */
	public int getFactor() {
		return factor;
	}
	
	/**
	 * Permite convertir un string en un elemento del enumerado Viento
	 * @param viento string que se quiere convertir a elemento del enumerado Viento
	 * @return el elemento del enumerado Viento
	 */
	public static SentidoViento getEnum(String sentido)//convierte un string a viento
	{
		SentidoViento sentidoAuxiliar = NULO; //se inicializa a nulo
		
		if(sentido != null) //si el nombre del viento no es nulo
			for(SentidoViento elementoViento: SentidoViento.values()) //recorre todos los valores del enumerado viento
				if(sentido.equalsIgnoreCase(elementoViento.name()))//si algun elemento del enumerado coincide con el nombre del viento pasado por parametro
						sentidoAuxiliar = elementoViento; //el vientoAuxiliar es ese elemento del enumerado
			
		return sentidoAuxiliar;	
	}
    
}
