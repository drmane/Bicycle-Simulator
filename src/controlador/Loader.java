package controlador;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Permite acceder a la entrada de teclado y de archivos
 * @author Daniel y Daniel
 *
 */
public class Loader {
	
	//para la lectura de archivos
	private BufferedReader entrada;
	
	//para la lectura de teclado cuando se quiere usar el metodo avaliable 
	private DataInputStream entradaTeclado;
	
	
	/**
	 * Constructor por defecto
	 */
	public Loader()//por defecto leera de teclado
	{
		entradaTeclado = new DataInputStream(System.in); //teclado para el metodo avaliable
		entrada = new BufferedReader( new InputStreamReader(System.in)); //teclado sin el metodo avaliable
	}
	
	/**
	 * Constructor con un argumento
	 * @param StringEntrada nombre de la entrada(System.in para teclado y el resto lo comprobara como el nombre del archivo)
	 */
	public Loader(String stringEntrada)
	{
		if(stringEntrada.equals("System.in"))
		{
			entradaTeclado = new DataInputStream(System.in);
			entrada = new BufferedReader( new InputStreamReader(System.in));
		}
		else //sino, mira haber si es el nombre un archivo
		{
			entradaTeclado = null;
			//usar el 
			try
			{
				entrada = new BufferedReader(new FileReader(stringEntrada));
			}
			catch ( IOException e )
			{
				 System.err.println (e) ; //no se encuentra el archivo
			}
		}
		
	}
	
	/**
	 * Lee una linea 
	 * @return El contenido de la linea leida como String
	 */
	public String leerLinea()
	{
		String lineaLeida = "";
		
		try
		{
			
			lineaLeida = entrada.readLine();
			
		}
		catch(IOException e)
		{
			System.err.println(e); //se muestra la escepcion producida
		}
		
		return lineaLeida;
	}
	
	/**
	 * Lee una linea 
	 * @return La linea leida como StringTokenizer
	 */
	public StringTokenizer leerLineaTokens()
	{
		String lineaLeida = "";
		
		try
		{
			
			lineaLeida = entrada.readLine();
			
		}
		catch(IOException e)
		{
			System.err.println(e); //se muestra la escepcion producida
		}
		
		return new StringTokenizer(lineaLeida," \n \t \r \f "); //devuelve el string leido pero de tokens
	}
	
	/**
	 * Devuelve el primer token de un string
	 * @param LineaTokens el String de tokens que debe tratar
	 * @return El primer token del string
	 */
	public String primerToken(String lineaTokens)
	{
		StringTokenizer lineaTokensAuxiliar = new StringTokenizer(lineaTokens, "\n"); //pasa de String a StringTokenizer
		
		
		return lineaTokensAuxiliar.nextToken(); //coge el primer elemento
	}
	
	/**
	 * Permite leer un archivo enetero (solo se puede usar si lo que se abre es un archivo de texto)
	 * No disponible si se usa la clase Loader como entrada de teclado
	 * @return Devuelve un string con el archivo leido
	 */
	public String leerArchivo()
	{
		String archivoLeido = "";
		
		try
		{		
			
			while (entrada.ready()) //mientras este preparado el archivo
				archivoLeido += entrada.readLine() + "\n"; //a�ade el salto de linea al final de cada linea leida
			
		}
		catch( IOException e ) //trata si se produce una excepcion
		{
			System.err.println(e + "No se ha encontrado el archivo" ) ; //no se encuentra el archivo
		}
		
		return archivoLeido;
	}
	
	
	/**
	 * Permite leer una linea si esta disponible (No produce interrupciones)
	 * No disponible si se usa la clase Loader para archivos de texto
	 * @return La linea leida como String
	 */
	public String leerDisponible()
	{
		String lineaLeida = "";
		
		try
		{
			if(entradaTeclado.available() > 0)
				lineaLeida = leerLinea();	
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
		
		return lineaLeida;
	}
	
	/**
	 * Cierra el flujo de entrada
	 */
	public void cerrarLoader()
	{
		try
		{
                        if(entrada != null)
                            entrada.close();
                        
                        if(entradaTeclado != null)
                            entradaTeclado.close();
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}

}
