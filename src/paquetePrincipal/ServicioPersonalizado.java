package paquetePrincipal;

public class ServicioPersonalizado extends Servicio
{
	private static Integer contadorIds = 0;
	
	public ServicioPersonalizado(String nombre, Oficio oficio) 
	{
		super(nombre, oficio);
		this.id = contadorIds++;
	}
}
