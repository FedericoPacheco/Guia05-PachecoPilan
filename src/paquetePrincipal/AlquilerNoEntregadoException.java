package paquetePrincipal;

@SuppressWarnings("serial") 
public class AlquilerNoEntregadoException extends Exception 
{
	public AlquilerNoEntregadoException() 
	{
		super("No se pueden realizar mas alquileres. Cantidad maxima admitida: " + Usuario.maximaCantidadAlquileresEnSimultaneo);
	}
}
