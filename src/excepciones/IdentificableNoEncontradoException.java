package excepciones;

@SuppressWarnings("serial")
public class IdentificableNoEncontradoException extends Exception
{
	public IdentificableNoEncontradoException()
	{
		super("Error. Id no encontrado.");
	}
		
}
