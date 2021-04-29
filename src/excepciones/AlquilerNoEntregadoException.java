package excepciones;

import clases.Usuario;

@SuppressWarnings("serial") 
public class AlquilerNoEntregadoException extends Exception 
{
	public AlquilerNoEntregadoException() 
	{
		super("Error. No se pueden realizar mas alquileres. Cantidad maxima admitida: " + Usuario.maximaCantidadAlquileresEnSimultaneo);
	}
}
