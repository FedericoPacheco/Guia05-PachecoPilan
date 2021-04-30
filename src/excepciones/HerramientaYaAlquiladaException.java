package excepciones;

@SuppressWarnings("serial")
public class HerramientaYaAlquiladaException extends Exception 
{
	public HerramientaYaAlquiladaException(Integer idHerramienta, String nombreHerramienta)
	{
		super("Error. La herramienta: " + nombreHerramienta + " (id: " + idHerramienta + ") ya esta alquilada.");
	}
}
